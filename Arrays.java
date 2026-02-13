
import java.util.ArrayList;
import java.util.List;

public class Arrays {

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        String first = strs[0];
        for (int i = 0; i < first.length(); i++) {
            char ch = first.charAt(i);
            // System.out.println(ch);

            for (int j = 1; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }

    public int BinarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        System.out.println("High value is " + nums[nums.length - 1]);
        System.out.println("Low value is " + nums[0]);

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target == nums[mid])
                return nums[mid];
            if (target > nums[mid])
                high = mid - 1;
            if (target < nums[mid])
                low = mid + 1;
        }
        return -1;
    }

    public int[] searchRange(int[] nums, int target) {

        int first = -1;
        int last = -1;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                first = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                last = i;
                break;
            }
        }

        return new int[] { first, last };
    }

    public int findMinInRotatedSortedArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] <= nums[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return nums[left];
    }

    public boolean isRotated(int[] nums) {
        int drops = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1]) {
                drops++;
            }
            if (drops > 1)
                return false;
        }
        if (nums[nums.length - 1] > nums[0])
            drops++;

        return drops == 1;
    }

    public void setZeroes(int[][] matrix) {

        int numRows = matrix.length;
        int numColumns = matrix[0].length;

        boolean[] rows = new boolean[numRows];
        boolean[] columns = new boolean[numColumns];

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (matrix[i][j] == 0) { // this is the exact location of the zero
                    rows[i] = true;
                    columns[j] = true;
                }
            }
        }
        // set zeors to the rows and columns
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numColumns; j++) {
                if (rows[i] || columns[j]) {
                    matrix[i][j] = 0;
                }
            }
        }

    }

    public List<Integer> spiralOrder(int[][] matrix) {
    int numRows = matrix.length;
    int numColumns = matrix[0].length;
int top = 0;
int bottom = numRows -1 ;
int left = 0;
int right = numColumns-1;
    System.out.print("the number of rows is " + numRows + " and the number of columns is " + numColumns + "\n");
    ArrayList<Integer> list = new ArrayList<>();
        while(left<= right && top<=bottom){
            for (int i = left; i <= right; i++) {
                list.add(matrix[top][i]);
            }
            top ++;
            for (int i = top; i <= bottom; i++) {
                list.add(matrix[i][right]);
            }
            right --;
            if (top <= bottom) {
            for (int j = right; j >= left; j--) {
                list.add(matrix[bottom][j]);
            }
            bottom--;
            }

        if (left <= right) {
            for (int i = bottom; i >= top; i--) {
                list.add(matrix[i][left]);
            }
            left++;
            }
        }

    // // now i wanna print the top->right->bottom->left collom 
    //     System.out.print("first row "+matrix[0][0] +","+matrix[0][1]+","+matrix[0][2]+"\n");
    //     System.out.print("first right col  "+matrix[0][2] +","+matrix[1][2]+","+matrix[2][2]+"\n");
    //     System.out.print("bottom "+matrix[2][0] +","+matrix[2][1]+","+matrix[2][2]+"\n");
    //     System.out.print("left column  "+matrix[0][2] +","+matrix[1][1]+","+matrix[2][0]+"\n");




    return list;
    }

    
    public static void main(String[] args) {
        Arrays arr = new Arrays();

        int[][] matrix = { { 1, 2, 3 },{4,5,6},{7,8,9}};
        List<Integer> result = arr.spiralOrder(matrix);
        System.out.println("Normal order: " + result);

    }
}
