package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) {
      AnnotationConfigApplicationContext context =
              new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user = new User("Игорь", "Великий", "igorV1989@mail.com");
      user.setCar(new Car("Porh", 991));
      User user2 = new User("Vova", "Karova", "MyMY@mail.com");
      user2.setCar(new Car("Lexus", 666));
      User user3 = new User("Игнат", "Игнатов", "igNigN@mail.com");
      user3.setCar(new Car("Lambo", 228));
      User user4 = new User("Джигит", "Лазейкин", "Azzzza@mail.com");
      user4.setCar(new Car("Кавер Самолет ", 3000));

      List<User> userList = userService.listUsers();
      userList.forEach(System.out::println);

      List<User> userList2 = userService.byCar("Жига",999);
      userList2.forEach(System.out::println);

      context.close();
   }
}
