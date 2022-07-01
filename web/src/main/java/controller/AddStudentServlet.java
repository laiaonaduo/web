/*
package controller;

import domain.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import service.StudentService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class AddStudentServlet extends HttpServlet

{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        Student student = new Student();
        //赋值

        student.setUsername(req.getParameter("id"));
        student.setPassword(req.getParameter("password"));


        student.setName(req.getParameter("name"));
        student.setA(Integer.valueOf(req.getParameter("age")));
        student.setSex(req.getParameter("sex"));
        System.out.println(student);

        String config = "spring-beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        StudentService service = (StudentService) ctx.getBean("studentService");
        int x = service.register_student(student);

        //调用service
        //使用spring提供的工具方法，获取容器对象
 WebApplicationContext ctx = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());
        StudentService service = (StudentService) ctx.getBean("studentService");
        service.register_student(student);

        //给用户显示请求的处理结果
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
*/
