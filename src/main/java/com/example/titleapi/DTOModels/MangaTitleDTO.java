package com.example.titleapi.DTOModels;

public class MangaTitleDTO {
    private MangaModelDTO manga;
    private TitleModelDTO title;

    public MangaTitleDTO(MangaModelDTO manga, TitleModelDTO title) {
        this.manga = manga;
        this.title = title;
    }

    public MangaModelDTO getManga() {
        return manga;
    }

    public void setManga(MangaModelDTO manga) {
        this.manga = manga;
    }

    public TitleModelDTO getTitle() {
        return title;
    }

    public void setTitle(TitleModelDTO title) {
        this.title = title;
    }
}
