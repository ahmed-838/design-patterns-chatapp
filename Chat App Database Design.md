# Chat App Database Design

## **1. Entities and Attributes**

### **Users Table**
| Attribute       | Type         | Description                      |
|-----------------|--------------|----------------------------------|
| `user_id`       | INT (PK)     | المعرف الفريد للمستخدم           |
| `username`      | VARCHAR(50)  | اسم المستخدم                     |
| `password`      | VARCHAR(255) | كلمة المرور (يُفضل تشفيرها)       |
| `is_admin`      | BOOLEAN      | تحديد ما إذا كان Admin           |
| `created_at`    | DATETIME     | وقت إنشاء الحساب                 |

### **ChatRooms Table**
| Attribute       | Type         | Description                      |
|-----------------|--------------|----------------------------------|
| `chatroom_id`   | INT (PK)     | المعرف الفريد للغرفة             |
| `name`          | VARCHAR(50)  | اسم الغرفة                       |
| `is_private`    | BOOLEAN      | تحديد إذا كانت الغرفة خاصة       |
| `created_at`    | DATETIME     | وقت إنشاء الغرفة                 |

### **Messages Table**
| Attribute       | Type         | Description                      |
|-----------------|--------------|----------------------------------|
| `message_id`    | INT (PK)     | المعرف الفريد للرسالة            |
| `content`       | TEXT         | نص الرسالة                       |
| `timestamp`     | DATETIME     | وقت إرسال الرسالة                |
| `user_id`       | INT (FK)     | المرسل                           |
| `chatroom_id`   | INT (FK)     | الغرفة التي أُرسلت فيها الرسالة  |
| `created_at`    | DATETIME     | وقت إنشاء الرسالة                |

### **User_ChatRooms Table** (Relationship Table for Many-to-Many)
| Attribute       | Type         | Description                      |
|-----------------|--------------|----------------------------------|
| `user_id`       | INT (FK)     | معرف المستخدم                   |
| `chatroom_id`   | INT (FK)     | معرف الغرفة                     |
| `created_at`    | DATETIME     | وقت إضافة المستخدم إلى الغرفة    |

---

## **2. Relationships**

### **Entity Relationships**
1. **Users** → 1:N → **Messages**
   - كل مستخدم يمكن أن يرسل العديد من الرسائل.
2. **ChatRooms** → 1:N → **Messages**
   - كل غرفة يمكن أن تحتوي على العديد من الرسائل.
3. **Users** → N:M → **ChatRooms** (via **User_ChatRooms**)
   - كل مستخدم يمكن أن ينتمي إلى عدة غرف، وكل غرفة يمكن أن تحتوي على عدة مستخدمين.

---

## **3. ERD Description**

1. **Users**:
   - يحتوي على تفاصيل المستخدمين مثل اسم المستخدم وكلمة المرور وحالتهم كمسؤول أو مستخدم عادي.
2. **ChatRooms**:
   - يحتوي على معلومات حول الغرف (اسم الغرفة وما إذا كانت خاصة).
3. **Messages**:
   - يحتوي على تفاصيل الرسائل التي تم إرسالها، مثل النص، ووقت الإرسال، والمرسل، والغرفة المرتبطة بها.
4. **User_ChatRooms**:
   - جدول وسيط يربط المستخدمين بالغرف (علاقة Many-to-Many).

---

## **4. ERD Diagram**

To visualize the ERD:
- Use tools like [Draw.io](https://app.diagrams.net/), [Lucidchart](https://www.lucidchart.com/), or [MySQL Workbench](https://dev.mysql.com/workbench/).

### **Diagram Layout**
- Draw rectangles for each table (**Users**, **ChatRooms**, **Messages**, **User_ChatRooms**).
- Add attributes to each table.
- Use lines to represent relationships:
  - **1:N** between **Users** and **Messages**.
  - **1:N** between **ChatRooms** and **Messages**.
  - **N:M** between **Users** and **ChatRooms** via **User_ChatRooms**.
