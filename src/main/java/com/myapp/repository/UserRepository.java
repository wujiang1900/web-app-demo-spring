package com.myapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.myapp.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByUserName(String userName);
  //  public List<User> remove(String lastName);

}