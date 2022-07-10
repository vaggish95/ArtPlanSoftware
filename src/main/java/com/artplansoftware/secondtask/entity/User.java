package com.artplansoftware.secondtask.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table (name = "users")
@Setter
@Getter
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column (name = "name")
    private String name;

    @Column (name = "password")
    private String password;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id" ))
    private Collection<Role> roles;

    @OneToMany (
            mappedBy = "user",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List <Animal> animalsList;

    public User (String name, String password, List <Role> rolesList) {
        this.name = name;
        this.password = password;
        this.roles= rolesList;
    }

}
