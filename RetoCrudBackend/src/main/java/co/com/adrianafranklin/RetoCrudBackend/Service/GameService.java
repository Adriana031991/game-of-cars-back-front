
package co.com.adrianafranklin.RetoCrudBackend.Service;

import co.com.adrianafranklin.RetoCrudBackend.DTO.*;
import co.com.adrianafranklin.RetoCrudBackend.Entitys.*;
import co.com.adrianafranklin.RetoCrudBackend.Repository.GameRepository;
import co.com.adrianafranklin.RetoCrudBackend.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private ServiceCircuit circuitService;

    @Autowired
    private ServiceCar serviceCar;

    @Autowired
    private PodiumService podiumService;

    @Autowired
    private LaneCarService laneCarService;

    public ResponseDto configureGame(CircuitCarDto circuitCarDto) {

        Game game = new Game();


        Circuit circuit = (Circuit) circuitService.get(circuitCarDto.getCircuit().getId()).getData();

        if(circuitCarDto.getCars().size()<3){
            throw new ValidationException("Deben haber mínimo 3 conductores para jugar");
        }

        if(circuitCarDto.getCars().size()>circuit.getLanes().size()){
            throw new ValidationException("Deben haber mínimo 3 conductores o "+circuit.getLanes().size());
        }

        game.setCircuit(circuit);

        List<LaneCar> lanesCars = new ArrayList<>();

        Set<Lane> newLanes = new HashSet<>();

        Iterator<Lane> laneIterator = circuit.getLanes().iterator();

        for (int i = 0; i < circuit.getLanes().size(); i++) {

            if(i>=circuitCarDto.getCars().size()) {
                break;
            }
                LaneCar laneCar = new LaneCar();

                Lane lane = laneIterator.next();
                laneCar.setLane(lane);


                CarDto carDto = circuitCarDto.getCars().get(i);

                Car car = (Car) serviceCar.get(carDto.getId()).getData();

                lane.setCar(car);
                laneCar.setCar(car);

                lanesCars.add(laneCar);
                newLanes.add(lane);


        }
        circuit.setLanes(newLanes);
        laneCarService.assignLanesToCars(lanesCars);

        game.setCircuit(circuit);

        this.saveGame(game);

        return this.startGame(game);
    }

    public ResponseDto saveGame(Game game) {

        gameRepository.save(game);

        return new ResponseDto(game);
    }

    private ResponseDto startGame(Game game) {

        Set<Lane> lanes = game.getCircuit().getLanes();

        Podium podium = new Podium();

        Circuit circuit = game.getCircuit();

        while (podium.getFirst() == null || podium.getSecond() == null
                || podium.getThird() == null) {

            for (Lane lane : lanes) {

                Car car = lane.getCar();


                if (!car.isWinner()) {

                    car.advance(); //el algoritmo para que avance está en la clase carro

                    if (firstPlace(podium, circuit, car)) break;
                    if (secondPlace(podium, circuit, car)) break;
                    if (thirdPlace(podium, circuit, car)) break;
                }

            }
        }

        podium.setGame(game);
        return podiumService.savePodium(podium);

    }

    private boolean thirdPlace(Podium podium, Circuit circuit, Car car) {
        if (car.getRouteMts() >= circuit.getKilometers() * 1000
                && podium.getThird() == null) {

            podium.setThird(car.getDriver());
            car.setWinner(true);
            return true;
        }
        return false;
    }

    private boolean secondPlace(Podium podium, Circuit circuit, Car car) {
        if (car.getRouteMts() >= circuit.getKilometers() * 1000
                && podium.getSecond() == null) {

            podium.setSecond(car.getDriver());
            car.setWinner(true);
            return true;
        }
        return false;
    }

    private boolean firstPlace(Podium podium, Circuit circuit, Car car) {
        if (car.getRouteMts() >= circuit.getKilometers() * 1000
                && podium.getFirst() == null) {

            podium.setFirst(car.getDriver());
            car.setWinner(true);
            return true;

        }
        return false;
    }

//    public ResponseDto createGame(GameDto gameDto) {
//
//        if(gameDto.getName()== null  )
//            throw new ValidationException("El nombre del juego no puede ser vacío");
//
//        Game game = new Game();
//        game.setName(gameDto.getName());
//        game.setId(gameDto.getId());
//        game = gameRepository.save(game);
//        return new ResponseDto(game);
//
//
//    }

    public ResponseDto getAllGame() {

        return new ResponseDto(gameRepository.findAll());
    }
}
