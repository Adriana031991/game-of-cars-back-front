package co.com.adrianafranklin.RetoCrudBackend.Service;

import co.com.adrianafranklin.RetoCrudBackend.DTO.ResponseDto;
import co.com.adrianafranklin.RetoCrudBackend.Entitys.LaneCar;
import co.com.adrianafranklin.RetoCrudBackend.Repository.LaneCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LaneCarService {

    @Autowired
    private LaneCarRepository laneCarRepository;

    public ResponseDto assignLanesToCars(List<LaneCar> lanesCars){

        laneCarRepository.saveAll(lanesCars);

        return new ResponseDto(lanesCars);

    }
}
