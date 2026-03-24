package com.gal.cabservice.entity;
import jakarta.persistence.*;
@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	Long id;
	String employeeName;

}
