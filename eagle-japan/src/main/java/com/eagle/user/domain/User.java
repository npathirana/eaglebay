package com.eagle.user.domain;


import com.eagle.commons.domain.EntityBase;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user", catalog = "eagle")
@NamedQueries({
        @NamedQuery(
                name = "User.findByEmailStatus",
                query = "from User u  where upper (u.email) = upper(:email) and status = :status"
        )

})

@Inheritance(strategy=InheritanceType.JOINED)
public class User extends EntityBase implements java.io.Serializable {

    @Column(name = "email")
    @NotNull
    @Size(max = 100)
    private String email;

    @Column(name = "password")
    @NotNull
    @Size(max = 100)
    private String password;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "last_logged_on")
    private Date lastLoggedOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registered_on")
    private Date registeredOn;

    @Column(name = "attempts")
    private Short attempts;

    @Column(name = "status", columnDefinition = "TINYINT")
    private Short status;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserRole> roleList;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserPermission> permissionList;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLoggedOn() {
        return lastLoggedOn;
    }

    public void setLastLoggedOn(Date lastLoggedOn) {
        this.lastLoggedOn = lastLoggedOn;
    }

    public Date getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        this.registeredOn = registeredOn;
    }

    public Short getAttempts() {
        return attempts;
    }

    public void setAttempts(Short attempts) {
        this.attempts = attempts;
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public List<UserRole> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<UserRole> userRoleList) {
        this.roleList = userRoleList;
    }

    public List<UserPermission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<UserPermission> permissionList) {
        this.permissionList = permissionList;
    }
}
