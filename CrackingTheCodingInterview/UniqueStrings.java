import java.util.*;

public class UniqueStrings {

  public static boolean isUnique(String str) {
    char[] iterate = str.toCharArray();
    Arrays.sort(iterate);
    for (int i = 0; i < iterate.length - 1; ++i) {
      if (iterate[i] == iterate[i + 1]) {
        return false;
      }
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
