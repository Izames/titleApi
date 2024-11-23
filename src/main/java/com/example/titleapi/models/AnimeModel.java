package com.example.titleapi.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "anime")
@NoArgsConstructor
public class AnimeModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String name;
    private int Seasons;
    private int episodes;
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

    public int getSeasons() {
        return Seasons;
    }

    public void setSeasons(int seasons) {
        Seasons = seasons;
    }

    public int getEpisodes() {
        return episodes;
    }

    public void setEpisodes(int episodes) {
        this.episodes = episodes;
    }

    public TitleModel getTitle() {
        return title;
    }

    public void setTitle(TitleModel title) {
        this.title = title;
    }

    public AnimeModel(long ID, String name, int seasons, int episodes, TitleModel title) {
        this.ID = ID;
        this.name = name;
        Seasons = seasons;
        this.episodes = episodes;
        this.title = title;
    }
}
