import java.util.Arrays;
import java.lang.IllegalArgumentException;

public class RankFromStream {
    
    private static class BinarySearchNode {
        public int value;
        public BinarySearchNode left;
        public BinarySearchNode right;
        public int nodesOnLeft;

        public BinarySearchNode(int value) {
            this.value = value;
        }
    }

    private BinarySearchNode root;

    private void add(int x, BinarySearchNode currentNode) {
        if (x > currentNode.value) {
            if (currentNode.right == null) {
                currentNode.right = new BinarySearchNode(x);
            } else {
                add(x, currentNode.right);
            }
        } else {
            if (currentNode.left == null) {
                currentNode.left = new BinarySearchNode(x);
            } else {
                add(x, currentNode.left);
            }
            currentNode.nodesOnLeft++;
        }
    }

    public void track(int x) {
        if (root == null) {
            root = new BinarySearchNode(x);
            return;
        }
        add(x, root);
    }

    public int getRankOfNumber(int x) {
        int rankSum = 0;
        BinarySearchNode currentNode = root;
        while (currentNode != null) {
            if (x == currentNode.value) {
                rankSum += currentNode.nodesOnLeft;
                return rankSum;
            }

            if (x < currentNode.value) {
                currentNode = currentNode.left;
            } else {
                rankSum += currentNode.nodesOnLeft + 1;
                currentNode = currentNode.right;
            }
        }
        throw new IllegalArgumentException("The node you are looking for is no in the tree.");
    }


    public static void main(String[] args) {
        int[] intStream = {5, 1, 4, 4, 5, 9, 7, 13, 3};
        RankFromStream list = new RankFromStream();

        Arrays.stream(intStream).forEach(x -> list.track(x));
        System.out.println(list.getRankOfNumber(1));
        System.out.println(list.getRankOfNumber(3));
        System.out.println(list.getRankOfNumber(4));
        System.out.println(list.getRankOfNumber(7));
        System.out.println(list.getRankOfNumber(13));
    }
}