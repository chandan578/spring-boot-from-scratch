package org.example.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.model.User;
import org.example.service.UserService;

import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UserServlet extends HttpServlet {

    private UserService userService = new UserService();

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
        Integer id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String mobile = req.getParameter("mobile");

        if(id==null || name==null || email==null || mobile==null){
            res.setStatus(400);
            res.setContentType("application/json");
            res.getWriter().write("{\n" +
                    " \"message\" : \"Some fields are missing..\" \n"+
                    "}");
        }

        User user = new User(id, name, email, mobile);
        User createdUser = userService.createUser(user);
        res.setStatus(201);
        res.setContentType("application/json");
        res.getWriter().write("{\n" +
               " \"message\" : \"Added user successfully..\" \n"+
                        "}");

    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        String idParam = req.getParameter("id");
        if(idParam == null){
            List<User> users = userService.getAllUsers();
            res.setStatus(200);
            res.setContentType("application/json");
            res.getWriter().write(usersToJson(users));
        }

        Integer id = Integer.parseInt(idParam);
        User user = userService.getUserById(id);

        if(user == null){
            res.setStatus(404);
            res.setContentType("application/json");
        }

        res.setStatus(200);
        res.setContentType("application/json");
        res.getWriter().write(userToJson(user));
    }

    @Override
    public void doPut(HttpServletRequest req, HttpServletResponse res){

    }

    @Override
    public void doDelete(HttpServletRequest req, HttpServletResponse res){

    }

    public String userToJson(User user){
        return  "{\n" +
                "    \"id\":" + user.getId() + " ,\n" +
                "    \"name\":" + user.getName() + ",\n" +
                "    \"email\":" + user.getEmail() + ",\n" +
                "    \"mobile\":" + user.getMobile() +"\n" +
                "}";
    }

    public String usersToJson(List<User> users){
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("[");

        for(int i=0; i<users.size(); i++){
            stringBuilder.append(userToJson(users.get(i)));

            if(i < users.size()-1) stringBuilder.append(",");
        }

        stringBuilder.append("]");

        return stringBuilder.toString();
    }

}
