package com.example.tagfinance.dao.impl;

import com.example.tagfinance.dao.DataSource;
import com.example.tagfinance.dao.TagFinanceDAO;
import com.example.tagfinance.data.entity.TagFinance;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.tagfinance.data.SQLConstans.TagFinanceSQL.*;

public class TagFinanceDAOImpl implements TagFinanceDAO {
    @Override
    public void insertTagFinance(TagFinance tagFinance) {
        Connection connection = null;
        try {
            connection = DataSource.getInstance().getConnection();
            PreparedStatement pst = connection.prepareStatement(INSERT_TAGFINANCE);
            pst.setString(1, tagFinance.getName());
            pst.setString(2, tagFinance.getDescription());
            pst.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            e.printStackTrace();
        }
    }


    @Override
    public List<TagFinance> getTagFinanceList() {
        List<TagFinance> list = new ArrayList<>();

        try {
            Connection connection = DataSource.getInstance().getConnection();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(SELECTALL_TAGFINANCE);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                TagFinance tagFinance = new TagFinance(id, name, description);
                list.add(tagFinance);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }


    @Override
    public void updateTagFinance(TagFinance tagFinance, int id) {
        Connection connection = null;
        try {
            connection = DataSource.getInstance().getConnection();
            System.out.println(UPDATE_TAGFINANCE);
            PreparedStatement pst = connection.prepareStatement(UPDATE_TAGFINANCE);
            pst.setString(1, tagFinance.getName());
            pst.setString(2, tagFinance.getDescription());
            pst.setInt(3, id);
            pst.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            e.printStackTrace();
        }
    }




    @Override
    public void deleteTagFinance(int id) {
        Connection connection = null;
        try {
            connection = DataSource.getInstance().getConnection();
            PreparedStatement pst = connection.prepareStatement(DELETE_TAGFINANCE);
            pst.setInt(1, id);
            pst.executeUpdate();
            connection.commit();

        } catch (SQLException e) {
            if (connection != null) {
                try {
                    connection.rollback();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

            e.printStackTrace();
        } finally {
            if (Objects.nonNull(connection)) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    }



}

