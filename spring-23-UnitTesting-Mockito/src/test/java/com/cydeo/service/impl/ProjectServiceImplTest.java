package com.cydeo.service.impl;
import com.cydeo.dto.ProjectDTO;
import com.cydeo.entity.Project;
import com.cydeo.mapper.ProjectMapper;
import com.cydeo.repository.ProjectRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProjectServiceImplTest {

    @Mock
    ProjectRepository projectRepository;

    @Mock
    ProjectMapper projectMapper;

    @InjectMocks
    ProjectServiceImpl projectService;

    @Test
    void getByProjectCode_Test() {
        //When we run findByProjectCode from project repository we want to return an
        // empty project entity.
        // Also adding another method for the project code, we can use anyString since we will return an empty project anyways.

        //GIVEN
        when(projectRepository.findByProjectCode(anyString())).thenReturn(new Project()); // AKA STUBBING
        when(projectMapper.convertToDto(any(Project.class))).thenReturn(new ProjectDTO());

        // Calls the service, above methods will return an empty project, and a new Project DTO to enable execution

        //WHEN
        ProjectDTO projectDTO = projectService.getByProjectCode(anyString());
        // Verifys the order

        //THEN
        InOrder inOrder = inOrder(projectRepository, projectMapper);
        // the placement below is the order we are checking


        inOrder.verify(projectRepository).findByProjectCode(anyString());
        inOrder.verify(projectMapper).convertToDto(any(Project.class));

        //AND
        assertNotNull(projectDTO);
    }

    @Test
    void getByProjectCode_ExceptionTest() {
        //stub to give behaviour
        when(projectRepository.findByProjectCode("")).thenThrow( new ClassCastException("Project not found"));

        //running the code to test
        Throwable throwable = assertThrows(ClassCastException.class, () -> projectService.getByProjectCode(""));
        // verify this method runs when I run the above
        verify(projectRepository).findByProjectCode("");
        // makes sure that convertToDTO method is never ran
        verify(projectMapper, never()).convertToDto(any(Project.class));
        //Checking the message is how expected
        assertEquals("Project not found", throwable.getMessage());
    }
}