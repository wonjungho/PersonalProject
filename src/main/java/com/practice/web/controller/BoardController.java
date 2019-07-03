package com.practice.web.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import com.practice.web.domain.BoardDTO;
import com.practice.web.entities.Board;
import com.practice.web.repositories.BoardRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * BoardController
 */
@RestController
@RequestMapping("/board")
public class BoardController {
    @Autowired
    BoardDTO dto;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    BoardRepository repo;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @GetMapping("")
    public List<BoardDTO> findAll() {
        Iterable<Board> entities = repo.findAll();
        List<BoardDTO> list = new ArrayList<>();
        for (Board b : entities) {
            BoardDTO bo = modelMapper.map(b, BoardDTO.class);
            list.add(bo);
        }
        System.out.println(list);
        return list;
    }

    @GetMapping("/{id}")
    public BoardDTO findById(@PathVariable String id) {
        return modelMapper.map(repo.findById(Long.parseLong(id)).orElseThrow(EntityNotFoundException::new),
                BoardDTO.class);
    }

    @PostMapping("")
    public HashMap<String, String> save(@RequestBody BoardDTO dto) {
        HashMap<String, String> map = new HashMap<>();
        Board entity = new Board();
        entity.setTitle(dto.getTitle());
        entity.setContent(dto.getContent());
        repo.save(entity);
        map.put("result", "success");
        return map;
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable String id){
        System.out.println(id);
        repo.deleteById(Long.parseLong(id));












        
    }
    @PutMapping("/{id}")
    public HashMap<String,String> update(@PathVariable String id,@RequestBody BoardDTO dto){
        System.out.println(id);
        HashMap<String, String> map = new HashMap<>();
        Board bo = repo.findById(Long.parseLong(id)).get();
        bo.setTitle(dto.getTitle());
        bo.setContent(dto.getContent());
        repo.save(bo);
        map.put("result", "success");
        return map;
    }


    
}