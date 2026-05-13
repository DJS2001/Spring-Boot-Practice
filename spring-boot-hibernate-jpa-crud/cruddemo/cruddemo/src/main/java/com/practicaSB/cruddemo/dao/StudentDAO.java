package com.practicaSB.cruddemo.dao;

import com.practicaSB.cruddemo.entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName (String elApellido);

    void update(Student elEstudiante);

    void delete(Integer id);

    int deleteAll();

    void saveMultipleStudents(List<Student> students);

}
