package co.com.adrianafranklin.RetoCrudBackend.Service;

import co.com.adrianafranklin.RetoCrudBackend.DTO.PlayerDto;
import co.com.adrianafranklin.RetoCrudBackend.DTO.ResponseDto;
import co.com.adrianafranklin.RetoCrudBackend.Entitys.Player;
import co.com.adrianafranklin.RetoCrudBackend.Repository.RepositoryPlayer;
import co.com.adrianafranklin.RetoCrudBackend.exception.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicePlayer {
    @Autowired
    private RepositoryPlayer repositoryPlayer;
    @Autowired
    private ServiceCar serviceCar;

    public ResponseDto Player() {
        return new ResponseDto(repositoryPlayer.findAll());
    }

    public ResponseDto savePlayer(PlayerDto playerDto) {

        if(playerDto.getNameDto()== null  )
            throw new ValidationException("El nombre del jugador no puede ser vacío");

        //trae los datos del dto y los guarda en list
        Player player = new Player();
        player.setId(playerDto.getIdDto());
        player.setName(playerDto.getNameDto());
        player = repositoryPlayer.save(player);
        return this.assignCar(player);

    }
    public ResponseDto assignCar(Player player){
        return serviceCar.assignDriver(player);
    }

    public ResponseDto updatePlayer(PlayerDto playerDto){
        if (playerDto.getNameDto()==null )
            throw new ValidationException("Debe especificar el numero del jugador a actualizar");

        Player player = new Player();
        player.setId(playerDto.getIdDto());
        player.setName(playerDto.getNameDto());
        repositoryPlayer.save(player);
        return new ResponseDto(player,"El jugador ha sido actualizado");
    }

    public ResponseDto deleteById(int id) {
        repositoryPlayer.deleteById(id);
        return new ResponseDto("jugador eliminado correctamente");

    }

    public ResponseDto get(int id) {
        return new ResponseDto(repositoryPlayer.findById(id).orElseThrow(() -> {
            throw new RuntimeException("El jugador a consultar no existe");
        }));
    }
}