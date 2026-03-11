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
    private GroupCar groupCar;

    public GroupCar getGroupCar() {
        return groupCar;
    }

    public void setGroupCar(GroupCar groupCar) {
        this.groupCar = groupCar;
    }

    public Car() {
    }

    public Car(String licensePlate, int manifactureYear, int aquisitionYear,
               String enginedisplacement, GroupCar groupCar) {
        this.licensePlate = licensePlate;
        this.manifactureYear = manifactureYear;
        this.aquisitionYear = aquisitionYear;
        this.enginedisplacement = enginedisplacement;
        this.groupCar = groupCar;
    }


    @Override
    public String toString() {
        return  "licensePlate='" + licensePlate + '\'' +
                ", manifactureYear=" + manifactureYear +
                ", aquisitionYear=" + aquisitionYear +
                ", enginedisplacement='" + enginedisplacement + '\'' +" GroupCar= " + groupCar.getGroupName() ;
    }
}
