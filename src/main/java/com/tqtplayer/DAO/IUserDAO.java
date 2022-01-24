package com.tqtplayer.DAO;

import com.tqtplayer.model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void insertUser(User user) throws SQLException;

    User getUserById(long id) throws SQLException;

    int getCount(String role);

    User getUserByUsername(String username);

    User selectUser(String username, String password);

    User selectUserByEmail(String email);

    List<User> selectAllUser();

//    public boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;
}
