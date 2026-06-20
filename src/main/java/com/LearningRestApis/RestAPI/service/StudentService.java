package com.LearningRestApis.RestAPI.service;


import com.LearningRestApis.RestAPI.dto.AddRequestStudentDto;
import com.LearningRestApis.RestAPI.dto.StudentDto;
import com.LearningRestApis.RestAPI.entity.Student;

import java.util.List;
import java.util.Map;

public interface StudentService {

    List<StudentDto> getAllStudents();

    StudentDto getStudentById(Long id);

    StudentDto createNewStudent(AddRequestStudentDto addRequestStudentDto);

    void deleteStudentById(Long id);

    StudentDto updateStudent(Long id, AddRequestStudentDto addRequestStudentDto);

    StudentDto updatePartialStudent(Long id, Map<String, Object> updates);
}
