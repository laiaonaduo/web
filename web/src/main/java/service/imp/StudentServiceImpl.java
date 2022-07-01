package service.imp;

import Dao.StudentDao;
import domain.Student;
import service.StudentService;

import java.util.List;

public class StudentServiceImpl implements StudentService {

    private StudentDao dao;

    public StudentDao getDao() {
        return dao;
    }

    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public Student findById(Integer id) {
        Student studnet=dao.select_student_ById(id);
        return studnet;
    }

    @Override
    public List<Student> find_student() {

        List<Student> students=dao.select_student();

        return students;
    }

    @Override
    public int register_student(Student role) {
        if(dao.select_student_ById(Integer.valueOf(role.getUsername()))==null)//如果不存在，可以插入
        {
            int id=dao.insertStudent(role);
            return id;
        }
        else return -1;
    }
}
