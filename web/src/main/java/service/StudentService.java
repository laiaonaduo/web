package service;

import domain.Student;

import java.util.List;

public interface StudentService {


    Student findById(Integer id);

    List<Student> find_student();

    int register_student(Student role);







}
