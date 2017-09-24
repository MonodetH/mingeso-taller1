package edu.usach.mingeso1.controllers;

import edu.usach.mingeso1.models.Student;
import edu.usach.mingeso1.repository.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
//@ContextConfiguration(classes = {/*TestContext.class, */ WebApplicationContext.class})
@WebAppConfiguration
@DataJpaTest
public class StudentControllerTest {

    //@Autowired
    private MockMvc mockMvc;

    //@Autowired
    //private WebApplicationContext webApplicationContext;

    @Autowired
    private StudentRepository studentRepositoryTest;

    private Student estudiante1;

    @Before
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders.standaloneSetup(new StudentController(studentRepositoryTest)).build();
        //this.mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();

        // new student
        estudiante1 = new Student();
        estudiante1.setFirst_name("Gerardo");
        estudiante1.setLast_name("Zúñiga");
        estudiante1.setRut("18049468-5");
        estudiante1.setCareer("Informática");
        estudiante1.setEmail("gerardo.zuniga@usach.cl");
        estudiante1.setEntry_year(2014);
        studentRepositoryTest.save(estudiante1);
    }


    @Test
    public void getStudent() throws Exception {
        String id = String.valueOf(estudiante1.getId());
        this.mockMvc.perform(get("/student/"+id+"/").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=UTF-8"));
    }

}