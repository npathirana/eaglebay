package com.eagle.user.domain;


import com.eagle.commons.domain.EntityBase;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "role_permission", catalog = "eagle")
@NamedQueries({
    @NamedQuery(
            name = "RolePermission.findByRoleId",
            query = "from RolePermission rp  where rp.role.id = :roleId"
    )

})
public class RolePermission extends EntityBase implements java.io.Serializable {

    @ManyToOne
    @JoinColumn(name = "permission_id")
    private Permission permission;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public Permission getPermission() {
        return permission;
    }

    public void setPermission(Permission permission) {
        this.permission = permission;
    }

    public Role getUser() {
        return role;
    }

    public void setUser(Role role) {
        this.role = role;
    }
}
