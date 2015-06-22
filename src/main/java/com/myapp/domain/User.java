package com.myapp.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

  @Id
  private String id;

  private String userName;
  private String passWord;

  public User() {}

 public User(String userName, String passWord) {
	super();
	this.userName = userName;
	this.passWord = passWord;
}

public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

 public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public String getPassWord() {
    return passWord;
  }

  public void setPassWord(String passWord) {
    this.passWord = passWord;
  }

}
