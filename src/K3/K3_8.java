package K3;

import java.util.Arrays;

public class K3_8 {
    public static void main(String[] args) {
        int[][] test1 = {{1}, {1,2,3}, {1,2,3,4}, {1,2}};
        int[][] test2 = {{1,2,3}, {0}, {1,2}, {0},{1}};
        int[] seq = {2,8,8,5,2,5,7,3};

        var result1 = repeat(test1, new int[]{1,-2,1,0});
        System.out.println(Arrays.deepToString(result1));
        var result2 = repeat(test2, new int[]{1,0,-3,2,0});
        System.out.println(Arrays.deepToString(result2));

        rasp(test1);
        System.out.println(Arrays.deepToString(test1));
        rasp(test2);
        System.out.println(Arrays.deepToString(test2));

        System.out.println(hasNOrderedPairs(seq,4,0));
        System.out.println(hasNOrderedPairs(seq,2,2));
        System.out.println(hasNOrderedPairs(seq,1,3));
        System.out.println(hasNOrderedPairs(seq,3,3));
        System.out.println(hasNOrderedPairs(seq,0,6));
    }

    private static boolean hasNOrderedPairs(int[] seq, int n, int index) {

        if(index + 1 == seq.length - 1){
            if (n > 1 || n < 0) {
                return false;
            } else if (n == 0) {
                return seq[index] >= seq[index + 1];
            } else{
                return seq[index] <= seq[index + 1];
            }
        }


        if (seq[index] <= seq [index + 1]){
            return hasNOrderedPairs(seq, n - 1, index + 1);
        }
        else{
            return hasNOrderedPairs(seq, n, index + 1);
        }

    }

    private static void rasp(int[][] input) {

        for (int i = 0; i < input.length - 1; i+=2) {

            int[] storage = new int[input[i].length - 1];
            int nextLine = input[i][input[i].length - 1];

            for (int j = 0; j < storage.length; j++) {
                storage[j] = input[i][j];
            }
            input[i] = new int[storage.length];
            for (int j = 0; j < storage.length; j++) {
                input[i][j] = storage[j];
            }

            storage = new int[input[i + 1].length];
            for (int j = 0; j < storage.length; j++) {
                storage[j] = input[i + 1][j];
            }
            input[i + 1] = new int[storage.length + 1];
            for (int j = 0; j < storage.length; j++) {
                input[i + 1][j] = storage[j];
            }
            input[i + 1][input[i + 1].length - 1] = nextLine;

        }

    }

    private static int[][] repeat(int[][] input, int[] reps) {

        int[][] returnArray = new int[input.length][];

        for (int i = 0; i < reps.length; i++) {
            if (reps[i] >= 0){
                returnArray[i] = new int[input[i].length * (reps[i] + 1)];
                int inputJ = 0;
                for (int j = 0; j < returnArray[i].length; j++) {
                    if (inputJ >= input[i].length){
                        inputJ = 0;
                    }
                    returnArray[i][j] = input[i][inputJ];
                    inputJ++;
                }
            }
            else{
                returnArray[i] = new int[input[i].length * (reps[i] * -1 + 1)];
                int inputJ = 0;
                for (int j = returnArray[i].length - 1; j >= 0 ; j--) {
                    if (inputJ >= input[i].length){
                        inputJ = 0;
                    }
                    returnArray[i][j] = input[i][inputJ];
                    inputJ++;
                }
            }
        }
        return returnArray;
    }
}
