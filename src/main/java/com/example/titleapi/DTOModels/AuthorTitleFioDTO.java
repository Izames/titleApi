package com.example.titleapi.DTOModels;

public class AuthorTitleFioDTO {
    private AuthorModelDTO author;
    private TitleModelDTO title;
    private FioModelDTO fio;

    public AuthorModelDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorModelDTO author) {
        this.author = author;
    }

    public TitleModelDTO getTitle() {
        return title;
    }

    public void setTitle(TitleModelDTO title) {
        this.title = title;
    }

    public FioModelDTO getFio() {
        return fio;
    }

    public void setFio(FioModelDTO fio) {
        this.fio = fio;
    }

    public AuthorTitleFioDTO(AuthorModelDTO author, TitleModelDTO title, FioModelDTO fio) {
        this.author = author;
        this.title = title;
        this.fio = fio;
    }
}
