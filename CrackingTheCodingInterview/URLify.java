public class URLify {

    public static String replaceSpaces(String str, int trueLength) {
        int countSpaces = 0;
        char[] strChar = str.toCharArray();

        for (int i = 0; i < trueLength; ++i) {
            if (strChar[i] == ' ') {
                countSpaces++;
            }
        }

        int offset = 2 * countSpaces;
        int endPosition = offset + trueLength - 1;
        for (int i = endPosition; countSpaces > 0; --i) {
            if (strChar[i - offset] == ' ') {
                countSpaces--;
                strChar[i] = '0';
                strChar[i - 1] = '2';
                strChar[i - 2] = '%';
                i -= 2;
                offset -= 2;
            } else {
                strChar[i] = strChar[i - offset];
            }
        }

        return String.valueOf(strChar);
    }

    public static void main(String[] args) {
        System.out.println(replaceSpaces("   ", 1));
    }
}