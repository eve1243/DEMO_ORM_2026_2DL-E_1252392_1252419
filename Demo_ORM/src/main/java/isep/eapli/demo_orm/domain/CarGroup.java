package isep.eapli.demo_orm.domain;

import jakarta.persistence.*;

@Entity
public class CarGroup {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;
    private String groupName;
    private int numOfDoors;
    private int pricePerDay;
    public enum ClassType {Utility, Luxury, Commercial}

    @Enumerated(EnumType.STRING)
    private ClassType classType;

    public CarGroup() {}

    public CarGroup(String groupName, int numOfDoors, int pricePerDay, ClassType classType) {
        this.groupName = groupName;
        this.numOfDoors = numOfDoors;
        this.pricePerDay = pricePerDay;
        this.classType = classType;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getNumOfDoors() {
        return numOfDoors;
    }

    public void setNumOfDoors(int numOfDoors) {
        this.numOfDoors = numOfDoors;
    }

    public int getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(int pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public ClassType getClassType() {
        return classType;
    }

    public void setClassType(ClassType classType) {
        this.classType = classType;
    }

    @Override
    public String toString() {
        return "CarGroup{" +
                "id=" + id +
                ", groupName='" + groupName + '\'' +
                ", numOfDoors=" + numOfDoors +
                ", pricePerDay=" + pricePerDay +
                ", classType=" + classType +
                '}';
    }
}
