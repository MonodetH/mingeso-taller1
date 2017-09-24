package edu.usach.mingeso1.repository;

import edu.usach.mingeso1.models.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.assertj.core.api.Assertions.*;

import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository studentRepositoryTest;

    @Test
    public void whenFindById_thenReturnStudent() {
        // new student
        Student neo = new Student();
        neo.setFirst_name("Gerardo");
        neo.setLast_name("Zúñiga");
        neo.setRut("18049468-5");
        neo.setCareer("Informática");
        neo.setEmail("gerardo.zuniga@usach.cl");
        neo.setEntry_year(2014);
        studentRepositoryTest.save(neo);

        // search student
        Student found = studentRepositoryTest.findOne(neo.getId());

        // compare
        assertThat(found.getRut())
            .isEqualTo(neo.getRut());
    }

}