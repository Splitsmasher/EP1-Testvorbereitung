package K3;

import java.util.Arrays;

public class K3_9 {
    public static void main(String[] args) {
        int[] test1 = {3,0,6,-1,1};
        int[][] test2 = {{0}, {6,-5}, {0,0},{0,1,2,0}};
        int[][] test3 = {{1,2,7,3,0}, {-8}, {0,2},{1,4,-2,1}};

        boolean[][] result1 = create(new int[]{3});
        System.out.println(Arrays.deepToString(result1));
        boolean[][] result2 = create(new int[]{-2,0});
        System.out.println(Arrays.deepToString(result2));
        boolean[][] result3 = create(new int[]{});
        System.out.println(Arrays.deepToString(result3));

        move(test2);
        System.out.println(Arrays.deepToString(test2));
        move(test3);
        System.out.println(Arrays.deepToString(test3));

        System.out.println(oddOccurences("This is not a test!", 's'));
        System.out.println(oddOccurences("This is not a test!", 'T'));
        System.out.println(oddOccurences("This is not a test!", 't'));
        System.out.println(oddOccurences("This is not a test!", ' '));
        System.out.println(oddOccurences("", 'x'));

    }

    private static boolean oddOccurences(String s, char ch) {

        if (s.isEmpty())
            return false;

        if(oddOccurences(s.substring(1), ch)){
            return s.charAt(0) != ch;
        }
        else{
            return s.charAt(0) == ch;
        }

    }

    private static void move(int[][] input) {

        for (int i = 0; i < input.length; i++) {
            if (input[i][input[i].length - 1] == 0){
                for (int j = input[i].length - 1; j > 0; j--) {
                    input[i][j] = input[i][j - 1];
                }
                input[i][0] = 0;
            }
            else{
                int[] storage = new int[input[i].length];

                for (int j = 0; j < input[i].length; j++) {
                    storage[j] = input[i][j];
                }
                input[i] = new int[storage.length + 1];
                for (int j = 0; j < storage.length; j++) {
                    input[i][j + 1] = storage[j];
                }
            }
        }
    }

    private static boolean[][] create(int[] input) {
        boolean[][] returnArray = new boolean[input.length][];

        for (int i = 0; i < input.length; i++) {
            if (input[i] > 2){
                returnArray[i] = new boolean[input[i] + 1];
            }
            else {
                returnArray[i] = new boolean[3];
            }
            if (input[i] >= 0)
                returnArray[i][input[i]] = true;
        }
        return returnArray;
    }
}
