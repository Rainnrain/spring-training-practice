package com.cydeo.controller;

import com.cydeo.dto.AddressDTO;
import com.cydeo.dto.ResponseWrapper;
import com.cydeo.dto.TeacherDTO;
import com.cydeo.service.AddressService;
import com.cydeo.service.ParentService;
import com.cydeo.service.StudentService;
import com.cydeo.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class SchoolController {

    private final TeacherService teacherService;
    private final StudentService studentService;
    private final ParentService paretntService;
    private final AddressService addressService;

    public SchoolController(TeacherService teacherService, StudentService studentService, ParentService paretntService, AddressService addressService) {
        this.teacherService = teacherService;
        this.studentService = studentService;
        this.paretntService = paretntService;
        this.addressService = addressService;
    }


    @GetMapping("/teachers")
    public List<TeacherDTO> readAllTeachers(){
       return teacherService.findAll();

    }


    @GetMapping("/students")
    public ResponseEntity<ResponseWrapper> readAllStudents(){
        return ResponseEntity.ok(new ResponseWrapper("Students are sucessfully retreived"
                , studentService.findAll()));
}

    @GetMapping("/parents")
    public ResponseEntity<ResponseWrapper> readAllParents(){
        ResponseWrapper responseWrapper= new ResponseWrapper(true,"Parents retreived sucessfully",HttpStatus.OK.value(), paretntService.findAll());
        return ResponseEntity.status(HttpStatus.OK).body(responseWrapper);
}

    @GetMapping("/address/{id}")
    public ResponseEntity<ResponseWrapper> getAddress(@PathVariable("id") Long id) throws Exception{

        return ResponseEntity.ok(new ResponseWrapper("Addresses", addressService.findById(id)));

    }

    public AddressDTO updateAddress(@PathVariable("id") Long id, @RequestBody AddressDTO addressDTO) throws Exception{
        addressDTO.setId(id);
        return addressService.update(addressDTO);
    }

}
