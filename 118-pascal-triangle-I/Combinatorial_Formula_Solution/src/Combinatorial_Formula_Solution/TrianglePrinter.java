package Combinatorial_Formula_Solution;

import java.util.List;

public class TrianglePrinter {
    public static void printTriangle(List<List<Integer>> triangle) {
        for (List<Integer> row : triangle) {
            for (Integer num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
