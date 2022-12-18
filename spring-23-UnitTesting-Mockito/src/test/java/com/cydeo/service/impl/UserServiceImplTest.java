package com.cydeo.service.impl;

import com.cydeo.mapper.UserMapper;
import com.cydeo.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @InjectMocks
    UserServiceImpl userService; // need to use the class itself not the interface

    @Mock
    UserMapper userMapper;

    @Mock
    UserRepository userRepository;


    @Test
    void findByUserName_Test(){

        // I'm calling the REAL method inside of the main, which is the method I want to test.
        userService.findByUserName("harold@Manager.com");

        //Here I am checking if this method is user or not, making sure there is nothing preventing this method from running
        // ex no exception
        verify(userRepository).findByUserNameAndIsDeleted("harold@Manager.com", false);

        // This is checking if the method findByUser... is being called 2 times, in this case should be false.
        verify(userRepository, times(2)).findByUserNameAndIsDeleted("harold@Manager.com", false);

        verify(userRepository, atLeastOnce()).findByUserNameAndIsDeleted("harold@Manager.com", false);

        verify(userRepository, atLeast(2)).findByUserNameAndIsDeleted("harold@Manager.com", false);

        verify(userRepository, atMostOnce()).findByUserNameAndIsDeleted("harold@Manager.com", false);

        verify(userRepository, atMost(10)).findByUserNameAndIsDeleted("harold@Manager.com", false);


        // checks the order of the operations
        InOrder inOrder= inOrder(userRepository, userMapper);

        // Checking if the orer is Converty to DTO and then findBy UserName
        inOrder.verify(userMapper).convertToDto(null);
        inOrder.verify(userRepository).findByUserNameAndIsDeleted("harold@Manager.com", false);


    }
}