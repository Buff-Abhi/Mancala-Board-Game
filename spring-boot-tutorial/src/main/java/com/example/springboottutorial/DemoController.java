package com.example.springboottutorial;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class DemoController {
    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private MongoOperations mongoOperations;

    @ResponseStatus(value = HttpStatus.FORBIDDEN, reason="To show an example of a custom message")
    public class ForbiddenException extends RuntimeException {}

    @RequestMapping(value = "/exception", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity sendViaException() {
        throw new ForbiddenException();
    }

    @GetMapping("beadcount")
    public Board getBeadCount() {
        Query query = Query.query(Criteria.where("gameId").is(1));
        return mongoOperations.findOne(query, Board.class);
    }

    @GetMapping("/testmongo")
    public List<Board> testmongodb() {
        Board board = Board.getInstance();
//        boardRepository.deleteAll();
//        board.setM1(board.getM1()+2);
//        boardRepository.save(board);
        var e = new Error("Could not parse input");
// e.message is 'Could not parse input'
        throw e;
//        return boardRepository.findAll();
    }

    @PostMapping("/testmongoadd")
    public void testmongodb(@RequestParam(required = false) String first) {
        Board board = Board.getInstance();
        boardRepository.deleteAll();
        board.setM1(board.getM1()+2);
        boardRepository.save(board);
        var e = new Error("Could not parse input");
// e.message is 'Could not parse input'
        throw e;
    }

//    @GetMapping("/testclick")
//    @PostMapping("/testclick")
//    public Board getTestCust(@RequestParam(required = false) String first, @RequestParam(required = false) String last) {
//        Board board = new Board();
//        board.setFirstName(board.getFirstName()+"Abhi");
//        board.setLastName(board.getLastName()+"Abhi");
////        Object db = require("mongodb");
////        db.getSiblingDB("MancalaDB").getCollection("Bead Count").find({}, {"PB1": 1, "_id": 0})
//        boardRepository.save(board);
//        return board;
//    }

    @GetMapping("/list1")
    public Iterable<Board> getBeads() {
        return boardRepository.findAll();
    }

}