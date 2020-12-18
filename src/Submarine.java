public class Submarine extends Ship {
    public Submarine(String name, int size, Boolean isFloating, Boolean placed) {
        super(name, size, isFloating, placed);
        setName("Submarine");
        setSize(3);
        setFloating(true);
    }

    public Submarine() {
        super();
        setName("Submarine");
        setSize(3);
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