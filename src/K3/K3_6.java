package K3;

import java.util.Arrays;

public class K3_6 {
    public static void main(String[] args) {
        int[][] test1 = {{5},{5,7,9},{8,5},{}};
        int[][] test2 = {{1,2},{1,2,3},{1,2,3,4}};
        int[][] test3 = {{},{1,2,3,4},{1}};
        int[] seq = {1,2,-5,3,-1,6,-3,3};

        int[][] result1 = getRectangular(test1);
        System.out.println(Arrays.deepToString(result1));
        int[][] result2 = getRectangular(test2);
        System.out.println(Arrays.deepToString(result2));
        int[][] result3 = getRectangular(test3);
        System.out.println(Arrays.deepToString(result3));
        int[][] result4 = getRectangular(new int[][]{});
        System.out.println(Arrays.deepToString(result4));

        removeEntry(test2, 2);
        System.out.println(Arrays.deepToString(test2));
        removeEntry(test3, 0);
        System.out.println(Arrays.deepToString(test3));

        System.out.println(isAlternating(seq, 0));
        System.out.println(isAlternating(seq, 1));
        System.out.println(isAlternating(seq, 6));
        System.out.println(isAlternating(seq, 7));

    }

    private static boolean isAlternating(int[] seq, int index) {

        if (index == seq.length-1)
            return true;

        if(!isAlternating(seq, index + 1))
            return false;

        if (seq[index + 1] < 0){
            return (seq[index] > 0);
        }
        else{
            return (seq[index] < 0);
        }

    }

    private static void removeEntry(int[][] input, int col) {
        for (int i = 0; i < input.length; i++) {
            if (input[i].length > col){
                int[] storage = new int[input[i].length - 1];
                int counter = 0;
                for (int j = 0; j < storage.length; j++) {
                    if (j == col){
                        counter++;
                    }
                    storage[j] = input[i][counter];
                    counter++;
                }
                input[i] = new int[input[i].length - 1];
                for (int i1 = 0; i1 < input[i].length; i1++) {
                    input[i][i1] = storage[i1];
                }
            }
        }
    }

    private static int[][] getRectangular(int[][] input) {
        int length = 0;
        for (int[] ints : input) {
            length = Math.max(ints.length, length);
        }
        int[][] returnArray = new int[input.length][length];
        for (int i = 0; i < input.length; i++) {
            int counter = 0;
            for (int i1 = 0; i1 < returnArray[i].length; i1++) {
                if (input[i].length == 0) {
                    returnArray[i][i1] = 0;
                    continue;
                }

                if (counter >= input[i].length)
                    counter = 0;

                returnArray[i][i1] = input[i][counter];

                counter++;
            }
        }
        return returnArray;
    }

}
