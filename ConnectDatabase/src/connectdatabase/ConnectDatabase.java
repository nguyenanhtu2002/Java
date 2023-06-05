package connectdatabase;

import com.sun.jdi.connect.spi.Connection;
import java.sql.SQLException;
import java.util.List;

public class ConnectDatabase {

    //  private static StudentDAO studentDAO = StudentDAOImpl.getInstance();
    public static void main(String[] args) throws SQLException {
        StudentDAO studentDAO = DatabaseSingleton.getInstance().getStudentDAO();
        // Thêm sinh viên
        Student student = new Student();
        student.nhap();
        studentDAO.addStudent(student);
        // Sửa thông tin sinh viên
//        student.setId(2);
//        student.setAge(22);
//        student.setName("Nguyen Van B");
//        studentDAO.updateStudent(student);

        // Xóa sinh viên
        //studentDAO.deleteStudent(1);
        // Lấy danh sách sinh viên
        studentDAO.getAllStudents();
    }

}
