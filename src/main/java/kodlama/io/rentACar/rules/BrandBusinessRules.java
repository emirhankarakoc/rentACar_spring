package kodlama.io.rentACar.rules;

import kodlama.io.rentACar.core.utilities.exceptions.BusinessException;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;

import kodlama.io.rentACar.entitites.concretes.Brand;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;


@EnableJpaRepositories(basePackages = "kodlama.io.rentACar.dataAccess.abstracts")
@Service
public class BrandBusinessRules {
    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    public BrandBusinessRules(BrandRepository brandRepository){
        this.brandRepository = brandRepository;

    }


    public void checkIfBrandNameExists(String name) {
        if (this.brandRepository.existsByName(name)) {
            throw new BusinessException("Brand Name Already Exists");
        }
    }
















}
