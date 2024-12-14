package selected_labs.models;

import selected_labs.models.chat.IChatRoom;


public class Participant {
    private User user;
    private IChatRoom chatRoom;

    public Participant(User user, IChatRoom chatRoom) {
        this.user = user;
        this.chatRoom = chatRoom;
    }

    public User getUser() {
        return user;
    }

    public IChatRoom getChatRoom() {
        return chatRoom;
    }
}
