package com.mdoc.snakeandladder.controller;

import com.mdoc.snakeandladder.datatransferobject.GameDTO;
import com.mdoc.snakeandladder.datatransferobject.GameResultDTO;
import com.mdoc.snakeandladder.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;


@RestController
@RequestMapping("snakeNLadder/play")
public class GameController {

    private final GameService gameService;

    @Autowired
    public GameController(GameService gameService)  {
        this.gameService = gameService;
    }


    @PostMapping
    public ResponseEntity<GameResultDTO> playGame(@Valid @RequestBody GameDTO gameDTO) {
        GameResultDTO gameResultDTO = new GameResultDTO(gameService.play(gameDTO.getDiceValue()));
        return ResponseEntity.status(HttpStatus.OK).body(gameResultDTO);
    }

    @GetMapping()
    public ResponseEntity<GameResultDTO> startGame() {
        GameResultDTO gameResultDTO = new GameResultDTO(gameService.startGame());
        return ResponseEntity.status(HttpStatus.OK).body(gameResultDTO);
    }
}
