public abstract class Carriage {
    public void carry(){}

    @Override
    public String toString() {
        return this.getClass().getName();
    }
}
