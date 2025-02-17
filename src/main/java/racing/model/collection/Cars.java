package racing.model.collection;

import java.util.ArrayList;
import java.util.List;
import racing.domain.Car;
import racing.model.CarSnapshot;
import racing.model.RoundResult;
import racing.util.NumberGenerator;

public class Cars {

    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = new ArrayList<>(cars);
    }

    public void moveCars() {
        for (Car car : cars) {
            car.move();
        }
    }

    public RoundResult getRoundResult() {
        List<CarSnapshot> carSnapshotList = new ArrayList<>();
        for (Car car : cars) {
            carSnapshotList.add(car.getCarInfo());
        }
        return RoundResult.save(carSnapshotList);
    }

    public static Cars create(List<String> carNames, NumberGenerator numberGenerator) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(Car.create(name, numberGenerator));
        }
        return new Cars(cars);
    }
}
