package kodlama.io.rentACar.dataAccess.abstracts;

import kodlama.io.rentACar.entitites.concretes.Brand;
import kodlama.io.rentACar.entitites.concretes.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Integer> {
}
