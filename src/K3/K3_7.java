package K3;

import java.util.Arrays;

public class K3_7 {

    public static void main(String[] args) {
        int[][] test1 = {{5,7,5,7},{5},{0,1,1,0}};
        int[][] test2 = {{5,7,9},{5},{8,5},{2},{3}};
        int[][] test3 = {{1,2},{1,2,3},{}};
        String seq = "1(234)67";

        int[][] result1 = addTriangle(test1);
        System.out.println(Arrays.deepToString(result1));
        int[][] result2 = addTriangle(test2);
        System.out.println(Arrays.deepToString(result2));

        reverseBetween(test1, 2, 1);
        System.out.println(Arrays.deepToString(test1));
        reverseBetween(test2, 1, 4);
        System.out.println(Arrays.deepToString(test2));
        reverseBetween(test3, 2, 2);
        System.out.println(Arrays.deepToString(test3));
        reverseBetween(test3, 0, 2);
        System.out.println(Arrays.deepToString(test3));

        System.out.println(clean(seq));
        System.out.println(clean("123(45))"));
        System.out.println(clean("x)"));
        System.out.println(clean(")x("));

    }

    private static String clean(String seq) {

        if (seq.length() < 3)
            return "";

        if (seq.charAt(0) == '(' && seq.charAt(seq.length() - 1) == ')'){
            return seq.substring(1, seq.length()-1);
        }
        else {
            if(seq.charAt(0) != '(' && seq.charAt(seq.length() - 1) == ')'){
                return clean(seq.substring(1));
            } else if (seq.charAt(0) == '(' && seq.charAt(seq.length() - 1) != ')') {
                return clean(seq.substring(0, seq.length() - 1));
            }
            else{
                return clean(seq.substring(1, seq.length() - 1));
            }
        }

    }

    private static void reverseBetween(int[][] input, int ind1, int ind2) {

        int start = Math.min(ind1, ind2);
        int end = Math.max(ind1, ind2);

        if(start == end)
            return;

        int[] storage;

        while (start <= end){

            storage = new int[input[start].length];
            for (int i = 0; i < input[start].length; i++) {
                storage[i] = input[start][i];
            }
            input[start] = new int[input[end].length];
            for (int i = 0; i < input[end].length; i++) {
                input[start][i] = input[end][i];
            }
            input[end] = new int[storage.length];
            for (int i = 0; i < storage.length; i++) {
                input[end][i] = storage[i];
            }

            start++;
            end--;
        }
    }

    private static int[][] addTriangle(int[][] input) {

        int[][] returnArray = new int[input[0].length + input.length][];

        for (int i = 0; i < input[0].length; i++) {
            returnArray[i] = new int[i + 1];
            for (int i1 = 0; i1 < returnArray[i].length; i1++) {
                returnArray[i][i1] = i + 1;
            }
        }
        for (int i = 0; i < input.length; i++) {
            returnArray[i + input[0].length] = new int[input[i].length];
            for (int j = 0; j < input[i].length; j++) {
                returnArray[i+input[0].length][j] = input[i][j];
            }
        }

        return returnArray;
    }


}
