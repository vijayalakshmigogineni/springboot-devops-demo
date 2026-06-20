package com.LearningRestApis.RestAPI.controller;

import com.LearningRestApis.RestAPI.dto.AddRequestStudentDto;
import com.LearningRestApis.RestAPI.dto.StudentDto;
import com.LearningRestApis.RestAPI.entity.Student;
import com.LearningRestApis.RestAPI.service.StudentService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
public class StudentController {


    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {

        this.studentService = studentService;
    }

    @GetMapping("/AllStudents")
    public List<StudentDto> getAllStudents()
    {
        return studentService.getAllStudents();
    }

    @GetMapping("/student")
    public StudentDto getStudent()
    {
        return new StudentDto(4L,"vijju","vijju@gmail.com");
    }

    @GetMapping("/students/{id}/{name}")
    public String getStudentById(@PathVariable Long Id,@PathVariable String name)
    {
        return "Path variable"+Id + "name is:"+name;
    }

    @GetMapping("/students/{id}")
    public ResponseEntity<StudentDto> getStudentById(@PathVariable Long id)
    {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
    }

    @PostMapping("/students")
    public ResponseEntity<StudentDto> createNewStudent(@RequestBody AddRequestStudentDto addRequestStudentDto)
    {
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.createNewStudent(addRequestStudentDto));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id)
    {
        studentService.deleteStudentById(id);
        return ResponseEntity.noContent().build();
    }
    //put mapping when u want to change any student information
    //patch mapping - when u want to change the information partially
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> updateStudent(@PathVariable Long id,
                                                    @RequestBody AddRequestStudentDto addRequestStudentDto)
    {
        return ResponseEntity.ok(studentService.updateStudent(id,addRequestStudentDto));

    }

    @PatchMapping("/{id}")
    public ResponseEntity<StudentDto> updateDetailsPartially(@PathVariable Long id, @RequestBody Map<String,Object> updates){
        return ResponseEntity.ok(studentService.updatePartialStudent(id,updates));
    }
}
