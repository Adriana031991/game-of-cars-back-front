package co.com.adrianafranklin.RetoCrudBackend.Repository;

import co.com.adrianafranklin.RetoCrudBackend.Entitys.Player;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryPlayer extends CrudRepository<Player, Integer> {
}
