package com.example.titleapi.DTOModels;

public class StatisticTitleDTO {
    private StatisticDTO statisticDTO;
    private TitleModelDTO titleDTO;

    public StatisticTitleDTO(StatisticDTO statisticDTO, TitleModelDTO titleDTO) {
        this.statisticDTO = statisticDTO;
        this.titleDTO = titleDTO;
    }

    public StatisticDTO getStatisticDTO() {
        return statisticDTO;
    }

    public void setStatisticDTO(StatisticDTO statisticDTO) {
        this.statisticDTO = statisticDTO;
    }

    public TitleModelDTO getTitleDTO() {
        return titleDTO;
    }

    public void setTitleDTO(TitleModelDTO titleDTO) {
        this.titleDTO = titleDTO;
    }
}
