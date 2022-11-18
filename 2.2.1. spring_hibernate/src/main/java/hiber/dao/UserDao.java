package hiber.dao;

import hiber.model.User;

import java.util.List;

public interface UserDao {
   void add(User user);
   List<User> listUsers();

    @SuppressWarnings("unchecked")
    List<User> byCar(String mod, Integer ser);
}
