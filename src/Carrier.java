public class Carrier extends Ship {
    public Carrier(String name, int size, Boolean isFloating, Boolean placed) {
        super(name, size, isFloating, placed);
        setName("Carrier");
        setSize(5);
        setFloating(true);
        setPlaced(false);
    }

    public Carrier() {
        super();
        setName("Carrier");
        setSize(5);
        setFloating(true);
        setPlaced(false);
    }

    @Override
    public void setName() {
    }

    @Override
    public void setSize() {
    }

    @Override
    public void setFloating() {
    }

    @Override
    public void setPlaced() {

    }
}