package spring.boot_security.models;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Data
@Entity
@Table(name = "roles")
public class Role implements GrantedAuthority {

    public Role() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String role;

    @Override
    public String getAuthority() {
        return role;
    }

    public String getRoleWithoutPrefix() {
        return role.substring("ROLE_".length());
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return role;
    }
}
