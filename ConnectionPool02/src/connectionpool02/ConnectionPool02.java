
package connectionpool02;
import java.sql.SQLException;
import java.util.List;


public class ConnectionPool02 {

    public static void main(String[] args) {
          StudentDAO studentDAO = StudentDAO.getInstance();

        try {
//            // Thêm sinh viên
//            Student newStudent = new Student(11, "NguyenAnhTu", 20);
//            studentDAO.addStudent(newStudent);

            // Lấy thông tin của một sinh viên theo id
            Student studentById = studentDAO.getStudentById(3);
            System.out.println("Search by ID: " + studentById.getName() + ", " + studentById.getAge());

           // Sửa sv
            studentById.setId(2);
            studentById.setName("Tu");
            studentById.setAge(21);
            studentDAO.updateStudent(studentById);

            // Xóa sv
            studentDAO.deleteStudent(3);

            // in all sv
            List<Student> students = studentDAO.getStudents();
            for (Student student : students) {
                System.out.println("Student: "+ student.getId() + ", " + student.getName() + ", " + student.getAge());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            studentDAO.close();
        }
    }
    }
    

