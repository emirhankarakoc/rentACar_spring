package kodlama.io.rentACar.business.requests;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class CreateCarRequest {

    private String plate;
    private int km;
    private int modelYear;
    private double dailyPrice;
    private int state;

    private int modelId;
}
