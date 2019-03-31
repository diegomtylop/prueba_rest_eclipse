package com.aliadoit.database;


import com.aliadoit.entities.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class UserDao {
    public List<User> getAllUsers(){

        List<User> userList = null;
        try {
            File file = new File("Users.dat");
            System.out.println("Getting info from file "+file.getAbsolutePath());
            if (!file.exists()) {
                User user = new User(1, "Chapatin", "Teacher");
                userList = new ArrayList<User>();
                userList.add(user);
                
                User user2 = new User(2, "Jirafales", "Teacher");
                userList.add(user2);
                saveUserList(userList);
            }
            else{
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                userList = (List<User>) ois.readObject();
                ois.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userList;
    }
    
    public User getUser(int idUser) {
    	
    	User a = new User();
    	a.setId( idUser );
    	
    	
    	
    	
    	List<User> usuarios = readFileAsList();
    	
    	usuarios.indexOf( a );
    	
    	/*
    	 * Lambda 8
    	 * User user = usuarios.stream().filter( o-> o.getId() == idUser ).findFirst().get();
    	 */
    	for( User buscado : usuarios ) {
    		if( buscado.getId() == idUser ) {
    			return buscado;
    		}
    	}
    	return null;
    }
    
    private void saveUserList(List<User> userList){
        try {
            File file = new File("Users.dat");
            System.out.println("File location "+file.getAbsolutePath());
            FileOutputStream fos;
            fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(userList);
            oos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private List<User> readFileAsList(){
    	List<User> userList = null;
        try {
            File file = new File("Users.dat");
            System.out.println("Getting info from file "+file.getAbsolutePath());
            if (!file.exists()) {
                User user = new User(1, "Chapatin", "Teacher");
                userList = new ArrayList<User>();
                userList.add(user);
                
                User user2 = new User(2, "Jirafales", "Teacher");
                userList.add(user2);
                saveUserList(userList);
            }
            else{
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);
                userList = (List<User>) ois.readObject();
                ois.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return userList;
    }
}