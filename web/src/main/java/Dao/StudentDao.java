package Dao;

import domain.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentDao {


    int insertStudent(Student student);

    Student select_student_ById(@Param("studentId") Integer id);

    List<Student> select_student();






}
