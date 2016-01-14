package com.eagle.user.domain;


import com.eagle.commons.domain.EntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "permission", catalog = "eagle")
public class Permission extends EntityBase implements java.io.Serializable {

    @Column(name = "code")
    private String code;

    @Column(name = "status")
    private Short status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_permission", catalog = "eagle",
            joinColumns = {@JoinColumn(name = "permission_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)}
    )
    private List<Role> roleList;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_permission", catalog = "eagle",
            joinColumns = {@JoinColumn(name = "permission_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "user_id", nullable = false, updatable = false)}
    )
    private List<User> userList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "permission")
    private List<UserPermission> userPermissions;

    public String getCode() {
        return this.code;
    }

    public void setCode(String name) {
        this.code = name;
    }

    public Short getStatus() {
        return this.status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public List<Role> getRoleList() {
        return this.roleList;
    }

    public void setRoleList(List<Role> roles) {
        this.roleList = roles;
    }

    public List<UserPermission> getUserPermissions() {
        return this.userPermissions;
    }

    public void setUserPermissions(List<UserPermission> userPermissions) {
        this.userPermissions = userPermissions;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }
}
