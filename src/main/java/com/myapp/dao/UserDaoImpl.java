package com.myapp.dao;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import com.myapp.domain.User;
import com.myapp.repository.UserRepository;


@Repository
public class UserDaoImpl implements UserDao {

  @Inject
  UserRepository mongoOperator;

  public User findUser(String userName){


	  User user = mongoOperator.findByUserName(userName);
	  System.out.println("found mongo user : " + user);
	  return user;
	  //  return new User();
  }

@Override
public void addUser(User user) {
	// TODO Auto-generated method stub
	mongoOperator.save(user);
}

}
