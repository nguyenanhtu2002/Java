package view;

import dao.StudentDao;
import dao.StudentDaoImpl;
import java.util.List;
import model.Student;

public class view {

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDaoImpl();

        // Thêm sv
        Student newStudent = new Student(11, "test", 20);
        studentDao.addStudent(newStudent);
        // cap nhat
//        Student update = studentDao.getStudentById(1);
//        update.setName("Nguyen Anh Tu");
//        update.setAge(21);
//        studentDao.updateStudent(update);
//        // xoa
//        Student delete = studentDao.getStudentById(1);
//        studentDao.deleteStudent(delete);

        // in sv
        List<Student> students = studentDao.getAllStudents();
        for (Student student : students) {
            System.out.println(student.getId() + " - " + student.getName() + " - " + student.getAge());
        }
    }
}
