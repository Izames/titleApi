package com.example.titleapi.DTOModels;

import com.example.titleapi.models.TitleModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

public class StatisticDTO {
    private long ID;
    private float rating;
    private String ReleaseDate;
    private long title_id;

    public StatisticDTO(long ID, float rating, String releaseDate, long title_id) {
        this.ID = ID;
        this.rating = rating;
        ReleaseDate = releaseDate;
        this.title_id = title_id;
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

    public long getTitle_id() {
        return title_id;
    }

    public void setTitle_id(long title_id) {
        this.title_id = title_id;
    }
}
