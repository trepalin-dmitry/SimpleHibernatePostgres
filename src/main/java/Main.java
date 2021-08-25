import models.Auto;
import models.User;
import services.UserService;

public class Main {
    public static void main(String[] args) {

        try(UserService userService = new UserService()) {
            System.out.println("test01");

            User user = new User("Masha", 26);
            userService.saveUser(user);
            user.addAuto(new Auto("Ferrari", "red"));
            user.addAuto(new Auto("Ford", "black"));
            userService.updateUser(user);

            System.out.println("test02");

            var users = userService.findAllUsers();
            for (User saveUser : users) {
                System.out.println("change");
                saveUser.setName(saveUser.getName() + "123");
                userService.saveUser(saveUser);
            }
        }
    }
}