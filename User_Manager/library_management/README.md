# Library Management System

Hệ thống quản lý thư viện với các chức năng:
- Quản lý người dùng (đăng ký, đăng nhập)
- Quản lý nhóm quyền (Admin, Librarian, User)
- Quản lý chức năng (ROLE_BOOK_VIEW, ROLE_BOOK_CREATE, ROLE_BOOK_DELETE)

## Cấu trúc dự án

```
library-management/
├── src/
│   └── library/
│       ├── model/
│       │   ├── User.java
│       │   ├── RoleGroup.java
│       │   └── Function.java
│       └── Main.java

```


## Các chức năng

### Quản lý người dùng
- Đăng ký người dùng mới
- Đăng nhập
- Thông tin người dùng: username, password, fullname, phone_number, identity_number, age, birthday, address

### Quản lý nhóm quyền
- Admin: Có tất cả quyền
- Librarian: Có quyền xem và tạo sách
- User: Chỉ có quyền xem sách

### Quản lý chức năng
- ROLE_BOOK_VIEW: Xem sách
- ROLE_BOOK_CREATE: Tạo sách
- ROLE_BOOK_DELETE: Xóa sách 
