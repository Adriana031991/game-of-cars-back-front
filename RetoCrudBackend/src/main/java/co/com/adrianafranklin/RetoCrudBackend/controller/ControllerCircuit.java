package co.com.adrianafranklin.RetoCrudBackend.controller;

import co.com.adrianafranklin.RetoCrudBackend.DTO.CarDto;
import co.com.adrianafranklin.RetoCrudBackend.DTO.CircuitDto;
import co.com.adrianafranklin.RetoCrudBackend.DTO.ResponseDto;
import co.com.adrianafranklin.RetoCrudBackend.Service.ServiceCar;
import co.com.adrianafranklin.RetoCrudBackend.Service.ServiceCircuit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin( "http://localhost:4200" )
@RequestMapping("api/circuit")
public class ControllerCircuit {

    @Autowired
    private ServiceCircuit serviceCircuit;

    @GetMapping
    public ResponseDto circuits() {
        return serviceCircuit.circuits();
    }

    @PostMapping
    public ResponseDto saveCircuit(@RequestBody CircuitDto circuitDto) {
        return serviceCircuit.saveCircuit(circuitDto);
    }

    @PutMapping
    public ResponseDto updateCircuit(@RequestBody CircuitDto circuitDto) {
        return serviceCircuit.updateCircuit(circuitDto);
    }

    @DeleteMapping(value = "{id}")
    public ResponseDto delete(@PathVariable("id") int id) {
        return serviceCircuit.deleteById(id);
    }


    @GetMapping(value = "{id}")
    public ResponseDto get(@PathVariable("id") int id) {
        return serviceCircuit.get(id);
    }
}
