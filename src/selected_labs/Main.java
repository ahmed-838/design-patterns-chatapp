package selected_labs;

import selected_labs.models.User;
import selected_labs.models.ChatRoomType;
import selected_labs.services.ChatRoomService;
import selected_labs.services.UserService;

public class Main {
    public static void main(String[] args) {
        // Initialize services
        UserService userService = new UserService();
        ChatRoomService chatRoomService = new ChatRoomService();

        // Create users
        User admin = userService.registerUser("Admin", "admin123", true);
        User user1 = userService.registerUser("Alice", "pass123", false);
        User user2 = userService.registerUser("Bob", "pass456", false);

        // Create chat rooms
        chatRoomService.createChatRoom("General", ChatRoomType.PUBLIC, admin);
        chatRoomService.createChatRoom("Team-A", ChatRoomType.PRIVATE, admin);

        // Add users to rooms
        chatRoomService.addUserToChatRoom("General", user1);
        chatRoomService.addUserToChatRoom("General", user2);
        chatRoomService.addUserToChatRoom("Team-A", user1);

        // Send messages
        chatRoomService.sendMessageToChatRoom("General", user1, "Hello everyone!");
        chatRoomService.sendMessageToChatRoom("Team-A", admin, "Team meeting tomorrow");

        // Show participants
        chatRoomService.showParticipants();
    }
}

    

