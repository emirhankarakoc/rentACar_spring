package kodlama.io.rentACar.business.abstracts;

import kodlama.io.rentACar.business.requests.CreateCarRequest;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateCarRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllCarsResponse;
import kodlama.io.rentACar.business.responses.GetCarsByIdResponse;
import kodlama.io.rentACar.business.responses.GetModelsByIdResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CarService {

     List<GetAllCarsResponse> getAll();
    void add(CreateCarRequest createCarRequestRequest);

    void update(UpdateCarRequest updateModelRequest);
    void delete(int id);
    GetCarsByIdResponse getById(int id);





}
