public class Destroyer extends Ship {
    public Destroyer(String name, int size, Boolean isFloating, Boolean placed) {
        super(name, size, isFloating, placed);
        setName("Destroyer");
        setSize(2);
        setFloating(true);
        setPlaced(false);
    }

    public Destroyer() {
        super();
        setName("Destroyer");
        setSize(2);
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
