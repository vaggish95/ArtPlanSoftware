package com.artplansoftware.secondtask.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table (name = "users")
@Data
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;

    @Column (name = "name")
    String name;

    @Column (name = "password")
    String password;

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

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }
}
