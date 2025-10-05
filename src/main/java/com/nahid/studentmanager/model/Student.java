package com.nahid.studentmanager.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Student {

    @Id
//    @NotBlank(message = "Student ID is required")
    private String studentId;

//    @NotBlank(message = "Name is required")
    private String name;

//    @Email(message = "Invalid email format")
    private String email;

    @Min(value = 18, message = "Age must be at least 18")
    private Integer age;

//    @NotBlank(message = "Gender is required")
    private String gender;

//    @Size(min = 1, message = "Select at least one hobby")
//    private List<String> hobbies;

//    @NotBlank(message = "Country must be selected")
//    private String country;

//    @NotBlank(message = "Must select major.")
    private String dept;

//    @NotBlank(message = "Must provide a valid Bangladeshi Number.")
    private String phoneNumber;

//    @AssertTrue(message = "You must agree to the terms")
//    private  boolean agreeToTerms;

    private String address;



}
