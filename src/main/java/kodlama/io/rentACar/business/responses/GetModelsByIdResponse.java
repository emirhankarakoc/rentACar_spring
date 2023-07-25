package kodlama.io.rentACar.business.responses;


import kodlama.io.rentACar.entitites.concretes.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class GetModelsByIdResponse {
    private int id;
    private String name;

    private String brandName;
}
