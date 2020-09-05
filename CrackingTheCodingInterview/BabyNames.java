import java.util.*;

public class BabyNames {

    public static int accumulateDFS(NameNode node) {
        node.setCalculated(true);
        int result = node.getFrequency();
        List<NameNode> neighbours = node.getNeighbours();

        for (int i = 0; i < neighbours.size(); ++i) {
            if (neighbours.get(i).getCalculated() != true) {
                result += accumulateDFS(neighbours.get(i));
            }
        }

        return result;
    }

    public static void mergeSynonyms(List<String> names, List<Integer> frequencies,
                                     List<List<String>> synonyms) {
        assert(names.size() == frequencies.size());
        Map<String, NameNode> nodes = new HashMap<>();

        for (int i = 0; i < names.size(); ++i) {
            nodes.put(names.get(i), new NameNode(names.get(i), frequencies.get(i)));
        }

        for (int i = 0; i < synonyms.size(); ++i) {
            NameNode node1 = nodes.get(synonyms.get(i).get(0));
            NameNode node2 = nodes.get(synonyms.get(i).get(1));

            if (node1 == null && node2 == null) {
                throw new IllegalArgumentException("Invalid synonyms");
            }

            if (node1 == null) {
                nodes.put(synonyms.get(i).get(0), new NameNode(synonyms.get(i).get(0), 0)); 
                node1 = nodes.get(synonyms.get(i).get(0));
            } 
            
            if (node2 == null) {
                nodes.put(synonyms.get(i).get(1), new NameNode(synonyms.get(i).get(1), 0));
                node2 = nodes.get(synonyms.get(i).get(1));
            }

            node1.addNeighbour(node2);
            node2.addNeighbour(node1);
        }

        for (int i = 0; i < names.size(); ++i) {
            NameNode node = nodes.get(names.get(i));
            if (node.getCalculated() == false) {
                System.out.println(names.get(i) + " " + accumulateDFS(node));
            }
        }
    }

    public static void main(String[] args) {
        String[] namesArray = {"John", "Jon", "Chris", "Kris", "Christopher"};
        List<String> names = Arrays.asList(namesArray);
        Integer[] frequenciesArray = {15, 12, 13, 4, 19};
        List<Integer> frequencies = Arrays.asList(frequenciesArray);

        String[] syn1 = {"Jon", "John"};
        String[] syn2 = {"John", "Johnny"};
        String[] syn3 = {"Chris", "Kris"};
        String[] syn4 = {"Chris", "Christopher"};
        List<List<String>> synonyms = new ArrayList<>();
        synonyms.add(Arrays.asList(syn1));
        synonyms.add(Arrays.asList(syn2));
        synonyms.add(Arrays.asList(syn3));
        synonyms.add(Arrays.asList(syn4));

        mergeSynonyms(names, frequencies, synonyms);
    }
}