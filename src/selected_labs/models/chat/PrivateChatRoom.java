/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package selected_labs.models.chat;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import selected_labs.models.Message;
import selected_labs.models.User;

/**
 *
 * @author Ahmed shams
 */
public class PrivateChatRoom implements IChatRoom {
    private final String name;
    private final List<User> participants;
    private final List<Message> messages;
    private final Set<String> allowedUsers;
    private final User owner;
    private final int maxParticipants;

    public PrivateChatRoom(String name, User owner) {
        this(name, owner, 20); // Default max participants for private rooms
    }

    public PrivateChatRoom(String name, User owner, int maxParticipants) {
        this.name = name;
        this.owner = owner;
        this.participants = new ArrayList<>();
        this.messages = new ArrayList<>();
        this.allowedUsers = new HashSet<>();
        this.maxParticipants = maxParticipants;
        
        // Add owner as first participant and allowed user
        this.participants.add(owner);
        this.allowedUsers.add(owner.getUsername());
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
        return allowedUsers.contains(user.getUsername()) && 
               participants.size() < maxParticipants;
    }

    public void addAllowedUser(User user) {
        if (owner.getUsername().equals(user.getUsername()) || 
            owner.gerIsAdmin()) {
            allowedUsers.add(user.getUsername());
        }
    }

    public void removeAllowedUser(User user) {
        if (owner.getUsername().equals(user.getUsername()) || 
            owner.gerIsAdmin()) {
            allowedUsers.remove(user.getUsername());
            participants.removeIf(p -> p.getUsername().equals(user.getUsername()));
        }
    }

    public User getOwner() {
        return owner;
    }
}
