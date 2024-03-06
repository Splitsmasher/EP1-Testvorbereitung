package K3;

import java.util.Arrays;

public class K3_1 {

    public static void main(String[] args) {

        int[][] test1 = {{5,2,4}, {2,7,3}, {9,5,8}};
        int[][] test2 = {{1}};
        int[][] test3 = {{6,7,8}, {7,5,3, 1}, {2}};
        String seq1 = "ABBAACBA";

        int[][] result1 = generate(test1);
        System.out.println(Arrays.deepToString(result1));
        int[][] result2 = generate(test2);
        System.out.println(Arrays.deepToString(result2));

        reorder(result1);
        System.out.println(Arrays.deepToString(result1));
        reorder(result1);
        System.out.println(Arrays.deepToString(result1));

        System.out.println(isPresentNTimes(seq1, 'A', 4));
        System.out.println(isPresentNTimes(seq1, 'A', 3));
        System.out.println(isPresentNTimes(seq1, 'A', 5));
        System.out.println(isPresentNTimes(seq1, 'Z', 0));
    }

    private static boolean isPresentNTimes(String sequence, char marker, int count){
        if(count > sequence.length()){
            return false;
        }

        if (sequence.length() == 1){
            if (sequence.charAt(0) == marker && count == 1){
                return true;
            } else if (sequence.charAt(0) != marker && count == 0) {
                return true;
            } else{
                return false;
            }
        }
        else{
            if (sequence.charAt(0) == marker){
                return isPresentNTimes(sequence.substring(1), marker, count - 1);
            }
            else{
                return isPresentNTimes(sequence.substring(1), marker, count);
            }
        }
    }

    private static void reorder(int[][] input) {

        int storage;

        int counter;
        int index;
        for (int i = 0; i < input.length; i++) {
            if (input[i].length % 2 == 0){
                counter = input[i].length / 2;
            }
            else {
                counter = (input[i].length - 1) / 2;
            }

            for (int j = 0; j < counter; j++) {
                index = input[i].length - 1 - j;

                storage = input[i][j];

                input[i][j] = input[i][index];
                input[i][index] = storage;
            }
        }
    }

    private static int[][] generate(int[][] input) {

        int[][] returnArray = new int[(input.length * 2) - 1][];
        int counter = returnArray.length-1;


        for (int i = 0; i < input.length; i++) {
            returnArray[i] = new int[input.length-i];
            for (int j = (input.length - i) - 1 ; j >= 0; j--){
                returnArray[i][j] = input[i][j];
            }
        }
        for (int i = returnArray.length - 1; i >= input.length; i--) {
            returnArray[i] = new int[returnArray[i-counter].length];
            for (int j = 0; j < returnArray[i-counter].length; j++) {
                returnArray[i][j] = returnArray[i-counter][j];
            }
            counter-=2;
        }

        return returnArray;

    }

}
