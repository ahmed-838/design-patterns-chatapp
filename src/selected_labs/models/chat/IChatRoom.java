package selected_labs.models.chat;

import java.util.List;
import selected_labs.models.Message;
import selected_labs.models.User;

public interface IChatRoom {
    String getName();
    List<User> getParticipants();
    List<Message> getMessages();
    void addParticipant(User user);
    void addMessage(Message message);
    boolean canJoin(User user);
    
}
