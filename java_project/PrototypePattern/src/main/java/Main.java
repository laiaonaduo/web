import Student.Student;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {


        Student student1=new Student();//新建一个模板类
        student1.setClassName("软件工程三班");
        student1.setMajor("软件工程");

        for(int i = 0;i < 3;i++){
            System.out.println();

            Student student=(Student) student1.clone();

            student.setName("同学"+i);
            System.out.println("现在是来自"+student.getMajor()+"的"+student.getClassName()+"的"+student.getName());
        }
    }
}