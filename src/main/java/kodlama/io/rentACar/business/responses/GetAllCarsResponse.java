package kodlama.io.rentACar.business.responses;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class GetAllCarsResponse {

    private String plate;
    private int km;
    private int modelYear;
    private double dailyPrice;
    private int state;

    private String modelName;
    private String brandName;
}
