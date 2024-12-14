package selected_labs.factory;
import selected_labs.models.User;

public class UserFactory {

    public static User createRegularUser(String username ,String password, boolean isAdmin) {
        return new User(username ,password, isAdmin=false);
    }

    public static User createAdminUser(String username  ,String password, boolean isAdmin) {
        return new User(username  ,password, isAdmin);
    }
}
