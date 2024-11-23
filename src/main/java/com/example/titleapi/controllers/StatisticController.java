package com.example.titleapi.controllers;

import com.example.titleapi.DTOModels.StatisticDTO;
import com.example.titleapi.DTOModels.StatisticTitleDTO;
import com.example.titleapi.DTOModels.TitleModelDTO;
import com.example.titleapi.models.StatisticModel;
import com.example.titleapi.models.TitleModel;
import com.example.titleapi.repository.StatisticRepository;
import com.example.titleapi.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api-statistic")
public class StatisticController {
    @Autowired
    private StatisticRepository statisticRepository;
    @Autowired
    private TitleRepository titleRepository;
    @PreAuthorize("hasAuthority('WORKER')")
    @PostMapping
    public String createStatistic(@RequestBody StatisticDTO statisticDTO){
        TitleModel titleModel = titleRepository.findById(statisticDTO.getTitle_id()).orElse(null);
        StatisticModel statistic = new StatisticModel(0, statisticDTO.getRating(), statisticDTO.getReleaseDate(), titleModel);
        statisticRepository.save(statistic);
        return "success!";
    }
    @GetMapping
    public List<StatisticTitleDTO> getStatistic(){
        List<StatisticModel> statistics = statisticRepository.findAll();
        List<StatisticTitleDTO> statisticTitleDTOS = new ArrayList<>();
        for (int i = 0; i<statistics.size(); i++){
            StatisticModel stat = statistics.get(i);
            TitleModel title = stat.getTitle();
            StatisticDTO statisticDTO = new StatisticDTO(stat.getID(), stat.getRating(), stat.getReleaseDate(), stat.getTitle().getID());
            TitleModelDTO titleDTO = new TitleModelDTO(title.getID(), title.getName());
            StatisticTitleDTO statisticTitleDTO = new StatisticTitleDTO(statisticDTO, titleDTO);
            statisticTitleDTOS.add(statisticTitleDTO);
        }
        return statisticTitleDTOS;
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @PutMapping("/{ID}")
    public String updateStatistic(@PathVariable long ID, @RequestBody StatisticDTO statisticDTO){
        StatisticModel statisticModel = statisticRepository.findById(ID).orElse(null);
        statisticModel.setRating(statisticDTO.getRating());
        statisticModel.setReleaseDate(statisticDTO.getReleaseDate());
        statisticRepository.save(statisticModel);
        return "success!";
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @DeleteMapping("/{ID}")
    public String deleteStatistic(@PathVariable long ID){
        StatisticModel statisticModel = statisticRepository.findById(ID).orElse(null);
        statisticRepository.delete(statisticModel);
        return "success!";
    }
}
