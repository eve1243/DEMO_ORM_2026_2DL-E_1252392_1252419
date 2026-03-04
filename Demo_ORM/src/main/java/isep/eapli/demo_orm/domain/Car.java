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

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public int getManifactureYear() {
        return manifactureYear;
    }

    public void setManifactureYear(int manifactureYear) {
        this.manifactureYear = manifactureYear;
    }

    public int getAquisitionYear() {
        return aquisitionYear;
    }

    public void setAquisitionYear(int aquisitionYear) {
        this.aquisitionYear = aquisitionYear;
    }

    public String getEnginedisplacement() {
        return enginedisplacement;
    }

    public void setEnginedisplacement(String enginedisplacement) {
        this.enginedisplacement = enginedisplacement;
    }

    public CarGroup getCarGroup() {
        return carGroup;
    }

    public void setCarGroup(CarGroup carGroup) {
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
