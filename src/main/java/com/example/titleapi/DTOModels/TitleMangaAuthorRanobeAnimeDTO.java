package com.example.titleapi.DTOModels;

import java.util.List;

public class TitleMangaAuthorRanobeAnimeDTO {
    private TitleModelDTO title;
    private List<MangaModelDTO> manga;
    private List<AuthorModelDTO> author;
    private List<RanobeModelDTO> ranobe;
    private List<AnimeModelDTO> anime;


    public List<AnimeModelDTO> getAnime() {
        return anime;
    }

    public void setAnime(List<AnimeModelDTO> anime) {
        this.anime = anime;
    }

    public TitleMangaAuthorRanobeAnimeDTO(TitleModelDTO title, List<MangaModelDTO> manga, List<AuthorModelDTO> author, List<RanobeModelDTO> ranobe, List<AnimeModelDTO> anime) {
        this.title = title;
        this.manga = manga;
        this.author = author;
        this.ranobe = ranobe;
        this.anime = anime;
    }

    public TitleModelDTO getTitle() {
        return title;
    }

    public void setTitle(TitleModelDTO title) {
        this.title = title;
    }

    public List<MangaModelDTO> getManga() {
        return manga;
    }

    public void setManga(List<MangaModelDTO> manga) {
        this.manga = manga;
    }

    public List<AuthorModelDTO> getAuthor() {
        return author;
    }

    public void setAuthor(List<AuthorModelDTO> author) {
        this.author = author;
    }

    public List<RanobeModelDTO> getRanobe() {
        return ranobe;
    }

    public void setRanobe(List<RanobeModelDTO> ranobe) {
        this.ranobe = ranobe;
    }

}
