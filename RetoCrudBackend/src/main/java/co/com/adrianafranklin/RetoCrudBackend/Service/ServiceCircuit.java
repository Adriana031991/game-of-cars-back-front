package co.com.adrianafranklin.RetoCrudBackend.Service;

import co.com.adrianafranklin.RetoCrudBackend.DTO.CarDto;
import co.com.adrianafranklin.RetoCrudBackend.DTO.CircuitDto;
import co.com.adrianafranklin.RetoCrudBackend.DTO.ResponseDto;
import co.com.adrianafranklin.RetoCrudBackend.Entitys.Car;
import co.com.adrianafranklin.RetoCrudBackend.Entitys.Circuit;
import co.com.adrianafranklin.RetoCrudBackend.Entitys.Lane;
import co.com.adrianafranklin.RetoCrudBackend.Entitys.Player;
import co.com.adrianafranklin.RetoCrudBackend.Repository.RepositoryCar;
import co.com.adrianafranklin.RetoCrudBackend.Repository.RepositoryCircuit;
import co.com.adrianafranklin.RetoCrudBackend.Repository.RepositoryPlayer;
import co.com.adrianafranklin.RetoCrudBackend.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class ServiceCircuit {
    @Autowired
    private RepositoryCircuit repositoryCircuit;
    @Autowired
    private RepositoryPlayer repositoryPlayer;

    public ResponseDto circuits() {
        return new ResponseDto(repositoryCircuit.findAll());
    }


    public ResponseDto saveCircuit(CircuitDto circuitDto) {

        if(circuitDto.getName()== null  )
            throw new ValidationException("El nombre del circuito no puede ser vacío");

        //trae los datos del dto y los guarda en list
        Circuit circuit = new Circuit();
        circuit.setId(circuitDto.getId());
        circuit.setName(circuitDto.getName());
        circuit.setKilometers(circuitDto.getKilometers());
        circuit.setLanes(circuitDto.getLanes());

        return new ResponseDto(repositoryCircuit.save(circuit));

    }

    public ResponseDto updateCircuit(CircuitDto circuitDto) {

        if(circuitDto.getName()== null  )
            throw new ValidationException("El nombre del circuito no puede ser vacío");

        //trae los datos del dto y los guarda en list
        Circuit circuit = new Circuit();
        circuit.setId(circuitDto.getId());
        circuit.setName(circuitDto.getName());
        circuit.setKilometers(circuitDto.getKilometers());
        circuit.setLanes(circuitDto.getLanes());

        repositoryCircuit.save(circuit);
        return new ResponseDto(circuit, "el circuito ha sido actualizado");

    }

    public ResponseDto deleteById(int id) {
        repositoryCircuit.deleteById(id);
        return new ResponseDto("circuito eliminado correctamente");

    }


    public ResponseDto get(int id) {
        return new ResponseDto(repositoryCircuit.findById(id).orElseThrow(() -> {
            throw new RuntimeException("El circuito a consultar no existe");
        }));
    }
}