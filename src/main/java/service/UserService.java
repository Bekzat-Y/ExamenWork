package service;

import entity.Users;
import org.apache.catalina.User;

import java.util.List;

public interface UserService {

    void insertUsers(Users users);

    List<Users> getAll();


    Long delete(Long id);


    void update(Long id , Users user);

}
