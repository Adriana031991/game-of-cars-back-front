package co.com.adrianafranklin.RetoCrudBackend.Repository;

import co.com.adrianafranklin.RetoCrudBackend.Entitys.Car;
import co.com.adrianafranklin.RetoCrudBackend.Entitys.LaneCar;
import org.springframework.data.repository.CrudRepository;

public interface LaneCarRepository extends CrudRepository<LaneCar, Integer> {
}
