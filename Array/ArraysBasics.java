package Array;

import java.util.Scanner;

public class ArraysBasics {
    // since all are utility/helpers we can use the static keyword here since they
    // are indipendant , dont rely on object data.
    public static int secondLargest(int[] arr) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        //  we can take 0's but it will fail for the negative numbers array
        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num != largest) {
                secondLargest = num;
            }
        }
        return secondLargest;
    }

    public void transposeMatrix() {
        // basically row and columns are in a interchanging position of a dimentional
        // array.
        Scanner sc = new Scanner(System.in);
        System.out.println("enter rows ");
        int rows = sc.nextInt();
        System.out.println("enter columns ");
        int cols = sc.nextInt();

        int[][] matrix = new int[rows][cols];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("the ekemen");
                matrix[i][j] = sc.nextInt();
            }
        }

        System.out.println("Thransposed matrix :----------------");
        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                System.out.print(matrix[j][i] + " ");
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        ArraysBasics obj = new ArraysBasics();
        int[] arr = { 10, 25, 8, 30, 15 };
        System.out.println("Second Largest: " + obj.secondLargest(arr));

        // obj.transposeMatrix();
    }
}