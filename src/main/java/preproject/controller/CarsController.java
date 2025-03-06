package preproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import preproject.model.Car;
import preproject.service.CarService;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarsController {

    @Autowired
    private CarService carService;

    @GetMapping
    public String listCars(
                           @RequestParam(required = false) Integer count,
                           @RequestParam(required = false) String sortBy,
                           Model model) {
        List<Car> cars = carService.getCars(count, sortBy);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
