package com.example.springboottutorial;

import org.springframework.data.repository.CrudRepository;

public interface BoardRepository extends CrudRepository<Board, Integer> {

    Board findBoardById(Integer id);
}