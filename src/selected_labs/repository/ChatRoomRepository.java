package selected_labs.repository;

import selected_labs.models.chat.IChatRoom;
import selected_labs.config.DatabaseConnection;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

public class ChatRoomRepository implements Repository<IChatRoom, String> {
    private final DatabaseConnection dbConnection;

    public ChatRoomRepository() {
        this.dbConnection = DatabaseConnection.getInstance();
    }

    @Override
    public Optional<IChatRoom> findById(String id) {
        // Implementation
        return Optional.empty();
    }

    @Override
    public List<IChatRoom> findAll() {
        return new ArrayList<>();
    }

    @Override
    public IChatRoom save(IChatRoom chatRoom) {
        // Implementation
        return chatRoom;
    }

    @Override
    public void delete(String id) {
        // Implementation
    }

    @Override
    public boolean exists(String id) {
        // Implementation
        return false;
    }
}
