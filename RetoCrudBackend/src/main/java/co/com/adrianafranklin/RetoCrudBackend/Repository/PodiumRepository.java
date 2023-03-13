package co.com.adrianafranklin.RetoCrudBackend.Repository;

import co.com.adrianafranklin.RetoCrudBackend.Entitys.Car;
import co.com.adrianafranklin.RetoCrudBackend.Entitys.Podium;
import org.springframework.data.repository.CrudRepository;

public interface PodiumRepository  extends CrudRepository<Podium, Integer> {
}
