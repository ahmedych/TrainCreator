class CargoCarriageFactory extends CarriageFactory {
    Carriage getCarriage(CargoCarriageType type) {
        Carriage toReturn;
        switch (type) {
            case TANKER_CAR:
                toReturn = new TankerCar();
                break;
            case CATTLE_CAR:
                toReturn = new CattleCar();
                break;
            case COAL_CAR:
                toReturn = new CoalCar();
                break;
            case VEHICLE_CAR:
                toReturn = new VehicleCar();
                break;
            default:
                throw new IllegalArgumentException("Wrong carriage type:" + type);
        }
        return toReturn;
    }
}
