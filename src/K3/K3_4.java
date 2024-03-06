package K3;

import java.util.Arrays;

public class K3_4 {

    public static void main(String[] args) {
        int[][] test1 = {{5,2,4},{8,5,4},{9,6,8,7}};
        int[][] test2 = {{0,1,2},{0,1,2},{0,1,2}};
        int[][] test3 = {{6},{2,4},{2,4},{2,4},{4,2}};
        int[] seq1 = {4,3,2,1,10,5,5,5};

        int[][] result1 = rearrange(test1);
        System.out.println(Arrays.deepToString(result1));
        int[][] result2 = rearrange(test3);
        System.out.println(Arrays.deepToString(result2));
        System.out.println(Arrays.deepToString(rearrange(new int[][] {{}})));



        label(test1);
        label(test2);
        label(test3);
        System.out.println(Arrays.deepToString(test1));
        System.out.println(Arrays.deepToString(test2));
        System.out.println(Arrays.deepToString(test3));


        System.out.println(findMaxOppositeSum(seq1, 0, 7));
        System.out.println(findMaxOppositeSum(seq1, 0, 5));
        System.out.println(findMaxOppositeSum(seq1, 4, 7));
    }

    private static int findMaxOppositeSum(int[] sequence, int start, int end) {

        if(start + 1 == end){
            return sequence[start] + sequence[end];
        }
        int lastMax = findMaxOppositeSum(sequence, start+1, end-1);
        int thisMax = sequence[start] + sequence[end];

        return Math.max(lastMax, thisMax);

    }

    private static void label(int[][] inputArray) {

        for (int i = 0; i < inputArray.length - 1; i++) {

            if (inputArray[i].length == inputArray[i+1].length){
                int counter = 0;
                for (int j = 0; j < inputArray[i].length; j++) {
                    if (inputArray[i][j] == inputArray[i+1][j]){
                        counter++;
                    }
                }
                if (counter == inputArray[i].length){
                    for (int j = 0; j < inputArray[i].length; j++) {
                        inputArray[i][j] = -9;
                    }
                }

            }

        }

    }

    private static int[][] rearrange(int[][] inputArray) {

        int inputFields = 0;

        for (int[] i : inputArray){
            inputFields += i.length;
        }

        int round = (4 - inputFields % 4);
        if (round != 4){
            inputFields += round;
        }

        int length = inputFields / 4;

        int[][] returnArray = new int[length][4];
        int x = 0;
        int y = 0;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < 4; j++) {
                if (x<inputArray.length){
                    returnArray[i][j] = inputArray[x][y];
                    y++;

                    if (y >= inputArray[x].length){
                        y = 0;
                        x++;
                    }
                }
                else{
                    returnArray[i][j] = 0;
                }
            }
        }

        return returnArray;

    }

}
