package com.example.titleapi.controllers;

import com.example.titleapi.DTOModels.*;
import com.example.titleapi.models.AnimeModel;
import com.example.titleapi.models.AuthorModel;
import com.example.titleapi.models.FioModel;
import com.example.titleapi.models.TitleModel;
import com.example.titleapi.repository.AuthorRepository;
import com.example.titleapi.repository.FioRepository;
import com.example.titleapi.repository.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api-author")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private TitleRepository titleRepository;
    @Autowired
    private FioRepository fioRepository;
    @GetMapping
    public List<AuthorTitleFioDTO> getAuthor(){
        List<AuthorModel> authors = authorRepository.findAll();
        List<AuthorTitleFioDTO> authorSend = new ArrayList<>();
        for(int i=0; i<authors.size(); i++){
            AuthorModel a = authors.get(i);
            TitleModel t = titleRepository.findById(a.getTitle().getID()).orElse(null);
            FioModel f = fioRepository.findById(a.getFio().getID()).orElse(null);
            AuthorModelDTO author = new AuthorModelDTO(a.getID(), a.getAge(), a.getNickname(), a.getTitle().getID(), a.getFio().getID());
            TitleModelDTO title = new TitleModelDTO(t.getID(), t.getName());
            FioModelDTO fio = new FioModelDTO(f.getID(), f.getName(), f.getSurname(), f.getLastname());
            authorSend.add(new AuthorTitleFioDTO(author, title, fio));
        }
        return authorSend;
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @PostMapping
    public String createAuthor(@RequestBody AuthorModelDTO authorDTO){
        TitleModel title = titleRepository.findById(authorDTO.getTitleID()).orElse(null);
        FioModel fio = fioRepository.findById(authorDTO.getFioId()).orElse(null);
        System.out.println(authorDTO.getFioId());
        AuthorModel author = new AuthorModel(0, authorDTO.getAge(), authorDTO.getNickname(), title, fio);
        authorRepository.save(author);
        return "success!";
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @PutMapping("/{ID}")
    public String updateAuthor(@PathVariable long ID, @RequestBody AuthorModelDTO authorDTO){
        AuthorModel author = authorRepository.findById(ID).orElse(null);
        author.setAge(authorDTO.getAge());
        author.setNickname(authorDTO.getNickname());
        authorRepository.save(author);
        return "success!";
    }
    @PreAuthorize("hasAuthority('WORKER')")
    @DeleteMapping("/{ID}")
    public String updateAuthor(@PathVariable long ID){
        AuthorModel author = authorRepository.findById(ID).orElse(null);
        authorRepository.delete(author);
        return "success!";
    }
}
