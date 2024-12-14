package selected_labs.models.chat;

import java.util.ArrayList;
import java.util.List;
import selected_labs.models.Message;
import selected_labs.models.User;

public class PublicChatRoom implements IChatRoom {
    private final String name;
    private final List<User> participants;
    private final List<Message> messages;
    private final int maxParticipants;

    public PublicChatRoom(String name) {
        this(name, 100); // Default max participants
    }

    public PublicChatRoom(String name, int maxParticipants) {
        this.name = name;
        this.participants = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.maxParticipants = maxParticipants;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public List<User> getParticipants() {
        return new ArrayList<>(participants);
    }

    @Override
    public List<Message> getMessages() {
        return new ArrayList<>(messages);
    }

    @Override
    public void addParticipant(User user) {
        if (canJoin(user) && !participants.contains(user)) {
            participants.add(user);
        }
    }

    @Override
    public void addMessage(Message message) {
        if (participants.contains(message.getSender())) {
            messages.add(message);
        }
    }

    @Override
    public boolean canJoin(User user) {
        return participants.size() < maxParticipants;
    }
}
