package com.eagle.user.domain;


import com.eagle.commons.domain.EntityBase;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role", catalog = "eagle")
public class Role extends EntityBase implements java.io.Serializable {

    public static final String ROLE_ROOT = "role.root";
    public static final String ROLE_SELLER = "role.seller";
    public static final String ROLE_BUYER = "role.buyer";
    public static final String ROLE_SELLER_EMPLOYEE = "role.seller.employee";

    @Column(name = "code")
    private String code;

    @Column(name = "status")
    private Short status;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "role_permission", catalog = "eagle",
            joinColumns = {@JoinColumn(name = "role_id", nullable = false, updatable = false)},
            inverseJoinColumns = {@JoinColumn(name = "permission_id", nullable = false, updatable = false)})
    private List<Permission> permissionList;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "role")
    private List<UserRole> userRoleList;

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

    public List<Permission> getPermissionList() {
        return this.permissionList;
    }

    public void setPermissionList(List<Permission> permissions) {
        this.permissionList = permissions;
    }

    public List<UserRole> getUserRoleList() {
        return this.userRoleList;
    }

    public void setUserRoleList(List<UserRole> userRoles) {
        this.userRoleList = userRoles;
    }

}
