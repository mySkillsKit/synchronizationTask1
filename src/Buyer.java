public class Buyer {

    private final int CAR_BUILD_TIME = 10000; //time for a manufacturer to create a car
    private final int TIMEOUT_TO_BUY_CAR = 2000;// timeout of desire to buy a car

    private CarManufacturer carManufacturer;

    public Buyer(CarManufacturer carManufacturer) {
        this.carManufacturer = carManufacturer;
    }

    public synchronized void releasedCar() {
        try {
            Thread.sleep(CAR_BUILD_TIME);
            carManufacturer.getCars().add(new Car());
            System.out.println("The Manufacturer " + Thread.currentThread().getName() + " released 1 car");
            notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized Car buyCar() {
        try {
            System.out.println(Thread.currentThread().getName() + " entered the dealership");
            while (carManufacturer.getCars().size() == 0) {
                System.out.println("No cars available!");
                wait();
            }
            Thread.sleep(TIMEOUT_TO_BUY_CAR);
            System.out.println(Thread.currentThread().getName() + " left the dealership a new car ");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return carManufacturer.getCars().remove(0);
    }
}
