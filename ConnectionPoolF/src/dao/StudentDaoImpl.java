package dao;

import java.sql.*;

import model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {

    public StudentDaoImpl() {
    }

    // phuongthuc in sinh vien
    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM students";
        try (Connection connection = DataSource.getInstance().getConnection(); Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                students.add(new Student(id, name, age));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    // get sv by id
    @Override
    public Student getStudentById(int id) {
        Student student = null;
        String query = "SELECT * FROM students WHERE id = ?";
        try (Connection connection = DataSource.getInstance().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                student = new Student(id, name, age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return student;
    }

    // them sinh vien
    @Override
    public boolean addStudent(Student student) {
        String query = "INSERT INTO students (id, name, age) VALUES (?, ?, ?)";
        try (Connection connection = DataSource.getInstance().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, student.getId());
            preparedStatement.setString(2, student.getName());
            preparedStatement.setInt(3, student.getAge());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // cap nhat
    @Override
    public boolean updateStudent(Student student) {
        String query = "UPDATE students SET name=?, age=? WHERE id=?";
        try (Connection connection = DataSource.getInstance().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, student.getName());
            preparedStatement.setInt(2, student.getAge());
            preparedStatement.setInt(3, student.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // xoa
    @Override
    public boolean deleteStudent(Student student) {
        String query = "DELETE FROM students WHERE id=?";
        try (Connection connection = DataSource.getInstance().getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setInt(1, student.getId());
            preparedStatement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
