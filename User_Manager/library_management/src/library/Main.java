package library;

import java.time.LocalDate;

import library.model.Function;
import library.model.RoleGroup;
import library.model.User;

public class Main {
    public static void main(String[] args) {
        // Tạo các chức năng
        Function viewBooks = new Function("ROLE_BOOK_VIEW", "Xem sach");
        Function createBook = new Function("ROLE_BOOK_CREATE", "Tao sach");
        Function deleteBook = new Function("ROLE_BOOK_DELETE", "Xoa sach");
        
        // Tạo các nhóm quyền
        RoleGroup admin = new RoleGroup("ADMIN", "Quan tri vien");
        admin.addFunction(viewBooks);
        admin.addFunction(createBook);
        admin.addFunction(deleteBook);
        
        RoleGroup librarian = new RoleGroup("LIBRARIAN", "Thu th");
        librarian.addFunction(viewBooks);
        librarian.addFunction(createBook);
        
        RoleGroup user = new RoleGroup("USER", "Nguoi dung");
        user.addFunction(viewBooks);
        
        // Tạo người dùng
        User adminUser = new User("admin", "admin123", "Admin User");
        adminUser.setPhoneNumber("0123456789");
        adminUser.setIdentityNumber("123456789");
        adminUser.setAge(30);
        adminUser.setBirthday(LocalDate.of(1990, 1, 1));
        adminUser.setAddress("Ha Noi");
        adminUser.addRoleGroup(admin);
        
        User librarianUser = new User("librarian", "lib123", "Librarian User");
        librarianUser.setPhoneNumber("0987654321");
        librarianUser.setIdentityNumber("987654321");
        librarianUser.setAge(25);
        librarianUser.setBirthday(LocalDate.of(1995, 5, 5));
        librarianUser.setAddress("Ho Chi Minh");
        librarianUser.addRoleGroup(librarian);
        
        User normalUser = new User("user", "user123", "Normal User");
        normalUser.setPhoneNumber("0123987456");
        normalUser.setIdentityNumber("456789123");
        normalUser.setAge(20);
        normalUser.setBirthday(LocalDate.of(2000, 10, 10));
        normalUser.setAddress("Da Nang");
        normalUser.addRoleGroup(user);
        
        // In thông tin người dùng
        System.out.println("=== Thong tin nguoi dung ===");
        printUserInfo(adminUser);
        printUserInfo(librarianUser);
        printUserInfo(normalUser);
    }
    
    private static void printUserInfo(User user) {
        System.out.println("\nNguoi dung: " + user.getFullname());
        System.out.println("Username: " + user.getUsername());
        System.out.println("So dien thoai: " + user.getPhoneNumber());
        System.out.println("CMND/CCCD: " + user.getIdentityNumber());
        System.out.println("Tuoi: " + user.getAge());
        System.out.println("Ngay sinh: " + user.getBirthday());
        System.out.println("Dia chi: " + user.getAddress());
        
        System.out.println("Nhom quyen:");
        for (RoleGroup roleGroup : user.getRoleGroups()) {
            System.out.println("  - " + roleGroup.getRoleGroupName() + " (" + roleGroup.getRoleGroupCode() + ")");
            System.out.println("    Chuc nang:");
            for (Function function : roleGroup.getFunctions()) {
                System.out.println("      + " + function.getFunctionName() + " (" + function.getFunctionCode() + ")");
            }
        }
    }
} 