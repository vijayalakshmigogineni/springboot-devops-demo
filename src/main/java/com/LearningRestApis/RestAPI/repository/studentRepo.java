package com.LearningRestApis.RestAPI.repository;

import com.LearningRestApis.RestAPI.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface  studentRepo extends JpaRepository<Student,Long> {


}
