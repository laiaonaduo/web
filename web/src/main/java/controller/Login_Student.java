package controller;

import domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Login_Student extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        String Id = req.getParameter("id");
        String password = req.getParameter("password");
        Student student=new Student();

        String config="spring-beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        StudentService service =  (StudentService) ctx.getBean("studentService");

        System.out.println(Id);
        student=service.findById(Integer.valueOf(Id));


        System.out.println(student);
       if(student.getUsername().equals(Id)&&student.getPassword().equals(password))
       {
           System.out.println(student);
           req.getSession().setAttribute("student",student);
           req.getRequestDispatcher("Student.jsp").forward(req,resp);
       }
       else {

           req.getRequestDispatcher("index.jsp").forward(req,resp);
       }











    }
}
