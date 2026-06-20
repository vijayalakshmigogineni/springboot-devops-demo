package com.LearningRestApis.RestAPI.service.impl;

import com.LearningRestApis.RestAPI.dto.AddRequestStudentDto;
import com.LearningRestApis.RestAPI.dto.StudentDto;
import com.LearningRestApis.RestAPI.entity.Student;
import com.LearningRestApis.RestAPI.repository.studentRepo;
import com.LearningRestApis.RestAPI.service.StudentService;
import jakarta.persistence.Id;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class studentServiceImpl implements StudentService {
    private final studentRepo studentRepository;
    private final ModelMapper modelMapper;
    public studentServiceImpl(studentRepo studentRepository, ModelMapper modelMapper)
    {

        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }
    @Override
    public List<StudentDto> getAllStudents() {
        List<Student> students = studentRepository.findAll();
        List<StudentDto> studentDtoList = students
                .stream()
                .map(student->new StudentDto(student.getId(),student.getName(),student.getEmail()))
                .toList();
        return studentDtoList;
    }

    @Override
    public StudentDto getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(()->new IllegalArgumentException("student not found with the ID:"+id));
        StudentDto studentDto = modelMapper.map(student,StudentDto.class);
        return studentDto;

    }

    @Override
    public StudentDto createNewStudent(AddRequestStudentDto addRequestStudentDto) {
        Student newStudent = modelMapper.map(addRequestStudentDto,Student.class);
        Student student = studentRepository.save(newStudent);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public void deleteStudentById(Long id) {
        if(!studentRepository.existsById(id))
        {
            throw new IllegalArgumentException("student does  not exists by Id"+id);
        }
        studentRepository.deleteById(id);
    }

    @Override
    public StudentDto updateStudent(Long id, AddRequestStudentDto addRequestStudentDto) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("student not found with the id"));
        modelMapper.map(addRequestStudentDto,student);
        student = studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);
    }

    @Override
    public StudentDto updatePartialStudent(Long id, Map<String, Object> updates) {
        Student student = studentRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("student not found with the id given"+id));
        Student finalStudent = student;
        updates.forEach((field, value)->{
            switch (field)
            {
                case "name":
                    finalStudent.setName((String) value);
                    break;
                case "email":
                    finalStudent.setEmail((String) value);
                    break;
                default:throw new IllegalArgumentException("field is not supported");

            }
        });
        student = studentRepository.save(student);
        return modelMapper.map(student,StudentDto.class);

    }


}
