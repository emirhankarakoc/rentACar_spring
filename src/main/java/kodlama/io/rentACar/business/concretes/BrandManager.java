package kodlama.io.rentACar.business.concretes;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.responses.GetBrandsByIdResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperServiceImpl;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entitites.concretes.Brand;
import kodlama.io.rentACar.rules.BrandBusinessRules;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Data@AllArgsConstructor@NoArgsConstructor
public class BrandManager implements BrandService {

    @Autowired
    private BrandBusinessRules brandBusinessRules;
    @Autowired
    private  BrandRepository brandRepository;


    @Autowired
    private ModelMapperServiceImpl modelMapperServiceImpl;


    @Override
    public List<GetAllBrandsResponse> getAll() {
        List<Brand> brands = this.brandRepository.findAll();

        List<GetAllBrandsResponse>   brandsResponse = brands.stream()
                .map(brand -> this.modelMapperServiceImpl.forResponse()
                        .map(brand,GetAllBrandsResponse.class)).collect(Collectors.toList());


        //bir kisinin getAll yapabilmesi icin:
        //markalari listeleyebilmesi icin gereken kodlarin bulundugu scope

        return brandsResponse;
    }


    @Override
    @NotBlank
    @NotNull
    @Size(min = 3,max = 20)
    public void add(CreateBrandRequest createBrandRequest) {

        Brand brand = this.modelMapperServiceImpl.forRequest().map(createBrandRequest, Brand.class);
        this.brandRepository.save(brand);
    }


    public void update(UpdateBrandRequest updateBrandRequest) {


     Brand brand = this.modelMapperServiceImpl.forRequest().map(updateBrandRequest, Brand.class);

     this.brandRepository.save(brand);
    }

    @Override
    public void delete(int id) {
        this.brandRepository.deleteById(id);

    }


    @Override
    public GetBrandsByIdResponse getById(int id) {
       Brand doneceknesne = this.brandRepository.findById(id).orElseThrow();

       GetBrandsByIdResponse response = this.modelMapperServiceImpl.forResponse().map(doneceknesne, GetBrandsByIdResponse.class);

       return response;
    }


}
