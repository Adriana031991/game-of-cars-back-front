package co.com.adrianafranklin.RetoCrudBackend.Service;

import co.com.adrianafranklin.RetoCrudBackend.DTO.CarDto;
import co.com.adrianafranklin.RetoCrudBackend.DTO.PlayerDto;
import co.com.adrianafranklin.RetoCrudBackend.DTO.ResponseDto;
import co.com.adrianafranklin.RetoCrudBackend.Entitys.Car;
import co.com.adrianafranklin.RetoCrudBackend.Entitys.Player;
import co.com.adrianafranklin.RetoCrudBackend.Repository.RepositoryCar;
import co.com.adrianafranklin.RetoCrudBackend.Repository.RepositoryPlayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceCar {
    @Autowired
    private RepositoryCar repositoryCar;
    @Autowired
    private RepositoryPlayer repositoryPlayer;


    public ResponseDto Car() {
        return new ResponseDto(repositoryCar.findAll());
    }

    public ResponseDto saveCar(CarDto carDto) {

        Car car = new Car();
        car.setId(carDto.getId());
        car.setNameCar(carDto.getName());
        car.setDriver(carDto.getDriver());
        repositoryCar.save(car);
        return new ResponseDto(car, "Se ha creado el jugador correctamente");

    }

    public ResponseDto assignDriver(Player player){

       CarDto carDto = new CarDto();
       carDto.setName("carro #:"+player.getId());
       carDto.setDriver(player);

       return this.saveCar(carDto);

    }

    public ResponseDto assignLane(Car car){
        CarDto carDto = new CarDto();
        return this.saveCar(carDto);
    }


    public ResponseDto get(int id) {
        return new ResponseDto(repositoryCar.findById(id).orElseThrow(() -> {
            throw new RuntimeException("El carro a consultar no existe");
        }));
    }
}