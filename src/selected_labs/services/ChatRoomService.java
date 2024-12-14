package selected_labs.services;

import selected_labs.models.chat.IChatRoom;
import selected_labs.models.Message;
import selected_labs.models.User;
import selected_labs.models.ChatRoomType;
import selected_labs.factory.ChatRoomFactory;
import selected_labs.exceptions.ChatRoomCreationException;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class ChatRoomService {
    private final Map<String, IChatRoom> chatRooms;
    private final ChatRoomFactory chatRoomFactory;

    public ChatRoomService() {
        this.chatRooms = new HashMap<>();
        this.chatRoomFactory = ChatRoomFactory.getInstance();
    }

    public void showParticipants() {
        chatRooms.forEach((roomName, chatRoom) -> {
            System.out.println("Room: " + roomName);
            System.out.println("Participants:");
            chatRoom.getParticipants()
                    .forEach(user -> System.out.println(" - " + user.getUsername()));
        });
    }
    
    public boolean createChatRoom(String roomName, ChatRoomType type, User owner) {
        try {
            if (chatRooms.containsKey(roomName)) {
                return false;
            }

            IChatRoom chatRoom = chatRoomFactory.createChatRoom(roomName, type, owner);
            chatRooms.put(roomName, chatRoom);
            return true;
        } catch (ChatRoomCreationException e) {
            System.err.println("Failed to create chat room: " + e.getMessage());
            return false;
        }
    }

    public boolean addUserToChatRoom(String roomName, User user) {
        IChatRoom chatRoom = chatRooms.get(roomName);
        if (chatRoom != null && chatRoom.canJoin(user)) {
            chatRoom.addParticipant(user);
            return true;
        }
        return false;
    }

    public boolean sendMessageToChatRoom(String roomName, User sender, String content) {
        IChatRoom chatRoom = chatRooms.get(roomName);
        if (chatRoom != null) {
            Message message = new Message(sender, content, System.currentTimeMillis());
            chatRoom.addMessage(message);
            return true;
        }
        return false;
    }

    public List<Message> getChatRoomMessages(String roomName) {
        IChatRoom chatRoom = chatRooms.get(roomName);
        return chatRoom != null ? chatRoom.getMessages() : List.of();
    }
}
