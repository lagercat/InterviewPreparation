import java.util.*;

public class LangtonAnt {

    private static class Position {
        
        // No encapsulation on purpose
        public int x, y;

        public Position(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object that) {
            if (!(that instanceof Position)) {
                return false;
            }

            Position thatPosition = (Position) that;

            return x == thatPosition.x && y == thatPosition.y;
        }

        @Override
        public int hashCode() {
            return 37 * x + y;
        }
    }

    public static void printMoves(int k) {
        Map<Position, Boolean> changedColours = new HashMap<>();
        Position currentPosition = new Position(0, 0);
        int currentOrientation = 0;
        int dx[] = {0, 1, 0, -1};
        int dy[] = {1, 0, -1, 0};
        
        // Use for printing
        int minCol = 0;
        int maxCol = 0;
        int minRow = 0;
        int maxRow = 0;

        for (; k > 0; k--) {
            Boolean defaultIsWhite = Math.floorMod(currentPosition.x, 2) == 0 ?
                                     Math.floorMod(currentPosition.y, 2) == 0 :
                                     Math.floorMod(currentPosition.y, 2) == 1; 
            Boolean isWhite = changedColours.getOrDefault(currentPosition, defaultIsWhite);

            if (isWhite) {
                currentOrientation = Math.floorMod(currentOrientation + 1, 4);
            } else {
                currentOrientation = Math.floorMod(currentOrientation - 1, 4);
            }
            isWhite = !isWhite;
            changedColours.put(currentPosition, isWhite);

            currentPosition = new Position(currentPosition.x + dx[currentOrientation],
                                           currentPosition.y + dy[currentOrientation]);
            minCol = Math.min(minCol, currentPosition.y);
            maxCol = Math.max(maxCol, currentPosition.y);
            minRow = Math.min(minRow, currentPosition.x);
            maxRow = Math.max(maxRow, currentPosition.x);
        }

        StringBuilder result = new StringBuilder();
        for (int i = minRow; i <= maxRow; ++i) {
            for (int j = minCol; j <= maxCol; ++j) {
                Boolean defaultIsWhite = Math.floorMod(i, 2) == 0 ?
                Math.floorMod(j, 2) == 0 : Math.floorMod(j, 2) == 1; 
                Boolean isWhite = changedColours.getOrDefault(new Position(i, j), defaultIsWhite);

                result.append((isWhite ? "w" : "b") + " ");
            }
            result.append("\n");
        }

        System.out.println(result.toString());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printMoves(scanner.nextInt());
    }
}