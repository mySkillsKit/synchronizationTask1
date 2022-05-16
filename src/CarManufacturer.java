import java.util.ArrayList;
import java.util.List;

public class CarManufacturer {
    final int NUMBER_OF_CAR = 10; //number of produced Toyota cars

    Buyer buyer = new Buyer(this);

    List<Car> cars = new ArrayList<>(NUMBER_OF_CAR);

    public Car buyCar() {
        return buyer.buyCar();
    }

    public void createdCar() {
        buyer.releasedCar();
    }

    List<Car> getCars() {
        return cars;
    }

}
