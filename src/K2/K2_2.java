package K2;

public class K2_2 {

    public static void main(String[] args) {

        String test = "Teststring_Einstufungstest";
        short result;


        System.out.println(countDivisors(1, 28));
        System.out.println(countDivisors(101, 2001));
        System.out.println(countDivisors(8, 8));
        result = (short) countDivisors(299, 305);

        System.out.println(findDoubles(test));
        System.out.println(findDoubles("Haarspangenaal"));
        System.out.println(findDoubles("The Black Beast of Aaaaargh!"));
        System.out.println(findDoubles("Schokoladenkuchen"));

        System.out.println(reverseInsert(test, '.'));
        System.out.println(reverseInsert("qwerty", '-'));
        System.out.println(reverseInsert("Pinkie Pie", '!'));

        printPattern(4, '!');
        printPattern(5, '*');
    }

    private static void printPattern(int n, char character) {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0){
                for (int j = 0; j < n; j++) {
                    System.out.print(character);
                    System.out.print(character);
                }
                System.out.println(i);
            }
            else{
                for (int j = 0; j < n; j++) {
                    System.out.print(character);
                    System.out.print('.');
                }
                System.out.println(i);
            }
        }
    }

    private static String reverseInsert(String text, char character) {

        String newString = "";
        newString += text.charAt(text.length() - 1);;

        for (int i = text.length() - 2; i >= 0; i--) {
            newString += character;
            newString += text.charAt(i);
        }

        return newString;

    }

    private static int findDoubles(String text) {

        char lastChar = text.charAt(0);
        int counter = 0;

        for (int i = 1; i < text.length(); i++) {
            if (text.charAt(i) == 'a' && lastChar == 'a'){
                counter++;
            }
            lastChar = text.charAt(i);
        }

        return counter;
    }

    private static int countDivisors(int x, int y) {

        int counter = 0;

        for (int i = x; i <= y ; i++) {
            if ((i % 4 == 0) && (i % 6 != 0)){
                counter ++;
            }
        }

        return counter;
    }

}
