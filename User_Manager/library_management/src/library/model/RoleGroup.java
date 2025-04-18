package library.model;

import java.util.HashSet;
import java.util.Set;

public class RoleGroup {
    private Long roleGroupId;
    private String roleGroupCode;
    private String roleGroupName;
    private String description;
    private Set<Function> functions = new HashSet<>();

    public RoleGroup(String roleGroupCode, String roleGroupName) {
        this.roleGroupCode = roleGroupCode;
        this.roleGroupName = roleGroupName;
    }

    public Long getRoleGroupId() {
        return roleGroupId;
    }

    public void setRoleGroupId(Long roleGroupId) {
        this.roleGroupId = roleGroupId;
    }

    public String getRoleGroupCode() {
        return roleGroupCode;
    }

    public void setRoleGroupCode(String roleGroupCode) {
        this.roleGroupCode = roleGroupCode;
    }

    public String getRoleGroupName() {
        return roleGroupName;
    }

    public void setRoleGroupName(String roleGroupName) {
        this.roleGroupName = roleGroupName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Function> getFunctions() {
        return functions;
    }

    public void setFunctions(Set<Function> functions) {
        this.functions = functions;
    }

    public void addFunction(Function function) {
        this.functions.add(function);
    }

    public void removeFunction(Function function) {
        this.functions.remove(function);
    }
} 