package  library.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class User {
    private Long userId;
    private String username;
    private String password;
    private String fullname;
    private String phoneNumber;
    private String identityNumber;
    private Integer age;
    private LocalDate birthday;
    private String address; 
    private Set<RoleGroup> roleGroups = new HashSet<>();

    public User(String username, String password, String fullname) {
        this.username = username;
        this.password = password;
        this.fullname = fullname;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<RoleGroup> getRoleGroups() {
        return roleGroups;
    }

    public void setRoleGroups(Set<RoleGroup> roleGroups) {
        this.roleGroups = roleGroups;
    }

    public void addRoleGroup(RoleGroup roleGroup) {
        this.roleGroups.add(roleGroup);
    }

    public void removeRoleGroup(RoleGroup roleGroup) {
        this.roleGroups.remove(roleGroup);
    }
}