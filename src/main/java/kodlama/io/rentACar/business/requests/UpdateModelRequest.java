package kodlama.io.rentACar.business.requests;

import kodlama.io.rentACar.entitites.concretes.Brand;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateModelRequest {
    private String name;
    private int id;


}
