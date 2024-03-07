package K3;

import java.util.Arrays;

public class K3_5 {

    public static void main(String[] args) {
        int[][] test1 = {{0,2,4},{2,0,0},{0,0,1}};
        int[][] test2 = {{1,2,3},{1,2,3,4,5},{1,2,3},{1,2,3,4,5}};
        int[][] test3 = {{2},{0,7},{6,7,8},{6,0},{0,0}};
        String seq1 = "ABA";

        int[][] result1 = removeLeadingZeroes(test1);
        System.out.println(Arrays.deepToString(result1));
        int[][] result2 = removeLeadingZeroes(test3);
        System.out.println(Arrays.deepToString(result2));

        mask(test2, new int[]{1,2,3}, new int[]{0,1,4});
        System.out.println(Arrays.deepToString(test2));

        mask(test3, new int[]{0,2,4}, new int[]{0,1});
        System.out.println(Arrays.deepToString(test3));

        mask(test1, new int[]{}, new int[]{0,1});
        System.out.println(Arrays.deepToString(test1));

        System.out.println(replicateCharacter(seq1, "010"));
        System.out.println(replicateCharacter("SAMBA", "10001"));
    }

    private static String replicateCharacter(String sequence, String repSequence) {

        if (sequence.isEmpty())
            return "";

        if (repSequence.charAt(0) == '1')
            return sequence.substring(0,1)
                    + sequence.substring(0,1)
                    + replicateCharacter(sequence.substring(1), repSequence.substring(1));
        else
            return sequence.substring(0,1)
                    + replicateCharacter(sequence.substring(1), repSequence.substring(1));

    }

    private static void mask(int[][] inputArray, int[] rows, int[] cols) {
        for (int row : rows) {
            for (int col : cols) {
                if (row < inputArray.length && col < inputArray[row].length) {
                    inputArray[row][col] = 0;
                }
            }

        }
    }

    private static int[][] removeLeadingZeroes(int[][] inputArray) {

        int[][] returnArray = new int[inputArray.length][];
        int leadingZeros;
        for (int i = 0; i < inputArray.length; i++) {
            leadingZeros = 0;

            for (int j : inputArray[i]) {
                if (j == 0){
                    leadingZeros++;
                }
                else{
                    break;
                }
            }
            returnArray[i] = new int[inputArray[i].length - leadingZeros];
            for (int j = leadingZeros; j < inputArray[i].length; j++) {
                returnArray[i][j-leadingZeros] = inputArray[i][j];
            }
        }

        return returnArray;

    }


}
