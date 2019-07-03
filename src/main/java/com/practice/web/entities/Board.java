package com.practice.web.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Board
 */
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Getter
@Setter
@ToString
@Entity
@Table(name="board")
public class Board implements Serializable{

    private static final long serialVersionUID=1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bno;

    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

    @Override
    public String toString(){
        return "Board: [title:"+title+"content"+content+"]";
    }
    @Builder
    public Board(String title,String content){
        this.title = title;
        this.content=content;
    }

    
}