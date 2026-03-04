package isep.eapli.demo_orm.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class CarGroup {
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long id;



    public CarGroup() {}

}
