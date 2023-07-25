package kodlama.io.rentACar.entitites.concretes;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Table(name = "carDB")
@Data@AllArgsConstructor@NoArgsConstructor@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;



    @Column(name = "plate",  unique = true)
    private String plate;

    @Column(name = "km")
    private int km;

    @Column(name = "modelYear")
    private int modelYear;


    @Column(name = "dailyPrice")
    private double dailyprice;

    @Column(name = "state")
    private int state;
    //1-available
    //2-rented
    //3-maintenance

    @ManyToOne
    @JoinColumn(name = "model_id")
    private Model model;






}
