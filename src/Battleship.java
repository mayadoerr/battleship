public class Battleship extends Ship {
    public Battleship(String name, int size, Boolean isFloating, Boolean isPlaced) {
        super(name, size, isFloating, isPlaced);
        setName("Battleship");
        setSize(4);
        setFloating(true);
        setPlaced(false);
    }

    public Battleship() {
        super();
        setName("Battleship");
        setSize(4);
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
