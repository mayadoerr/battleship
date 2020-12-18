public abstract class Ship implements Transport {
    private String name;
    private int size;
    private Boolean isFloating;
    private Boolean isPlaced;

    public Ship(String name, int size, Boolean isFloating, Boolean isPlaced) {
        this.name = name;
        this.size = size;
        this.isFloating = isFloating;
        this.isPlaced = isPlaced;
    }

    public Ship() {

    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Boolean getFloating() {
        return isFloating;
    }

    @Override
    public Boolean getPlaced() { return isPlaced; }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setFloating(Boolean floating) {
        isFloating = floating;
    }

    public void setPlaced(Boolean placed) { isPlaced = placed; }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", isFloating=" + isFloating +
                ", placed=" + isPlaced +
                '}';
    }
}
