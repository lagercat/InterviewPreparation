import java.lang.Math;

public class OneAway {

  public static boolean oneAway(String str1, String str2) {
    if (Math.abs(str1.length() - str2.length()) > 1) {
      return false;
    }

    boolean changeFound = false;
    for (int i = 0, j = 0; i < str1.length() && j < str2.length(); ++i, ++j) {
      if (str1.charAt(i) != str2.charAt(j)) {
        if (changeFound) {
          return false;
        }

        changeFound = true;
        if (str1.length() > str2.length()) {
          --j;
        } else if (str1.length() < str2.length()) {
          --i;
        }
      }
    }

    return true;
  }

  public static void main(String args[]) {
    System.out.println(oneAway("cool", "col"));
    System.out.println(oneAway("col", "cool"));
    System.out.println(oneAway("nice", "nice"));
    System.out.println(oneAway("god", "goood"));
    System.out.println(oneAway("nasty", "bose"));
  }
}
