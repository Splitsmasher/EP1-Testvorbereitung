package K3;

import java.util.Arrays;

public class K3_2 {

    public static void main(String[] args) {
        int[][] test1 = { {1,2,0,-1,-2,3},{-1,2,3},{0,0},{},{4,5,-1} };
        int[][] test2 = { {1,2,3},{4,5,2},{-2,-3,2,-1},{3,2,1,5},{4,5,1,4} };
        int[][] test3 = { {1,-1,2,-2,3},{1,2,3},{-3,-1,-2} };
        char[] age1 = {'d','u','-','d','u','-','d','a','-','d','a'};
        char[] age2 = {'m','a','m','a','!','n','e','i','n'};
        
        int[][] result1 = generate(test1);
        System.out.println(Arrays.deepToString(result1));

        int[][] result2 = generate(test2);
        System.out.println(Arrays.deepToString(result2));

        //Start fill

        fill(test1, test2[3], test2[4]);
        System.out.println(Arrays.deepToString(test1));

        fill(result1, test2[2], test2[4]);
        System.out.println(Arrays.deepToString(result1));

        fill(test3, test2[2], test2[3]);
        System.out.println(Arrays.deepToString(test3));

        //Start extractString
        System.out.println(extractString(age1,0,age1.length,'-'));
        System.out.println(extractString(age1,1,7,'u'));
        System.out.println(extractString(age2,0,5,'a'));
        System.out.println(extractString(age2,5,age2.length,'n'));


    }

    private static String extractString(char[] sequence, int start, int end, char omit) {

        if (start == end - 1){
            if (sequence[start] != omit){
                return "" + sequence[start];
            }
            else{
                return "";
            }
        }
        else {
            if (sequence[start] != omit){
                return sequence[start] + extractString(sequence, start + 1, end, omit);
            }
            else{
                return "" + extractString(sequence, start + 1, end, omit);
            }
        }
    }

    private static void fill(int[][] target, int[] values, int[] times) {

        int x = 0;
        int y = 0;

        int valuesIndex = 0;
        for(int i : times){
            for (int j = 0; j < i; j++) {
                if (x >= target[y].length){
                    y++;
                    while (target[y].length < 1){
                        y++;
                    }
                    x = 0;
                }
                target[y][x] = values[valuesIndex];
                x++;
            }
            valuesIndex++;
        }

    }

    private static int[][] generate(int[][] input) {

        int[][] returnArray = new int[input.length][];
        int counterNegative;
        int counterPositive;


        for (int index = 0; index < input.length; index++) {
            counterNegative = 0;
            counterPositive = 0;
            returnArray[index] = new int[input[index].length];
            int[] storage = new int[input[index].length];
            for (int i : input[index]){
                if (i < 0){
                    storage[counterNegative] = i;
                    counterNegative++;
                }
            }
            for (int i = 0; i < counterNegative; i++) {
                returnArray[index][i] = storage[i];
            }
            for (int i : input[index]){
                if (i >= 0){
                    storage[counterPositive] = i;
                    counterPositive++;
                }
            }
            //counterNegative -= 1;
            for (int i = 0; i < counterPositive; i++) {
                returnArray[index][i + counterNegative] = storage[i];
            }
        }

        return returnArray;

    }

}
