package Dao;

import domain.Teacher;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeacherDao {


    int insterTeacher(Teacher teacher);

    Teacher select_teacher_ById(@Param("teacherId") Integer id);

    List<Teacher> select_teacher();




}
