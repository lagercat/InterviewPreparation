import java.util.*;

public class UniqueStringsDS {
      public static boolean isUnique(String str) {
        Set<Character> letters = new HashSet<>();
        for (char c: str.toCharArray()) {
          if (letters.contains(c)) {
            return false;
          }
          letters.add(c);
        }

        return true;
      }


      public static void main(String[] args) {
        System.out.println(isUnique("ada"));
        System.out.println(isUnique(""));
        System.out.println(isUnique("adb"));
        System.out.println(isUnique("nicuu"));
      }
}
