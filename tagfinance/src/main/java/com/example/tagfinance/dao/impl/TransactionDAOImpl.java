package com.example.tagfinance.dao.impl;

import com.example.tagfinance.dao.DataSource;
import com.example.tagfinance.dao.Search;
import com.example.tagfinance.dao.TransactionDAO;
import com.example.tagfinance.data.entity.TagFinance;
import com.example.tagfinance.data.entity.Transaction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.tagfinance.data.SQLConstans.TransactionSQL.*;

public class TransactionDAOImpl implements TransactionDAO, Search {

    @Override
    public void insertTransaction(String title, String description, int amount, int tagID) {
        Connection connection = null;
        try {
            connection = DataSource.getInstance().getConnection();
            PreparedStatement pst = connection.prepareStatement(INSERT_TRANSACTION);
            pst.setString(1, title);
            pst.setString(2, description);
            pst.setInt(3, amount);
            pst.setInt(4, tagID);
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


    @Override
    public void updateTransaction(String title, String description, int amount, int tagID, int id) {
        Connection connection = null;
        try {
            connection = DataSource.getInstance().getConnection();
            PreparedStatement pvt = connection.prepareStatement(UPDATE_TRANSACTION);
//            pvt.setDate(1, (java.sql.Date) transaction.getCreatedAt());
            pvt.setString(1, title);
            pvt.setString(2, description);
            pvt.setInt(3, amount);
            pvt.setInt(4, tagID);
            pvt.setInt(5, id);
            pvt.executeUpdate();
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


    @Override
    public void deleteTransaction(int id) {
        Connection connection = null;
        try {
            connection = DataSource.getInstance().getConnection();
            PreparedStatement pvt = connection.prepareStatement(DELETE_TRANSACTION);
            pvt.setInt(1, id);
            pvt.executeUpdate();
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


    @Override
    public List<Transaction> getTransactionList() {
        Connection connection = null;

        List<Transaction> list = new ArrayList<>();

        try {
            connection = DataSource.getInstance().getConnection();
            Statement st = connection.createStatement();
            String sql = GET_TRANSACTION;
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                java.util.Date cr = rs.getDate("created_at");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int amount = rs.getInt("amount");
                int tagID = rs.getInt("tag_id");
                String name = rs.getString("name");
                String des = rs.getString("description");
                Transaction transaction = new Transaction(id, cr, title, description, amount, new TagFinance(tagID, name, des));
                list.add(transaction);
            }


        } catch (SQLException e) {
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
        return list;
    }


    @Override
    public List<Transaction> searchTransactionByTagFinance(int id) {
        Connection connection = null;
        List<Transaction> transactionList = new ArrayList<>();
        try {
            connection = DataSource.getInstance().getConnection();
            PreparedStatement pst = connection.prepareStatement(SEARCH_TRANSACTION);
            pst.setInt(1, id);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int idTrans = rs.getInt("id");
                java.util.Date cr = rs.getDate("created_at");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int amount = rs.getInt("amount");
                int tagID = rs.getInt("tag_id");
                Transaction transaction = new Transaction(idTrans, cr, title, description, amount, new TagFinance(tagID));
                transactionList.add(transaction);
            }

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
        return transactionList;

    }


    @Override
    public List<Transaction> searchTransactionByTagFinanceName(String key) {


        Connection connection = null;
        List<Transaction> transactionList = new ArrayList<>();
        try {
            connection = DataSource.getInstance().getConnection();
            PreparedStatement pst = connection.prepareStatement(SEARCH_TRANSACTION_BY_NAME);
            pst.setString(1, key);

            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                int idTrans = rs.getInt("id");
                java.util.Date cr = rs.getDate("created_at");
                String title = rs.getString("title");
                String description = rs.getString("description");
                int amount = rs.getInt("amount");
                int tagID = rs.getInt("tag_id");
                String tagName = rs.getString("name");
                String des = rs.getString("description");
                Transaction transaction = new Transaction(idTrans, cr, title, description,
                        amount, new TagFinance(tagID, tagName, des));
                transactionList.add(transaction);
            }

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
        return transactionList;


    }
}

