package edu.wsb.authdemo.auth;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Authority {

    @Id
    @GeneratedValue
    Long id;

    @Column(nullable = false, unique = true)
    @Enumerated(EnumType.STRING)
    AuthorityName name;

    public Authority(AuthorityName name) {
        this.name = name;
    }
}
