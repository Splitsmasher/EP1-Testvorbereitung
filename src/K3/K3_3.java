package K3;

import java.util.Arrays;

public class K3_3 {

    public static void main(String[] args) {
        int[][] data0 = {{3,0},{0,1},{2,2}};
        int[][] data1 = {{0,1,0,0,1,0},{},{2,2,2,2,0,1}};
        int[] target1 = {0,0,0};
        int[] target2 = {9,9,9,9};

        System.out.println(Arrays.deepToString(labelPath(3, new int[][] {})));
        System.out.println(Arrays.deepToString(labelPath(4, data0)));

        findMatches(data0, data0[1], target1);
        System.out.println(Arrays.toString(target1));
        findMatches(data1, data0[1], target1);
        System.out.println(Arrays.toString(target1));
        findMatches(data1, data0[2], target2);
        System.out.println(Arrays.toString(target2));

        System.out.println(insertMiddle("XY", "abc"));
        System.out.println(insertMiddle("01234", "abc"));
        System.out.println(insertMiddle("01234567890123", "./-"));

    }

    private static String insertMiddle(String input, String seps) {


        if (input.length() < 2 || seps.isEmpty()){
            return input;
        } else if (input.length() == 2) {
            return input.substring(0,1) + seps.charAt(0) + input.substring(1);
        }


        int middle;
        if (input.length() % 2 == 0){
            middle = input.length() / 2;
        }
        else{
            middle = (input.length() - 1) / 2;
        }

        String left = insertMiddle(input.substring(0, middle), seps.substring(1));
        String right = insertMiddle(input.substring(middle), seps.substring(1));

        return left + seps.charAt(0) + right;

    }

    private static void findMatches(int[][] data, int[] pattern, int[] target) {

        int returnCounter;
        int patternCounter;

        for (int i = 0; i < data.length; i++) {
            returnCounter = 0;
            for (int j = 0; j < data[i].length - pattern.length + 1; j++) {
                patternCounter = 0;
                for (int k = 0; k < pattern.length; k++) {
                    if (data[i][j+k] == pattern[k]){
                        patternCounter++;
                    }
                }
                if (patternCounter == pattern.length) {
                    returnCounter++;
                }
            }
            target[i] = returnCounter;
        }

    }

    private static int[][] labelPath(int n, int[][] points) {
        int[][] returnArray = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                returnArray[i][j] = n;
            }
        }

        for(int[] point : points){
            returnArray[point[0]][point[1]] = -1;
        }

        return returnArray;
    }

}
