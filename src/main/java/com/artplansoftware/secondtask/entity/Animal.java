package com.artplansoftware.secondtask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table (name = "Animals")
@Getter
@Setter
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "gender")
    private char gender;

    @Column(name = "birthday")
    private Date birthday;

    @JsonIgnore
    @ManyToOne
    private User user;

}
