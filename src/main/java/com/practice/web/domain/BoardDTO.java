package com.practice.web.domain;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * Board
 */
@Data@Lazy@Component
public class BoardDTO {
    private Long bno;
    private String title;
    private String content;
    

    

    
}