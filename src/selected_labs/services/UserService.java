package selected_labs.services;

import selected_labs.models.User;
import selected_labs.repository.UserRepository;
import java.util.List;
import java.util.Optional;

public class UserService {
    private final UserRepository userRepository;

    public UserService() {
        this.userRepository = new UserRepository();
    }

    public User registerUser(String username, String password, boolean isAdmin) {
        if (userRepository.exists(username)) {
            throw new IllegalArgumentException("Username already exists");
        }
        
        User user = new User(username, password, isAdmin);
        return userRepository.save(user);
    }

    public Optional<User> findUser(String username) {
        return userRepository.findById(username);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public boolean deleteUser(String username) {
        if (!userRepository.exists(username)) {
            return false;
        }
        userRepository.delete(username);
        return true;
    }

    public User updateUser(User user) {
        if (!userRepository.exists(user.getUsername())) {
            throw new IllegalArgumentException("User does not exist");
        }
        return userRepository.save(user);
    }

    public boolean authenticateUser(String username, String password) {
        return userRepository.findById(username)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}
