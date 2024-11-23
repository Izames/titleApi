package com.example.titleapi.DTOModels;

public class AnimeTitleDto {
    private AnimeModelDTO animes;
    private TitleModelDTO titles;

    public AnimeModelDTO getAnimes() {
        return animes;
    }

    public void setAnimes(AnimeModelDTO animes) {
        this.animes = animes;
    }

    public TitleModelDTO getTitles() {
        return titles;
    }

    public void setTitles(TitleModelDTO titles) {
        this.titles = titles;
    }

    public AnimeTitleDto(AnimeModelDTO animes, TitleModelDTO titles) {
        this.animes = animes;
        this.titles = titles;
    }
}
