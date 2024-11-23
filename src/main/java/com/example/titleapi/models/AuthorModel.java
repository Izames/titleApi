package com.example.titleapi.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "author")
@NoArgsConstructor
public class AuthorModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private int age;
    private String nickname;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "title_id")
    private TitleModel title;
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="fio_id")
    private FioModel fio;

    public AuthorModel(long ID, int age, String nickname, TitleModel title, FioModel fio) {
        this.ID = ID;
        this.age = age;
        this.nickname = nickname;
        this.title = title;
        this.fio = fio;
    }

    public long getID() {
        return ID;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public TitleModel getTitle() {
        return title;
    }

    public void setTitle(TitleModel title) {
        this.title = title;
    }

    public FioModel getFio() {
        return fio;
    }

    public void setFio(FioModel fio) {
        this.fio = fio;
    }
}
