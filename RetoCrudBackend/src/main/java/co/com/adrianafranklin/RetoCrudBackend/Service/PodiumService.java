package co.com.adrianafranklin.RetoCrudBackend.Service;

import co.com.adrianafranklin.RetoCrudBackend.DTO.ResponseDto;
import co.com.adrianafranklin.RetoCrudBackend.Entitys.Podium;
import co.com.adrianafranklin.RetoCrudBackend.Repository.PodiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PodiumService {

    @Autowired
    private PodiumRepository podiumRepository;

    public ResponseDto savePodium(Podium podium){

        podiumRepository.save(podium);

        return new ResponseDto(podium, "Se ha finalizado la carrera exitosamente");

    }
}
