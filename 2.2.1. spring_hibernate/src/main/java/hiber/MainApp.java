package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("Bruse", "Wayne", "im_not_batman@wayneent.com",
                new Car("Batmobile", 4)));
        userService.add(new User("Michael", "Knight", "this_is_hasselchoff@whatthe.com",
                new Car("KITT", 1)));
        userService.add(new User("Max", "Mad", "unknown ancient technology",
                new Car("Doom Truck of Rage", 3626235)));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car = " + user.getCar());
            System.out.println();
        }
        System.out.println(userService.getUserByCar("KITT", 1));

        context.close();
    }
}
