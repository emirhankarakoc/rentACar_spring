package kodlama.io.rentACar.webApi.controllers;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetBrandsByIdResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/brands")
public class BrandsController {
    private BrandService brandService;

    public BrandsController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping("/{id}")
    public GetBrandsByIdResponse getById(@PathVariable int id) {

        return brandService.getById(id);
    }
    @GetMapping("/getAllBrands")
    public List<GetAllBrandsResponse> getAllBrands() {

        return brandService.getAll();
    }




    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void add(@RequestBody CreateBrandRequest createBrandRequest){
        this.brandService.add(createBrandRequest);
    }

    @PatchMapping("/update")
    public void patchById(@RequestBody UpdateBrandRequest updateBrandRequest){this.brandService.update(updateBrandRequest);}

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable  int id){this.brandService.delete(id);}



}
