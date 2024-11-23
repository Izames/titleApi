package com.example.titleapi.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ranobe")
@NoArgsConstructor
public class RanobeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String name;
    private int Chapters;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "title_id")
    private TitleModel title;

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

    public int getChapters() {
        return Chapters;
    }

    public void setChapters(int chapters) {
        Chapters = chapters;
    }

    public TitleModel getTitle() {
        return title;
    }

    public void setTitle(TitleModel title) {
        this.title = title;
    }

    public RanobeModel(long ID, String name, int chapters, TitleModel title) {
        this.ID = ID;
        this.name = name;
        Chapters = chapters;
        this.title = title;
    }
}
