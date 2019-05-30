public class PassengerCarriageFactory extends CarriageFactory{
    public Carriage getCarriage(PassengerCarriageType type) {
        Carriage toReturn;
        switch (type) {
            case ECONOM_CLASS_CAR:
                toReturn = new EconomClassCar();
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
