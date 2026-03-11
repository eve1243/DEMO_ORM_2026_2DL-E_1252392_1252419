package isep.eapli.demo_orm.domain;

import jakarta.persistence.*;

@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String licensePlate;
    private int manifactureYear;
    private int aquisitionYear;
    private String enginedisplacement;
    @ManyToOne
    @JoinColumn(name = "car_group_id")
    private CarGroup carGroup;

    public Car() {
    }

    public Car(String licensePlate, int manifactureYear, int aquisitionYear,
               String enginedisplacement, CarGroup carGroup) {
        this.licensePlate = licensePlate;
        this.manifactureYear = manifactureYear;
        this.aquisitionYear = aquisitionYear;
        this.enginedisplacement = enginedisplacement;
        this.carGroup = carGroup;
    }


    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", licensePlate='" + licensePlate + '\'' +
                ", manifactureYear=" + manifactureYear +
                ", aquisitionYear=" + aquisitionYear +
                ", enginedisplacement='" + enginedisplacement + '\'' +
                ", carGroup=" + (carGroup != null ? carGroup.getGroupName() : "null") +
                '}';
    }
}
