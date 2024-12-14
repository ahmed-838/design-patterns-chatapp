package selected_labs.factory;

import selected_labs.models.chat.IChatRoom;
import selected_labs.models.ChatRoomType;
import selected_labs.models.User;

public interface IChatRoomFactory {
    IChatRoom createChatRoom(String roomName, ChatRoomType type, User owner);
}
