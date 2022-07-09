package com.artplansoftware.secondtask.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table (name = "Animals")
@Data
@NoArgsConstructor
public class Animal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    long id;

    @Column(name = "name")
    String name;

    @Column(name = "sex")
    char sex;

    @Column(name = "birthday")
    LocalDate birthday;

    @JsonIgnore
    @ManyToOne
    User user;

}
