package com.example.titleapi.DTOModels;

public class AnimeModelDTO {

    private long ID;
    private String name;
    private int Seasons;
    private int episodes;
    private long titleID;

    public AnimeModelDTO(long ID, String name, int seasons, int episodes, long titleID) {
        this.ID = ID;
        this.name = name;
        Seasons = seasons;
        this.episodes = episodes;
        this.titleID = titleID;
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

    public long getTitleID() {
        return titleID;
    }

    public void setTitleID(long titleID) {
        this.titleID = titleID;
    }
}
