import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static final int FREIGHT_CAR_CAPACITY = 70;
    private static final int PASSENGER_CAR_CAPACITY = 30;
    private static int quantity;
    private static Map<Integer, Carriage> cargoTrain = new HashMap<>();
    private static Map<Integer, Carriage> passengerTrain = new HashMap<>();
    private static String trainType;
    private static CarriageFactory factory;

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter the type of the train you want to create:\nPassenger or Cargo");
            trainType = br.readLine().toUpperCase().trim();
            int limitOfCars;
            switch (trainType) {
                case "PASSENGER":
                    limitOfCars = PASSENGER_CAR_CAPACITY;
                    factory = new PassengerCarriageFactory();
                    System.out.println("Allowed quantity of the cars for Passenger Train: 1-30");
                    break;
                case "CARGO":
                    limitOfCars = FREIGHT_CAR_CAPACITY;
                    factory = new CargoCarriageFactory();
                    System.out.println("Allowed quantity of the cars for Cargo Train: 1-70");
                    break;
                default:
                    System.out.println("You typed wrong train type!");
                    return;
            }
            do {
                System.out.println("Enter quantity of carriages:");
                String quantity = br.readLine();
                Main.quantity = Integer.parseInt(quantity);
            }
            while (quantity == 0 || quantity > limitOfCars);
        } catch (NumberFormatException e) {
            System.out.println("Enter any number, please!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        generateRandomTrain(factory, quantity);

        if (!cargoTrain.isEmpty()) {
            System.out.println("Your cargo train was successfully created\n");
            for (Map.Entry<Integer, Carriage> map : cargoTrain.entrySet()) {
                System.out.println("Car number " + map.getKey() + ": " + map.getValue());
            }
        }
        if (!passengerTrain.isEmpty()) {
            System.out.println("Your passenger train was successfully created");
            for (Map.Entry<Integer, Carriage> map : passengerTrain.entrySet()) {
                System.out.println("Car number " + map.getKey() + ": " + map.getValue());
            }
        }
    }

    private static void generateRandomTrain(CarriageFactory factory, int quantity) {
        Random random = new Random();
        for (int i = 0; i < quantity; i++) {
            if (factory instanceof CargoCarriageFactory) {
                CargoCarriageType type = CargoCarriageType.values()[random.nextInt(CargoCarriageType.values().length)];
                cargoTrain.put(i + 1, ((CargoCarriageFactory) factory).getCarriage(type));
            } else if (factory instanceof PassengerCarriageFactory) {
                PassengerCarriageType type = PassengerCarriageType.values()[random.nextInt(PassengerCarriageType.values().length)];
                passengerTrain.put(i + 1, ((PassengerCarriageFactory) factory).getCarriage(type));
            }
        }

    }
}
