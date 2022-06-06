package info.sjd;

public class AppRunner {
    public static void main(String[] args) {
        int numOne = 12345;
        int numTwo = 123;

        System.out.println(getResultAsString(numOne, numTwo));

    }

    private static String getResultAsString(int numOne, int numTwo) {
        StringBuffer result = new StringBuffer();
        //Get max length
        int multResult = numOne * numTwo;
        int lineLength = String.valueOf(multResult).length();
        //get amount spaces for first string
        result.append(getSpaces(lineLength - String.valueOf(numOne).length()));
        result.append(numOne + "\n");
        //get amount spaces for second string
        result.append(getSpaces(lineLength - String.valueOf(numTwo).length()));
        result.append(numTwo + "\n");
        //get underlines
        if (numOne > numTwo){
            result.append(getSpaces(lineLength - String.valueOf(numOne).length()));
            result.append(getUnderlines(String.valueOf(numOne).length()) + "\n");
        } else {
            result.append(getSpaces(lineLength - String.valueOf(numOne).length()));
            result.append(getUnderlines(String.valueOf(numTwo).length()) + "\n");
        }
        result.append(getRows(numOne, numTwo, lineLength));
        result.append(getUnderlines(lineLength) + "\n");
        result.append(multResult);
        return result.toString();
    }
    //Get the result of multiplying all digits by numTwo + shiftRight
    private static String getRows(int numOne, int numTwo, int lineLength) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        while (numTwo > 0){
            int number = numOne * (numTwo % 10);
            numTwo /= 10;
            result.append(getSpaces(lineLength - count - String.valueOf(number).length()));
            result.append(number + "\n");
            count++;
        }
        return result.toString();
    }

    private static String getUnderlines(int amount) {
        String result = "";
        for (int i = 0; i < amount; i++) {
            result += "_";
        }
        return result;
    }

    private static String getSpaces(int amount) {
        String result = "";
        for (int i = 0; i < amount; i++) {
            result += " ";
        }
        return result;
    }
}
