package kodlama.io.rentACar.business.concretes;

import kodlama.io.rentACar.business.abstracts.CarService;
import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.GetBrandsByIdResponse;
import kodlama.io.rentACar.business.responses.GetCarsByIdResponse;
import kodlama.io.rentACar.business.responses.GetModelsByIdResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperServiceImpl;
import kodlama.io.rentACar.dataAccess.abstracts.CarRepository;
import kodlama.io.rentACar.entitites.concretes.Brand;
import kodlama.io.rentACar.entitites.concretes.Car;
import kodlama.io.rentACar.entitites.concretes.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarManager implements CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ModelMapperServiceImpl modelMapperServiceImpl;



    @Override
    public List<GetAllCarsResponse> getAll() {
        List<Car> cars = this.carRepository.findAll();

        List<GetAllCarsResponse>   carsResponse = cars.stream()
                .map(car -> this.modelMapperServiceImpl.forResponse()
                        .map(car,GetAllCarsResponse.class)).collect(Collectors.toList());

        return carsResponse;
    }

    @Override
    public void add(CreateCarRequest createCarRequest) {
        Car araba = this.modelMapperServiceImpl.forRequest().map(createCarRequest, Car.class);
        this.carRepository.save(araba);




    }

    @Override
    public void update(UpdateCarRequest updateModelRequest) {
        Car araba = this.modelMapperServiceImpl.forRequest().map(updateModelRequest, Car.class);
        this.carRepository.save(araba);
    }

    @Override
    public void delete(int id) {

        this.carRepository.deleteById(id);
    }

    @Override
    public GetCarsByIdResponse getById(int id) {

        Car doneceknesne = this.carRepository.findById(id).orElseThrow();


        GetCarsByIdResponse response = this.modelMapperServiceImpl.forResponse().map(doneceknesne, GetCarsByIdResponse.class);
        response.setBrandName(doneceknesne.getModel().getBrand().getName());


        return response;





    }


}
