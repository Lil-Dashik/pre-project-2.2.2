package preproject.service;

import org.springframework.data.domain.Pageable;
import preproject.model.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);
    List<Car> getCars(Integer count, String sortBy);
    List<Car> listCars();
    List<Car> listCarsByCount(int count);
}
