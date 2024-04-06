package org.example.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.example.dto.ChatDto;
import org.example.model.Chat;
import org.example.service.DatabaseManager;
import org.example.service.ModelConverter;

import java.io.IOException;

public class RoomServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //get room info
        try {
            DatabaseManager databaseManager = new DatabaseManager();

            String name = req.getParameter("name");
            Integer maxMembers = Integer.valueOf(req.getParameter("maxMembers"));

            System.out.println(name + " " + maxMembers);

            if(databaseManager.alreadyExists(name)){
                resp.getWriter().write(200);
                resp.getWriter().write("an account with current name already exist");
            } else {
                databaseManager.addRoom(name, maxMembers);
                resp.setStatus(200);
            }
        } catch (Exception e){
            resp.setStatus(400);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //send room info
        try {
            DatabaseManager databaseManager = new DatabaseManager();
            ObjectMapper objectMapper = new ObjectMapper();
            ModelConverter converter = new ModelConverter();

            String name = req.getParameter("name");

            Chat chat = databaseManager.getChatByName(name);
            ChatDto chatDto = converter.convertChat(chat);

            String jsonChatDto = objectMapper.writeValueAsString(chatDto);

            resp.getWriter().write(jsonChatDto);
            resp.setStatus(200);
        } catch (Exception e) {
            resp.setStatus(400);
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //change room name
        try {
            DatabaseManager databaseManager = new DatabaseManager();

            String name = req.getParameter("name");
            String newName = req.getParameter("newName");

            //databaseManager.changeName(name, newName);
            resp.getWriter().write("old name:" + name + "   -->   new name:" + newName);
            resp.setStatus(200);
        } catch (Exception e) {
            resp.setStatus(400);
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { //del room
        try {
            DatabaseManager databaseManager = new DatabaseManager();

            String name = req.getParameter("name");

            databaseManager.removeRoom(name);
            resp.setStatus(200);
        } catch (Exception e){
            resp.getWriter().write(400);
        }
    }
}
