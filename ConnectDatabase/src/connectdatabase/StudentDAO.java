
package connectdatabase;


import java.util.List;

public interface StudentDAO {
    void getAllStudents();
    Student getStudentById(int id) ;
    void addStudent(Student student) ;
    void updateStudent(Student student) ;
    void deleteStudent(int id) ;
}