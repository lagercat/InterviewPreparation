import java.util.*;

public class NameNode {

    private boolean calculated;
    private String name;
    private int frequency;
    private List<NameNode> neighbours;

    public NameNode(String name, int frequency) {
        this.name = name;
        this.frequency = frequency;
        calculated = false;
        neighbours = new ArrayList<>();
    }

    public void addNeighbour(NameNode node) {
        neighbours.add(node);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setCalculated(boolean calculated) {
        this.calculated = calculated;
    }

    public boolean getCalculated() {
        return calculated;
    }

    public List<NameNode> getNeighbours() {
        return new ArrayList<>(neighbours);
    }
}