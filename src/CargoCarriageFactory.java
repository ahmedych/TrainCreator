public class CargoCarriageFactory extends CarriageFactory{
    public Carriage getCarriage(CargoCarriageType type) {
        Carriage toReturn;
        switch (type) {
            case TANKER_CAR:
                toReturn = new EconomClassCar();
                break;
            case CATTLE_CAR:
                toReturn = new TankerCar();
                break;
            case COAL_CAR:
                toReturn = new MailCar();
                break;
            default:
                throw new IllegalArgumentException("Wrong carriage type:" + type);
        }
        return toReturn;
    }
}
