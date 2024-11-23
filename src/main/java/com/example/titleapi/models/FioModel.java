package com.example.titleapi.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "fio")
@NoArgsConstructor
public class FioModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String name;
    private String surname;
    private String lastname;
    @OneToOne(optional = true, mappedBy = "fio", cascade = CascadeType.ALL)
    private AuthorModel author;

    public FioModel(long ID, String name, String surname, String lastname, AuthorModel author) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.lastname = lastname;
        this.author = author;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public AuthorModel getAuthor() {
        return author;
    }

    public void setAuthor(AuthorModel author) {
        this.author = author;
    }
}
