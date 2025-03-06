package preproject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import preproject.config.CarConfig;
import preproject.dao.CarRepository;
import preproject.model.Car;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class CarServiceImp implements CarService {
    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarConfig carConfig;

    @Override
    public void addCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> getCars(Integer count, String sortBy) {
        int maxCar = carConfig.getMaxCars();
        if (count == null || count >= maxCar) {
            count = maxCar;
        }

        Sort sort = Sort.unsorted();
        if (sortBy != null) {
            if (sortBy.equals("model") || sortBy.equals("make")) {
                sort = Sort.by(Sort.Order.asc(sortBy));
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
                        "Sorting by field '" + sortBy + "' is not allowed.");
            }
        }

        Pageable pageable = PageRequest.of(0, count, sort);
        return carRepository.findAll(pageable).getContent();
    }

    @Override
    public List<Car> listCars() {
        return carRepository.findAll();
    }

    @Override
    public List<Car> listCarsByCount(int count) {
        int maxCar = carConfig.getMaxCars();
        if (count >= maxCar) {
            return carRepository.findAll();
        }
        Pageable pageable = PageRequest.of(0, count);
        return carRepository.listCarsByCount(count, pageable);
    }
}
