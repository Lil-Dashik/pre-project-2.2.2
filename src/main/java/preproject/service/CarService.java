package preproject.service;

import preproject.model.Car;

import java.util.List;

public interface CarService {
    void addCar(Car car);

    List<Car> getCars(Integer count, String sortBy);

    List<Car> listCars();

    List<Car> listCarsByCount(int count);
}
