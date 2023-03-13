package co.com.adrianafranklin.RetoCrudBackend.controller;

import co.com.adrianafranklin.RetoCrudBackend.DTO.PlayerDto;
import co.com.adrianafranklin.RetoCrudBackend.DTO.ResponseDto;
import co.com.adrianafranklin.RetoCrudBackend.Service.ServicePlayer;
import co.com.adrianafranklin.RetoCrudBackend.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin( "http://localhost:4200" )
@RequestMapping("api/player")
public class ControllerPlayer {

    @Autowired
    private ServicePlayer servicePlayer;

    @GetMapping
    public ResponseDto player() {
        return servicePlayer.Player();
    }

    @PostMapping
    public ResponseDto savePlayer(@RequestBody PlayerDto playerDto) {
        return servicePlayer.savePlayer(playerDto);
    }


    @PutMapping
    public ResponseDto updatePlayer(@RequestBody PlayerDto playerDto) {
        return servicePlayer.updatePlayer(playerDto);
    }


    @DeleteMapping(value = "{id}")
    public ResponseDto delete(@PathVariable("id") int id) {
        return servicePlayer.deleteById(id);
    }

    @GetMapping(value = "{id}")
    public ResponseDto get(@PathVariable("id") int id) {
        return servicePlayer.get(id);
    }
}
