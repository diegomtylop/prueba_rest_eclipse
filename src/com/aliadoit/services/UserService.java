package com.aliadoit.services;

import com.aliadoit.database.UserDao;
import com.aliadoit.entities.User;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/UserService")
public class UserService {
    UserDao userDao = new UserDao();

    @GET
    @Path("/users")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN})
    public List<User> getUsers(){
        return userDao.getAllUsers();
    }
    
    
}