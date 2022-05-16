public class Main {

    public static void main(String[] args) {
        final CarManufacturer manufacturer = new CarManufacturer();

        for (int i = 0; i < manufacturer.NUMBER_OF_CAR; i++) {

            new Thread(null, manufacturer::buyCar, "Buyer1").start();
            new Thread(null, manufacturer::buyCar, "Buyer2").start();
            new Thread(null, manufacturer::buyCar, "Buyer3").start();

            new Thread(null, manufacturer::createdCar, "Toyota").start();

        }
    }
}
