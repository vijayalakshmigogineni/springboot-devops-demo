package com.LearningRestApis.RestAPI.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AddRequestStudentDto {
    @NotBlank(message = "name is required")
    @Size(min = 3,max = 30,message = "name should be of length between 3 to 30")
    private String name;

    @Email
    @NotBlank(message = "email is required")
    private String email;
}
