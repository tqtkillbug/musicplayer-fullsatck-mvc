package com.tqtplayer.severlet;


import com.sun.xml.internal.messaging.saaj.packaging.mime.MessagingException;
import com.tqtplayer.DAO.ISongDAO;
import com.tqtplayer.DAO.IUserDAO;
import com.tqtplayer.DAO.SongDAO;
import com.tqtplayer.DAO.UserDAO;
import com.tqtplayer.model.User;
import lombok.SneakyThrows;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ServletAdmin", value = "/pages")
public class ServletAdmin extends HttpServlet {

    private IUserDAO userService;
    private ISongDAO songService;


    public void init() {
        userService = new UserDAO();
        songService = new SongDAO();
    }

    @SneakyThrows
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "usermanager":
                showListUser(request, response);
                break;
            case "block":
                try {
                    setStatus(request, response, "BLOCKED");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "active":
                try {
                    setStatus(request, response, "ACTIVE");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "dashboard":
                loadDashboard(request, response);
                break;
        }
    }

    private void loadDashboard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        Cookie[] cookies = request.getCookies();
        User adminLogin = null;
        for (Cookie ck : cookies) {
            //display only the cookie with the name 'setUser'
            if (ck.getName().equals("adminId")) {
                long adminId = Long.parseLong(ck.getValue());
                adminLogin = userService.getUserById(adminId);
                System.out.println(adminLogin);
                break;
            } else {
                ck.setValue("");
                break;
            }
        }

        if (adminLogin != null) {
            ArrayList<Integer> quantityList = new ArrayList<>();
            int adminQuantity = userService.getCount("admin");
            int userQuantity = userService.getCount("user");
            int songQuantity = songService.getCount();
            quantityList.add(adminQuantity);
            quantityList.add(userQuantity);
            quantityList.add(songQuantity);
            System.out.println(quantityList);
            request.setAttribute("quantity", quantityList);
            request.setAttribute("admin", adminLogin);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/admin/dashboard.jsp");
            dispatcher.forward(request, response);
        } else {
            notFoundPage(request, response);
        }

    }

    private void notFoundPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/errorpage/404..jsp");
        dispatcher.forward(request, response);
    }

    private void setStatus(HttpServletRequest request, HttpServletResponse response, String status) throws SQLException, IOException, ServletException {
//        int id = Integer.parseInt(request.getParameter("id"));
//        User user = userService.getUserById(id);
//        if (user.getId() == 1){
//            request.setAttribute("message", "You cannot block Boss");
//        } else{
//            user.setStatus(status);
//            System.out.println(user);
//            userService.updateUser(user);
//            request.setAttribute("message", status +" "+ user.getFullName() + " Success!");
//        }
//        showListUser(request,response);
    }


    private void showListUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        List<User> listUser = userService.selectAllUser();
        Cookie[] cookies = request.getCookies();
        User adminLogin = null;
        for (Cookie ck : cookies) {
            //display only the cookie with the name 'setUser'
            if (ck.getName().equals("adminId")) {
                long adminId = Long.parseLong(ck.getValue());
                adminLogin = userService.getUserById(adminId);
                break;
            } else {
                ck.setValue("");
                break;
            }
        }
        if (adminLogin != null) {
            request.setAttribute("admin", adminLogin);
            request.setAttribute("listUser", listUser);
            RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/admin/usermanager.jsp");
            dispatcher.forward(request, response);
        } else {
            notFoundPage(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html/charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "addnewadmin":
                try {
                    addNewAdmin(request, response);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                break;
            case "sendmailtouser":
                try {
                    sendMailToUser(request, response);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    private void sendMailToUser(HttpServletRequest request, HttpServletResponse response) throws MessagingException, IOException, ServletException {
//        String title = request.getParameter("titleEmail");
//        String content = request.getParameter("contentMail");
//        String emailUser = request.getParameter("emailuser");
//        String from = request.getParameter("inputFromAdmin");
//        String contentMail = "\n" + title + "\n" + content + "\n" + "From: " +from;
//        SendKeyToMail.send(emailUser, contentMail);
//        request.setAttribute("message", "Send Mail To " + emailUser +" Success!");
//        showListUser(request,response);
    }

    private void addNewAdmin(HttpServletRequest request, HttpServletResponse response) throws SQLException, IOException, ServletException {
//        String fullName = request.getParameter("inputFullname");
//        String username = request.getParameter("inputUsername");
//        String email = request.getParameter("inputEmail");
//        String password = request.getParameter("inputPassword");
//        String role = "ADMIN";
//        String status = "ACTIVE";
//        User user = new User(fullName, username, email, password, role, status);
//        userService.addUser(user);
//        showListUser(request,response);
    }

}
