package org.acme.Security;

import io.quarkus.elytron.security.common.BcryptUtil;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import io.quarkus.security.jpa.Password;
import io.quarkus.security.jpa.Roles;
import io.quarkus.security.jpa.UserDefinition;
import io.quarkus.security.jpa.Username;

@Entity
@Table(name = "test_user")
@UserDefinition
public class User extends PanacheEntity
{
    
    @Username 
    public String username;
    @Password 
    public String password;
    @Roles 
    public String role;

    public Long kundenid;

    public static void add(String username, String password, String role, Long kundenid) {
        User user = new User();
        user.username = username;
        user.password = BcryptUtil.bcryptHash(password);
        user.role = role;
        user.kundenid = kundenid;
        user.persist();
    }

    public static void add(String username, String password, String role) { 
        User user = new User();
        user.username = username;
        user.password = BcryptUtil.bcryptHash(password);
        user.role = role;
        user.kundenid = null;
        user.persist();
    }
    
}
