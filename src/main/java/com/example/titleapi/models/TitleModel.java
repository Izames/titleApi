package com.example.titleapi.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "title")
@NoArgsConstructor
public class TitleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private String name;
    @OneToMany (mappedBy = "title", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<MangaModel> mangas;
    @OneToMany (mappedBy = "title", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<AuthorModel> author;
    @OneToMany (mappedBy = "title", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<RanobeModel> ranobes;
    @OneToMany (mappedBy = "title", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Collection<AnimeModel> animes;
    @OneToOne(optional = true, mappedBy = "title", cascade = CascadeType.ALL)
    private StatisticModel statistic;

    public TitleModel(long ID, String name, Collection<MangaModel> mangas, Collection<AuthorModel> author, Collection<RanobeModel> ranobes, Collection<AnimeModel> animes, StatisticModel statistic) {
        this.ID = ID;
        this.name = name;
        this.mangas = mangas;
        this.author = author;
        this.ranobes = ranobes;
        this.animes = animes;
        this.statistic = statistic;
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

    public Collection<MangaModel> getMangas() {
        return mangas;
    }

    public void setMangas(Collection<MangaModel> mangas) {
        this.mangas = mangas;
    }

    public Collection<AuthorModel> getAuthor() {
        return author;
    }

    public void setAuthor(Collection<AuthorModel> author) {
        this.author = author;
    }

    public Collection<RanobeModel> getRanobes() {
        return ranobes;
    }

    public void setRanobes(Collection<RanobeModel> ranobes) {
        this.ranobes = ranobes;
    }

    public Collection<AnimeModel> getAnimes() {
        return animes;
    }

    public void setAnimes(Collection<AnimeModel> animes) {
        this.animes = animes;
    }

    public StatisticModel getStatistic() {
        return statistic;
    }

    public void setStatistic(StatisticModel statistic) {
        this.statistic = statistic;
    }
}
