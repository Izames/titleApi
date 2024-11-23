package com.example.titleapi.models;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "statistic")
@NoArgsConstructor
public class StatisticModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long ID;
    private float rating;
    private String ReleaseDate;
    @OneToOne(optional = true, cascade = CascadeType.ALL)
    @JoinColumn(name="title_id")
    private TitleModel title;

    public StatisticModel(long ID, float rating, String releaseDate, TitleModel title) {
        this.ID = ID;
        this.rating = rating;
        ReleaseDate = releaseDate;
        this.title = title;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public String getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    public TitleModel getTitle() {
        return title;
    }

    public void setTitle(TitleModel title) {
        this.title = title;
    }
}
