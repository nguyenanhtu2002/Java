package dao;
import model.Student;
import java.util.List;


public interface StudentDao {
    List<Student> getAllStudents();
    Student getStudentById(int id);
    boolean addStudent(Student student);
    boolean updateStudent(Student student);
    boolean deleteStudent(Student student);
}