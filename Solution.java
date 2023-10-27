import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int rowIndex = 1;
        System.out.println("Pascal's Triangle of "+ rowIndex+ " is: "+sol.getRowV1(rowIndex));
    }
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> triangle = new ArrayList<>();


        List<Integer> firstRow = new ArrayList<>();
        firstRow.add(1);
        triangle.add(firstRow);
        if (rowIndex == 0) {
            return firstRow;
        }
        for (int rowNum = 1; rowNum <= rowIndex; rowNum++) {
            List<Integer> previousRow = triangle.get(rowNum - 1);
            List<Integer> currentRow = new ArrayList<>();

            // First element of the row is always 1
            currentRow.add(1);

            for (int j = 1; j < rowNum; j++) {
                currentRow.add(previousRow.get(j - 1) + previousRow.get(j));
            }

            // Last element of the row is always 1
            currentRow.add(1);
            triangle.add(currentRow);
        }
        System.out.println("Triangle = " + triangle);
        return triangle.get(rowIndex);
    }
    public List<Integer> getRowV1(int rowIndex){
        List<Integer> row = new ArrayList<>();
        row.add(1);
        int num = 0;
        for(int i = 1; i <= rowIndex; i++){
            num = (int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i);
            row.add(num);
        }
        return row;
    }
}
