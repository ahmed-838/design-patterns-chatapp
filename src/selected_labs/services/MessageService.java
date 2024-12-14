package selected_labs.services;

import selected_labs.models.Message;
import selected_labs.models.User;

import java.util.ArrayList;
import java.util.List;

public class MessageService {
    private List<Message> messages = new ArrayList<>();

    // إرسال رسالة
    public void sendMessage(User sender, String content) {
        Message message = new Message(sender, content, System.currentTimeMillis());
        messages.add(message);
    }

    // عرض كل الرسائل
    public List<Message> getAllMessages() {
        return messages;
    }
}
