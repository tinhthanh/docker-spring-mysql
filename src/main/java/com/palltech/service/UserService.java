/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.palltech.service
    ;
import com.palltech.model.User;
import java.util.Optional;

/**
 *
 * @author Trinh
 */
public interface UserService {
    public Optional<User> getUserByUserName(String userName);
    public Optional<User> getUserById(int id);
    public int createUser(String email, String password,boolean status);
 
}
