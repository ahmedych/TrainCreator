class PassengerCarriageFactory extends CarriageFactory {
    Carriage getCarriage(PassengerCarriageType type) {
        Carriage toReturn;
        switch (type) {
            case ECONOM_CLASS_CAR:
                toReturn = new EconomClassCar();
                break;
            case SECOND_CLASS_CAR:
                toReturn = new SecondClassCar();
                break;
            case FIRST_CLASS_CAR:
                toReturn = new FirstClassCar();
                break;
            case MAIL_CAR:
                toReturn = new MailCar();
                break;
            case RESTAURANT_CAR:
                toReturn = new RestaurantCar();
                break;
            default:
                throw new IllegalArgumentException("Wrong carriage type:" + type);
        }
        return toReturn;
    }
}
