package kodlama.io.rentACar.webApi.controllers;


import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetBrandsByIdResponse;
import kodlama.io.rentACar.business.responses.GetModelsByIdResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/models")
public class ModelsController {
    private ModelService modelService;
    public ModelsController(ModelService modelService){
        this.modelService = modelService;
    }





    @GetMapping("/getAllModels")
    public List<GetAllModelsResponse> getAllModels() {

        return modelService.getAll();
    }



    @PatchMapping("/update")
    public void patchById(@RequestBody UpdateModelRequest updateModelRequest){this.modelService.update(updateModelRequest);}


    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody CreateModelRequest createModelRequest){
        this.modelService.add(createModelRequest);
    }


    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable  int id){this.modelService.delete(id);}

    @GetMapping("/get/{id}")
    public GetModelsByIdResponse getById(@PathVariable int id) {

        return modelService.getById(id);
    }


}
