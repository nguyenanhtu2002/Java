package com.example.demo.dao.implement;

import com.example.demo.dao.DataSource;
import com.example.demo.dao.TagFinanceDAO;
import com.example.demo.entity.TagFinance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TagFinanceDAOImpl implements TagFinanceDAO {
    public static final String ADD_TAG = "INSERT INTO Tag_Finance (name, description) VALUES (?, ?)";
    public static final String SELECT_ALL = "SELECT id, name, description FROM Tag_Finance";
    public static final String DELETE_TAG = "DELETE FROM Tag_Finance WHERE id =?";
    public static final String UPDATE_TAG = "UPDATE Tag_Finance SET name =?, description =? WHERE id =?";
    public static final String GET_TAG = "SELECT id, name, description FROM Tag_Finance WHERE id =?";
    @Override
    public void createTagFinance(String name, String description) throws SQLException {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(ADD_TAG);
            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        } finally {
            if (Objects.nonNull(conn)) {
                conn.close();
            }
        }
    }

    @Override
    public void updateTagFinance(String name, String description, int id) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();

            PreparedStatement pstmt = conn.prepareStatement(UPDATE_TAG);

            pstmt.setString(1, name);
            pstmt.setString(2, description);
            pstmt.setInt(3, id);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
    }

    @Override
    public List<TagFinance> getAllTagFinance() {
        List<TagFinance> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(SELECT_ALL);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                TagFinance tagFinance = new TagFinance();
                tagFinance.setId(rs.getInt("id"));
                tagFinance.setName(rs.getString("name"));
                tagFinance.setDescription(rs.getString("description"));
                list.add(tagFinance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
        return list;
    }

    @Override
    public void deleteTagFinance(int id) {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(DELETE_TAG);
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
            throw new RuntimeException("Failed to delete");

        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
    }

    @Override
    public TagFinance getTagFinanceById(int id) throws Exception {
        Connection conn = null;
        try {
            conn = DataSource.getInstance().getConnection();
            PreparedStatement pstmt = conn.prepareStatement(GET_TAG);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                TagFinance tagFinance = new TagFinance();
                tagFinance.setId(rs.getInt("id"));
                tagFinance.setName(rs.getString("name"));
                tagFinance.setDescription(rs.getString("description"));
                return tagFinance;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.out.println("Error closing");
                }
            }
        }
        return null;
    }

}
