package com.tqtplayer.DAO;

import com.tqtplayer.connection.MysqlConnection;
import com.tqtplayer.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {


    private static final String SELECT_USER_BY_USERNAME_AND_PASSWORD = "select username,password,role from user where username = ? and password = ? ";
    private static final String SELECT_USER_BY_EMAIL = "select username,password,role from user where email = ?";
    private static final String INSERT_USERS_SQL = "INSERT INTO user (fullname,username,email,password,role,status) VALUES (?, ?,?,?,?,?);";
    private static final String SELECT_USERS_SQL = "select id,fullname,email,gender from user where id =?, email= ?";
    private static final String SELECT_COUNT_USER_SQL = "SELECT COUNT(id) FROM users where role = ?;";
    private static final String SELECT_ALL_USERS = "select * from users";
    private static final String SELECT_USER_BY_ID = "select id,fullName,email,password,role,deleted from users where id = ?;";
    private static final String SELECT_USER_BY_USERNAME = "select id,fullname,email,username,role,status from user where username = ?;";
    private static final String UPDATE_USERS_SQL = "update user set fullname = ?,email= ?, role =?, status= ? where id = ?;";
    //    private static final String DELETE_USERS_SQL = "delete from account where id = ?;";
//    private static final String UPDATE_USERS_SQL = "update user set email = ?,where id = ?;";


    public UserDAO() {
        MysqlConnection.init("tqt-player-ajax-mvc");
    }


    @Override
    public void insertUser(User user) throws SQLException {
//        System.out.println(INSERT_USERS_SQL);
//        // try-with-resource statement will auto close the connection.
//        try (Connection connection = MysqlConnection.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
//            preparedStatement.setString(1, user.getFullName());
//            preparedStatement.setString(2, user.getUsername());
//            preparedStatement.setString(3, user.getEmail());
//            preparedStatement.setString(4, user.getPassword());
//            preparedStatement.setString(5, user.getRole() );
//            preparedStatement.setString(6, user.getStatus() );
//            System.out.println(preparedStatement);
//            preparedStatement.executeUpdate();
//        } catch (SQLException ignored) {
//        }
    }

    @Override
    public User getUserById(long id) throws SQLException {
        User user = null;
        // Step 1: Establishing a Connection
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             // Step 2:Create a statement using connection object
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setLong(1, id);
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                String fullname = rs.getString("fullName");
                String email = rs.getString("email");
                String role = rs.getString("role");
                int deleted = rs.getInt("deleted");
                boolean deleteds = false;
                if (deleted == 1){
                    deleteds = true;
                }
               user = new User(id, fullname,email, deleteds, role);
            }
        } catch (SQLException ignored) {
        }
        return user;
    }
    @Override
    public int getCount(String role){
        int rows = 0;
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_COUNT_USER_SQL);) {
            preparedStatement.setString(1, role);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                rows = rs.getInt("count(id)");
            }
        } catch (SQLException ignored) {
        }
        return rows;
    }


 @Override
 public User getUserByUsername(String username){
     User user = null;
     // Step 1: Establishing a Connection
//     try (Connection connection = MysqlConnection.getInstance().getConnection();
//          // Step 2:Create a statement using connection object
//          PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME);) {
//         preparedStatement.setString(1, username);
//         System.out.println(preparedStatement);
//         // Step 3: Execute the query or update query
//         ResultSet rs = preparedStatement.executeQuery();
//
//         // Step 4: Process the ResultSet object.
//         while (rs.next()) {
//             int id = rs.getInt("id");
//             String fullname = rs.getString("fullname");
//             String email = rs.getString("email");
//             String role = rs.getString("role");
//             String status = rs.getString("status");
//             user = new User(id, fullname, email, username,role,status);
//         }
//      } catch (SQLException ignored) {
//     }
     return user;
 }
    @Override
    public User selectUser(String ipusername, String ippassword) {
        User user = null;
//        try (Connection connection = MysqlConnection.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_USERNAME_AND_PASSWORD);) {
//            preparedStatement.setString(1, ipusername);
//            preparedStatement.setString(2, ippassword);
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                String userName = rs.getString("username");
//                String password = rs.getString("password");
//                String role = rs.getString("role");
//                user = new User(userName, password, role);
//            }
//        } catch (SQLException ignored) {
//        }
        return user;
    }
    @Override
    public User selectUserByEmail(String email) {
        User user = null;
//        try (Connection connection = MysqlConnection.getInstance().getConnection();
//             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_EMAIL);) {
//             preparedStatement.setString(1, email);
//            System.out.println(preparedStatement);
//            ResultSet rs = preparedStatement.executeQuery();
//            while (rs.next()) {
//                String userName = rs.getString("username");
//                String password = rs.getString("password");
//                String role = rs.getString("role");
//                user = new User(userName, password, role);
//            }
//        } catch (SQLException ignored) {
//        }
        return user;
    }

    @Override
    public List<User> selectAllUser() {
        List<User> users = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = MysqlConnection.getInstance().getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                long id = rs.getLong("id");
                String fullname = rs.getString("fullName");
                String email = rs.getString("email");
                String role = rs.getString("role");
                int deleted = rs.getInt("deleted");
                boolean deleteds = false;
                if (deleted == 0){
                    deleteds = false;
                } else{
                    deleteds =true;
                }
                users.add(new User(id, fullname,email, deleteds, role));
            }
        } catch (SQLException ignored) {
        }
        return users;
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated = false;
//        try (Connection connection = MysqlConnection.getInstance().getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
//            statement.setString(1, user.getFullName());
//            statement.setString(2, user.getEmail());
//            statement.setString(3, user.getRole());
//            statement.setString(4, user.getStatus());
//            statement.setInt(5, user.getId());
//            rowUpdated = statement.executeUpdate() > 0;
//        }
        return rowUpdated;
    }

}
