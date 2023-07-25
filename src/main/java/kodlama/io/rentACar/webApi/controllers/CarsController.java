package kodlama.io.rentACar.webApi.controllers;


import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.GetBrandsByIdResponse;
import kodlama.io.rentACar.business.responses.GetCarsByIdResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
    private CarService carService;

    public CarsController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id}")
    public GetCarsByIdResponse getById(@PathVariable int id) {

        return carService.getById(id);
    }
    @GetMapping("/getAllCars")
    public List<GetAllCarsResponse> getAllCars() {

        return carService.getAll();
    }




    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody  CreateCarRequest createCarRequest){
        this.carService.add(createCarRequest);
    }

    @PatchMapping("/update")
    public void patchById(@RequestBody UpdateCarRequest updateCarRequest){this.carService.update(updateCarRequest);}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable  int id){this.carService.delete(id);}



}
