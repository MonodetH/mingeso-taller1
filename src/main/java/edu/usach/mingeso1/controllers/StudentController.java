package edu.usach.mingeso1.controllers;

import edu.usach.mingeso1.models.Student;
import edu.usach.mingeso1.repository.StudentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/student")
public class StudentController
{
	@Autowired
	private StudentRepository studentRepository;

	@GetMapping(path="/all")
    	public @ResponseBody Iterable<Student> getAllStudents()
    	{
       		return studentRepository.findAll();
	}

	@GetMapping(path="/{id}")
    	public @ResponseBody Student getStudent(@PathVariable("id") Integer id)
    	{
        		long lid = id.longValue();
        		return studentRepository.findOne(lid);
	}

	@RequestMapping(path="/new", method= RequestMethod.POST)
    	public Integer createStudent(@RequestBody Student student)
    	{
        		Student neo = new Student();
        		neo.setFirst_name(student.getFirst_name());
        		neo.setLast_name(student.getLast_name());
        		neo.setRut(student.getRut());
        		neo.setCareer(student.getCareer());
        		neo.setEmail(student.getEmail());
        		neo.setEntry_year(student.getEntry_year());
        		studentRepository.save(neo);
        		return 1;
	}

}