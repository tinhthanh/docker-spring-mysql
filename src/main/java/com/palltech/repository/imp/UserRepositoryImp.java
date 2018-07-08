/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.palltech.repository.imp;
import com.palltech.model.User;
import com.palltech.repository.UserRepository;
import java.util.Optional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


/**
 *
 * @author Trinh
 */
@Repository
public class UserRepositoryImp implements UserRepository{
//  private static final Logger LOGGER = LogManager.getLogger(UserRepositoryImp.class);
  
	@Autowired
	private SessionFactory sessionFactory;
        
    @Override
     public Optional<User> getUserByUserName(String userName) {
           Session session = this.sessionFactory.openSession() ;
            User result = new User();
            Query query = session.createQuery("from User");
//            query.setParameter("username", userName);
          result = (User)query.uniqueResult();
           session.close();
         return Optional.ofNullable(result);
     }

    @Override
    public Optional<User> getUserById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int createUser(String email, String password, boolean status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
