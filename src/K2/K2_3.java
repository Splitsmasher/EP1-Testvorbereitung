package K2;

public class K2_3 {

    public static void main(String[] args) {

        String test = "Blaukraut";
        short result;

        System.out.println(getIntegerRoot(144));
        System.out.println(getIntegerRoot(13));
        System.out.println(getIntegerRoot(1));
        result = (short) getIntegerRoot(25);

        System.out.println(getThird("toss", "a", "coin"));
        System.out.println(getThird("Blaukraut", "bleibt", test));
        System.out.println(getThird("badger", "badger", "badger"));

        System.out.println(replaceA("TU Wien"));
        System.out.println(replaceA("Hubba bubba!"));
        System.out.println(replaceA("aaaa"));

        printBars(19);
        printBars(20);
        printBars(21);
    }

    private static void printBars(int i) {

        String line1 = "";
        String line2 = "";
        int counterLine1 = 1;
        int counterLine2 = 1;

        for (int j = 1; j <= i; j++) {
            if (j % 3 == 0){
                line2 += j;
                if (counterLine2 % 2 == 0) {
                    line2 += "-";
                    counterLine2++;
                }
                else{
                    line2 += "+";
                    counterLine2++;
                }
            }else{
                line1 += j;
                switch (counterLine1 % 2){
                    case 0:
                        line1 += "+";
                        counterLine1++;
                        break;
                    case 1:
                        line1 += "-";
                        counterLine1++;
                        break;
                }
            }
        }

        System.out.println(line1);
        System.out.println(line2);

    }

    private static String replaceA(String s) {

        int counter = 1;
        String newText = "";

        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == 'a'){
                newText += counter;
                counter++;
            }
            else{
                newText += s.charAt(i);
            }
        }

        return newText;

    }

    private static int getIntegerRoot(int k) {

        for (int i = 1; i * i <= k ; i++) {
            if (i * i == k){
                return i;
            }
        }
        return -1;
    }

    private static String getThird(String a, String b, String c){
        if (a.equals(b) && b.equals(c)){
               return "alle gleich";
        } else if (a.equals(b)) {
            return c;
        } else if (b.equals(c)) {
            return a;
        } else if (a.equals(c)) {
            return b;
        } else {
         return "alle unterschiedlich";
        }
    }

}
