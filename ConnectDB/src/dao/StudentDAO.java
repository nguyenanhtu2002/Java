package dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.SQLException;
import database.JDBCUtil;
import java.util.ArrayList;
import model.Student;

public class StudentDAO implements DAOInterface<Student> {

    public static StudentDAO getInstance() {
        return new StudentDAO();
    }

    @Override
    public int insert(Student t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            if (con != null) {
                Statement st = con.createStatement();
                String sql = "INSERT INTO Students (id, name, email,phone ) "
                        + " VALUES ('" + t.getId() + "' , '" + t.getName() + "' , '" + t.getEmail() + "' , '" + t.getPhone() + "')";
                ketQua = st.executeUpdate(sql);
                System.out.println("Bạn đã thực thi: " + sql);
                JDBCUtil.closeConnection(con);
            } else {
                System.out.println("Chưa kết nối cơ sở dữ liệu");
            }
        } catch (SQLException e) {
            System.out.println("Không thể insert");
        }
        return ketQua;
    }

    @Override
    public int update(Student t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "UPDATE Students "
                    + " SET "
                    + " name='" + t.getName() + "'"
                    + ", email='" + t.getEmail() + "'"
                    + ", phone='" + t.getPhone() + "'"
                    + " WHERE id='" + t.getId() + "\'";
            
            ketQua = st.executeUpdate(sql);
            System.out.println("Bạn đã thực thi: " + sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public int delete(Student t) {
        int ketQua = 0;
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "DELETE from Students "
                    + " WHERE id='" + t.getId() + "'";
            System.out.println(sql);
            ketQua = st.executeUpdate(sql);
            System.out.println("Bạn đã thực thi: " + sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ketQua;
    }

    @Override
    public void selectAll() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            Connection con = JDBCUtil.getConnection();
            Statement st = con.createStatement();
            String sql = "SELECT * FROM Students";
            var rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                Student student = new Student(id, name, email, phone);
                students.add(student);
            }
            System.out.println("Bạn đã thực thi: " + sql);
            JDBCUtil.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        for (Student student : students) {
            System.out.println(student);
        }

    }
}
