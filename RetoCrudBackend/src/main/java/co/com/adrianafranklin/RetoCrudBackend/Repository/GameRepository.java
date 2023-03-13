package co.com.adrianafranklin.RetoCrudBackend.Repository;

import co.com.adrianafranklin.RetoCrudBackend.Entitys.Game;
import co.com.adrianafranklin.RetoCrudBackend.Entitys.LaneCar;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Integer> {
}
