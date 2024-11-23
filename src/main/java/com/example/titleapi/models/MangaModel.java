package com.example.titleapi.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "manga")
@NoArgsConstructor
public class MangaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String name;
    private int chapters;
    @ManyToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name = "title_id")
    private TitleModel title;

    public MangaModel(long ID, String name, int chapters, TitleModel title) {
        this.ID = ID;
        this.name = name;
        this.chapters = chapters;
        this.title = title;
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

    public int getChapters() {
        return chapters;
    }

    public void setChapters(int chapters) {
        this.chapters = chapters;
    }

    public TitleModel getTitle() {
        return title;
    }

    public void setTitle(TitleModel title) {
        this.title = title;
    }
}
