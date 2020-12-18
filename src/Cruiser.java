public class Cruiser extends Ship {
    public Cruiser(String name, int size, Boolean isFloating, Boolean placed) {
        super(name, size, isFloating, placed);
        setName("Cruiser");
        setSize(3);
        setFloating(true);
        setPlaced(false);
    }

    public Cruiser() {
        super();
        setName("Cruiser");
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