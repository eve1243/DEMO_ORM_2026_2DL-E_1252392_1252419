package isep.eapli.demo_orm.application;

import isep.eapli.demo_orm.domain.Car;
import isep.eapli.demo_orm.domain.GroupCar;
import isep.eapli.demo_orm.persistence.CarRepository;
import isep.eapli.demo_orm.persistence.CarRepositoryJPA;
import isep.eapli.demo_orm.persistence.GroupCarRepository;
import isep.eapli.demo_orm.persistence.GroupCarRepositoryJPA;

/**
 * Controller für Car-Operationen im Application Layer
 * Delegiert an die JPA Repository Implementierungen
 */
public class CarConroller {
    private final CarRepository carRepository;
    private final GroupCarRepository groupCarRepository;

    public CarConroller() {
        this.carRepository = new CarRepositoryJPA();
        this.groupCarRepository = new GroupCarRepositoryJPA();
    }

    public CarConroller(CarRepository carRepository, GroupCarRepository groupCarRepository) {
        this.carRepository = carRepository;
        this.groupCarRepository = groupCarRepository;
    }

    /**
     * Erstellt und speichert ein neues Car
     */
    public Car createCar(String licensePlate, int manufactureYear, int acquisitionYear,
                         String engineDisplacement, GroupCar groupCar) {
        Car car = new Car(licensePlate, manufactureYear, acquisitionYear, engineDisplacement, groupCar);
        return carRepository.save(car);
    }

    /**
     * Speichert ein Car
     */
    public Car save(Car car) {
        return carRepository.save(car);
    }

    /**
     * Gibt alle Cars zurück
     */
    public Iterable<Car> findAll() {
        return carRepository.findAll();
    }

    /**
     * Gibt alle GroupCars zurück
     */
    public java.util.List<GroupCar> getAllGroupCars() {
        return groupCarRepository.findAll();
    }

    /**
     * Schließt die Repositories
     */
    public void close() {
        carRepository.close();
        groupCarRepository.close();
    }
}
