package edu.usach.mingeso1.repository;

import edu.usach.mingeso1.models.Student;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface StudentRepository extends CrudRepository<Student, Long> {
}