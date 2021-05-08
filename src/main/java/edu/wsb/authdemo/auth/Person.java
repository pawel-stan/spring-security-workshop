package edu.wsb.authdemo.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Person {

    @Id
    @GeneratedValue
    Long id;

    @NotEmpty
    @Size(min = 5, max = 100)
    @Column(nullable = false, unique = true)
    String username;

    @NotEmpty
    @Column(nullable = false)
    String password;

    /**
     * Imię i nazwisko
     */
    @NotEmpty
    @Column(nullable = false)
    String name;

    @Column(nullable = false)
    @ColumnDefault(value = "true")
    Boolean enabled = true;

    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "person_authorities",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id"))
    Set<Authority> authorities;

    public Person(String username, String password, String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }
}
