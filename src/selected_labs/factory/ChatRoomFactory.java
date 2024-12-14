package selected_labs.factory;

import selected_labs.models.chat.IChatRoom;
import selected_labs.models.chat.PublicChatRoom;
import selected_labs.models.chat.PrivateChatRoom;
import selected_labs.models.User;
import selected_labs.repository.ChatRoomRepository;
import selected_labs.exceptions.ChatRoomCreationException;
import selected_labs.models.ChatRoomType;

public class ChatRoomFactory implements IChatRoomFactory {
    private static volatile ChatRoomFactory instance;
    private final ChatRoomRepository chatRoomRepository;

    private ChatRoomFactory() {
        this.chatRoomRepository = new ChatRoomRepository();
    }

    public static ChatRoomFactory getInstance() {
        if (instance == null) {
            synchronized (ChatRoomFactory.class) {
                if (instance == null) {
                    instance = new ChatRoomFactory();
                }
            }
        }
        return instance;
    }

    @Override
    public IChatRoom createChatRoom(String roomName, ChatRoomType type, User owner) {
        validateInput(roomName, owner);
        
        IChatRoom chatRoom = switch (type) {
            case PUBLIC -> createPublicChatRoom(roomName);
            case PRIVATE -> createPrivateChatRoom(roomName, owner);
        };
        
        return chatRoomRepository.save(chatRoom);
    }

    private IChatRoom createPublicChatRoom(String roomName) {
        return new PublicChatRoom(roomName);
    }

    private IChatRoom createPrivateChatRoom(String roomName, User owner) {
        return new PrivateChatRoom(roomName, owner);
    }

    private void validateInput(String roomName, User owner) {
        if (roomName == null || roomName.trim().isEmpty()) {
            throw new ChatRoomCreationException("Room name cannot be empty");
        }
        if (owner == null) {
            throw new ChatRoomCreationException("Owner cannot be null");
        }
    }
}
