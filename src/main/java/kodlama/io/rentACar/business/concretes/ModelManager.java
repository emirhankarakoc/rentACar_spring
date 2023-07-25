package kodlama.io.rentACar.business.concretes;


import kodlama.io.rentACar.business.abstracts.ModelService;
import kodlama.io.rentACar.business.requests.CreateModelRequest;
import kodlama.io.rentACar.business.requests.UpdateModelRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetAllModelsResponse;
import kodlama.io.rentACar.business.responses.GetBrandsByIdResponse;
import kodlama.io.rentACar.business.responses.GetModelsByIdResponse;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperServiceImpl;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.dataAccess.abstracts.ModelRepository;
import kodlama.io.rentACar.entitites.concretes.Brand;
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
@Data@AllArgsConstructor@NoArgsConstructor
public class ModelManager  implements ModelService {

    @Autowired
    private ModelRepository modelRepository;

    @Autowired
    private BrandRepository brandRepository;
    @Autowired
    private ModelMapperServiceImpl modelMapperServiceImpl;


    @Override
    public List<GetAllModelsResponse> getAll() {

        List<Model> models = this.modelRepository.findAll();

        List<GetAllModelsResponse> modelsResponse = models.stream()
                .map(model -> this.modelMapperServiceImpl.forResponse()
                        .map(model,GetAllModelsResponse.class)).collect(Collectors.toList());


        return modelsResponse;
    }


    @Override
    public void add(CreateModelRequest createModelRequest) {

        Model model = this.modelMapperServiceImpl.forRequest().map(createModelRequest, Model.class);
        this.modelRepository.save(model);


    }

    @Override
    public void update(UpdateModelRequest updateModelRequest) {
        Model existingModel = this.modelRepository.findById(updateModelRequest.getId()).orElse(null);
        if (existingModel != null) {
            existingModel.setName(updateModelRequest.getName());
            // Markayı güncelleme işlemine dahil etmeden diğer değişiklikleri kaydet.
            this.modelRepository.save(existingModel);
        }

        this.modelRepository.save(existingModel);
    }

    @Override
    public void delete(int id) {
        this.modelRepository.deleteById(id);
    }

    @Override
    public GetModelsByIdResponse getById(int id) {
        Model doneceknesne = this.modelRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Verilen ID ile bir Model bulunamadı: " + id));

        Brand brand = doneceknesne.getBrand();
        if (brand == null) {
            throw new NullPointerException("Modelin Brand nesnesi null. Brand nesnesini kontrol edin.");
        }



        GetModelsByIdResponse response = new GetModelsByIdResponse();
        response.setBrandName(doneceknesne.getBrand().getName());
        response.setId(doneceknesne.getId());
        response.setName(doneceknesne.getName());

        return response;
    }
}
