package co.com.adrianafranklin.RetoCrudBackend.controller;

import co.com.adrianafranklin.RetoCrudBackend.DTO.CarDto;
import co.com.adrianafranklin.RetoCrudBackend.DTO.PlayerDto;
import co.com.adrianafranklin.RetoCrudBackend.DTO.ResponseDto;
import co.com.adrianafranklin.RetoCrudBackend.Service.ServiceCar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/car")
public class ControllerCar {

    @Autowired
    private ServiceCar serviceCar;

    @GetMapping
    public ResponseDto car() {
        return serviceCar.Car();
    }

    @PostMapping
    public ResponseDto saveCar(@RequestBody CarDto carDto) {
        return serviceCar.saveCar(carDto);
    }

    @PutMapping
    public ResponseDto updateCar(@RequestBody CarDto carDto){
        return serviceCar.saveCar(carDto);
    }

    @GetMapping(value = "{id}")
    public ResponseDto get(@PathVariable("id") int id){
        return serviceCar.get(id);
    }
}
