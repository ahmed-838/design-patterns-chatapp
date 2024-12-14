# Chat App System Design Documentation

## **1. Overview**
This document provides an overview of the system design for a Java-based chat application. The design follows principles of scalability, maintainability, and adherence to SOLID principles and Java design patterns.

---

## **2. Architectural Pattern**
The application follows a **Layered Architecture**:

1. **Presentation Layer**: Handles user interactions using Swing GUI.
   - Displays chatrooms, user messages, and login forms.
   - Sends user inputs to the business logic layer for processing.

2. **Service Layer (Business Logic)**: Implements core application logic.
   - Processes user authentication and chatroom membership.
   - Manages message broadcasting and logging.
   - Encapsulates business rules and integrates design patterns like Factory and Singleton.

3. **Persistence Layer**: Manages data storage and retrieval.
   - Interfaces with the MySQL database using JDBC.
   - Utilizes a Singleton pattern to maintain a single database connection.

4. **Data Model Layer**: Represents the application's core entities (e.g., `User`, `ChatRoom`, `Message`).

---

## **3. Key Features**

1. **User Authentication**:
   - Login and registration functionality.
   - Differentiation between admin and regular users.

2. **Chat Functionality**:
   - Public and private chatrooms.
   - One-to-one and group messaging support.

3. **Message Management**:
   - Stores message history with timestamps.
   - Supports real-time message updates.

---

## **4. Design Principles**

### **SOLID Principles**
1. **Single Responsibility Principle**:
   - Each class has a single well-defined responsibility.
   - For instance, `UserService` handles user-related operations, while `ChatRoomService` manages chatroom-related logic.

2. **Open/Closed Principle**:
   - The system is designed to be extensible.
   - New features like file sharing or media messages can be added without modifying existing code.

3. **Liskov Substitution Principle**:
   - Subtypes like `AdminUser` and `RegularUser` can replace the `User` class without altering functionality.

4. **Interface Segregation Principle**:
   - Different interfaces are defined for user authentication, chatroom management, and message broadcasting.

5. **Dependency Inversion Principle**:
   - High-level modules do not depend on low-level modules but on abstractions.
   - Example: DAO interfaces for database operations.

---

## **5. Design Patterns**

### **Singleton**
- Used for managing the database connection (`JDBCConnection`).
- Ensures a single instance of the connection throughout the application's lifecycle.

### **Factory**
- Creates instances of `AdminUser` and `RegularUser` dynamically based on user roles.
- Used for `ChatRoom` creation (e.g., `PublicChatRoom` or `PrivateChatRoom`).

### **Observer**
- Keeps chatroom members updated with real-time messages.

### **DAO (Data Access Object)**
- Abstracts database access operations (e.g., `UserDAO`, `MessageDAO`).

---

## **6. Components**

### **Swing GUI**
- Modules: Login, Registration, Chat Interface.
- Event-driven programming for button clicks and user actions.

### **Services**
- `UserService`: Handles user registration, login, and role management.
- `ChatRoomService`: Manages chatroom creation and membership.
- `MessageService`: Processes message broadcasting and persistence.

### **Database**
- **MySQL Database** with four tables:
  - `Users`: Stores user credentials and roles.
  - `ChatRooms`: Maintains chatroom details.
  - `Messages`: Logs all messages.
  - `User_ChatRooms`: Tracks user membership in chatrooms.

---

## **7. Data Flow**

1. **User Login**:
   - User enters credentials into the GUI.
   - Credentials are passed to `UserService`, which validates them using the database.
   - On success, a session is initiated.

2. **Message Sending**:
   - User types a message in the chat GUI.
   - `MessageService` processes and stores the message in the database.
   - Observers (other chatroom members) are notified in real time.

3. **ChatRoom Creation**:
   - Admin users create chatrooms via the GUI.
   - `ChatRoomService` validates inputs and stores the chatroom in the database.

---

## **8. System Diagram**
- **Frontend**: Swing GUI.
- **Backend**: Service layer, Database layer.
- **Database**: MySQL for persistent storage.

---

## **9. Future Enhancements**
1. Add media sharing (images, videos).
2. Integrate WebSocket for real-time communication.
3. Implement advanced search and filtering options for messages.

---

This system design ensures modularity, scalability, and adherence to best practices for building a robust chat application.

