public class CarriageFactory {
    public Carriage getCarriage(CarriageType type) {
        Carriage toReturn = null;
        switch (type) {
            case PASSENGER_CAR:
                toReturn = new PassengerCar();
                break;
            case FREIGHT_CAR:
                toReturn = new FreightCar();
                break;
            case MAIL_CAR:
                toReturn = new MailCar();
                break;
            case RESTAURANT_CAR:
                toReturn = new RestaurantCar();
                break;
                default:
                    throw new IllegalArgumentException("Wrong carriage type:"+type);
        }
        return toReturn;
    }
}
