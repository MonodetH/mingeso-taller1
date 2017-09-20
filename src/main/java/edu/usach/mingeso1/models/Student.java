package edu.usach.mingeso1.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="Student")
public class Student
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "student_id")
	private long student_id;

	@NotNull
   	private String rut;

	@NotNull
	private String first_name;

	@NotNull
	private String last_name;

	@NotNull
	private String career;

	@NotNull
	private String email;

	@NotNull
	private int entry_year;

	public String getRut()
	{
		return rut;
	}

	public void setRut(String rut)
	{
		this.rut = rut;
	}

	public long getStudent_id() 
	{
        		return student_id;
    	}
	
	public void setStudent_id(long student_id)
	{
        		this.student_id = student_id;
    	}

    	public String getFirst_name() 
	{
        		return first_name;
    	}

    	public void setFirst_name(String first_name)
	{
        		this.first_name = first_name;
    	}

    	public String getLast_name() 
	{
        		return last_name;
    	}

    	public void setLast_name(String last_name)
	{
        		this.last_name = last_name;
    	}

    	public String getCareer() 
	{
        		return career;
    	}

    	public void setCareer(String career)
	{
        		this.career = career;
    	}

    	public String getEmail() 
	{
        		return email;
    	}

    	public void setEmail(String email)
	{
        		this.email = email;
    	}

    	public int getEntry_year() 
	{
        		return entry_year;
    	}

    	public void setEntry_year(int entry_year)
	{
        		this.entry_year = entry_year;
    	}
}