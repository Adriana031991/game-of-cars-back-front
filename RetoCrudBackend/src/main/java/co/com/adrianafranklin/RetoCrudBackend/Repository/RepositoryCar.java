package co.com.adrianafranklin.RetoCrudBackend.Repository;

import co.com.adrianafranklin.RetoCrudBackend.Entitys.Car;
import org.springframework.data.repository.CrudRepository;

public interface RepositoryCar extends CrudRepository<Car, Integer> {
}
