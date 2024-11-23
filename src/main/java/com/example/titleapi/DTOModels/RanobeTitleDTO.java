package com.example.titleapi.DTOModels;

public class RanobeTitleDTO {
    private RanobeModelDTO ranobe;
    private TitleModelDTO title;

    public RanobeTitleDTO(RanobeModelDTO ranobe, TitleModelDTO title) {
        this.ranobe = ranobe;
        this.title = title;
    }

    public RanobeModelDTO getRanobe() {
        return ranobe;
    }

    public void setRanobe(RanobeModelDTO ranobe) {
        this.ranobe = ranobe;
    }

    public TitleModelDTO getTitle() {
        return title;
    }

    public void setTitle(TitleModelDTO title) {
        this.title = title;
    }
}
