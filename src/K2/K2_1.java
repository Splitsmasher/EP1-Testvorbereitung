package K2;

public class K2_1 {

    public static void main(String[] args) {

        short result;
        String test = "Teststring_Einstufungstest";

        System.out.println(myMult(21, 4));
        System.out.println(myMult(2, 3500));
        result = (short) myMult(3,7);
        System.out.println(result);

        System.out.println(findMaxChar(test));
        System.out.println(findMaxChar("abcdefg"));
        System.out.println(findMaxChar("4321"));

        System.out.println(replaceNthChar(test, 1, '0'));
        System.out.println(replaceNthChar(test, 3, '#'));
        System.out.println(replaceNthChar(test, 10, '-'));
        System.out.println(replaceNthChar(test, 30, 'X'));
        System.out.println(replaceNthChar("A", 1, '#'));

        printPattern(3, '*');
        printPattern(5, '+');
    }

    private static int myMult(int x, int y){
        return Math.multiplyExact(x, y);
    }

    private static char findMaxChar(String text){

        char newChar;
        char biggestChar;
        int ASCII;
        int biggestValue;

        biggestChar = text.charAt(0);
        biggestValue = biggestChar;

        for (int i = 1; i < text.length(); i++) {
            newChar = text.charAt(i);

            ASCII = newChar;

            if (ASCII > biggestValue){
                biggestValue = ASCII;
                biggestChar = newChar;
            }
        }

        return biggestChar;
    }

    private static String replaceNthChar(String text, int n, char replaceChar){

        String returnString = "";

        returnString += text.charAt(0);

        for (int i = 1; i < text.length(); i++) {
            if (i % n == 0){
                returnString += replaceChar;
            }
            else{
                returnString += text.charAt(i);
            }
        }
        return  returnString;
    }

    private static void printPattern(int n, char character){
        int counter = 0;

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < counter; k++) {
                System.out.print(" ");
            }
            for (int j = 0; j < n + counter; j++) {
                System.out.print(character);
            }
            System.out.println();
            counter++;
        }
    }
}
