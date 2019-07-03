package com.practice.web.repositories;

import com.practice.web.entities.Board;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * BoardRepository
 */
@Repository
public interface BoardRepository extends CrudRepository<Board,Long>{

    
}