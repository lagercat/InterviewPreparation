import java.util.*;

public class EnglishInt {

    private static Map<Integer, String> initMap() {
        Map<Integer, String> result = new HashMap<>();
        result.put(0, "zero");
        result.put(1, "one");
        result.put(2, "two");   
        result.put(3, "three");   
        result.put(4, "four");   
        result.put(5, "five");   
        result.put(6, "six");   
        result.put(7, "seven");   
        result.put(8, "eight");   
        result.put(9, "nine");   
        result.put(10, "ten");   
        result.put(11, "eleven");   
        result.put(12, "twelve");   
        result.put(20, "twen");   
        result.put(30, "thir");   
        result.put(40, "four");   
        result.put(50, "fif");   
        result.put(60, "six");   
        result.put(70, "seven");   
        result.put(80, "eight");   
        result.put(90, "nine");

        return result;
    }
    
    public static String convertToEnglish(int n) {
        StringBuilder result = new StringBuilder();
        String str = new StringBuilder(Integer.toString(n)).reverse().toString();

        List<StringBuilder> stringDivisions = new ArrayList<>();
        Map<Integer, String> mapIntegers = initMap();
        String[] suffixes = {"", "thousand ", "million ", "billion "};

        for (int i = 0; i < str.length(); i += 3) {
            StringBuilder currentDivision = new StringBuilder();
            for(int j = 2; j >= 0; --j) {
                if (i + j < str.length()) {
                    int digit = str.charAt(i + j) - '0';

                    if (j == 2) {
                        if (digit != 0) {
                            currentDivision.append(mapIntegers.get(digit) + " hundred ");
                        }
                    } else if (j == 1){
                        if (digit == 0) {
                            continue;
                        } else if (digit == 1) {
                            int lastTwo = digit * 10 + (str.charAt(i) - '0');

                            if (lastTwo < 13) {
                                currentDivision.append(mapIntegers.get(lastTwo) + " ");
                            } else {
                                currentDivision.append(mapIntegers.get((lastTwo % 10) * 10) + "teen ");
                            }
                            break;
                        } else {
                            currentDivision.append(mapIntegers.get(digit * 10) + "ty ");
                            if (str.charAt(i) == '0') {
                                break;
                            }
                        }
                    } else {
                        if (digit != 0 || str.length() == 1) {
                            currentDivision.append(mapIntegers.get(digit) + " ");
                        }
                    }
                }
            }

            if (currentDivision.length() != 0) {
                currentDivision.append(suffixes[i / 3]);
            }
            stringDivisions.add(currentDivision);
        }


        for (int i = stringDivisions.size() - 1; i >= 0; --i) {
            result.append(stringDivisions.get(i));
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(convertToEnglish(scanner.nextInt()));
    }
}