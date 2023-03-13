package co.com.adrianafranklin.RetoCrudBackend.controller;

import co.com.adrianafranklin.RetoCrudBackend.DTO.CircuitCarDto;
import co.com.adrianafranklin.RetoCrudBackend.DTO.GameDto;
import co.com.adrianafranklin.RetoCrudBackend.DTO.ResponseDto;
import co.com.adrianafranklin.RetoCrudBackend.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin( "http://localhost:4200" )
@RequestMapping("api/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @PostMapping("/start-game")
    public ResponseDto iniciarJuego(@RequestBody CircuitCarDto circuitCarDto){

        return gameService.configureGame(circuitCarDto);
    }

    @GetMapping
    public ResponseDto game() {
        return gameService.getAllGame();
    }

//    @PostMapping("/create")
//    public ResponseDto crearJuego(@RequestBody GameDto gameDto) {
//        return gameService.createGame(gameDto);
//    }
}
