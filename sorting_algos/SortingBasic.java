/**
 * SortingBasic.java
 *
 * Covers three fundamental O(n²) sorting algorithms:
 * - Selection Sort
 * - Bubble Sort
 * - Insertion Sort
 *
 * Each algorithm sorts an integer array IN-PLACE (modifies the original array).
 *
 * Time Complexity Summary:
 * ┌─────────────────┬────────────┬────────────┬────────────┬──────────┐
 * │ Algorithm │ Best │ Average │ Worst │ Space │
 * ├─────────────────┼────────────┼────────────┼────────────┼──────────┤
 * │ Selection Sort │ O(n²) │ O(n²) │ O(n²) │ O(1) │
 * │ Bubble Sort │ O(n) │ O(n²) │ O(n²) │ O(1) │
 * │ Insertion Sort │ O(n) │ O(n²) │ O(n²) │ O(1) │
 * └─────────────────┴────────────┴────────────┴────────────┴──────────┘
 *
 * Best use cases:
 * - Small datasets (n < ~1000)
 * - Nearly sorted data → prefer Bubble or Insertion Sort
 * - Learning/teaching sorting fundamentals
 */
public class SortingBasic {

    /**
     * swap() — Helper utility
     *
     * Swaps two elements in an array at indices a and b.
     * Used internally by selection sort and bubble sort.
     *
     * @param arr the array containing elements to swap
     * @param a   index of the first element
     * @param b   index of the second element
     *
     *            Example:
     *            arr = [3, 7, 1] → swap(arr, 0, 2) → arr = [1, 7, 3]
     */
    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    /**
     * selectionSort() — Selection Sort
     *
     * Idea: On each pass, find the MINIMUM element in the unsorted portion
     * and move it to its correct position at the front.
     *
     * How it works:
     * Pass 1: scan entire array → place smallest at index 0
     * Pass 2: scan from index 1 → place 2nd smallest at index 1
     * ...and so on until sorted.
     *
     * Time: O(n²) always — always does n*(n-1)/2 comparisons regardless of input
     * Space: O(1) — in-place, no extra memory
     * Stable: NO — equal elements may change relative order
     *
     * Good for: minimizing the number of swaps (only n-1 swaps total)
     *
     * @param arr integer array to sort (sorted in ascending order in-place)
     *
     *            Example:
     *            Input: [64, 25, 12, 22, 11]
     *            Pass 1: min=11 → swap with 64 → [11, 25, 12, 22, 64]
     *            Pass 2: min=12 → swap with 25 → [11, 12, 25, 22, 64]
     *            Pass 3: min=22 → swap with 25 → [11, 12, 22, 25, 64]
     *            Pass 4: min=25 → no swap → [11, 12, 22, 25, 64]
     *            Output: [11, 12, 22, 25, 64]
     */
    private static void selectionSort(int[] arr) {
        // Outer loop: i is the boundary between sorted (left) and unsorted (right)
        for (int i = 0; i < arr.length - 1; i++) {
            int minin = i; // Assume current position holds the minimum

            // Inner loop: find the actual minimum in the unsorted portion
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minin])
                    minin = j; // Update min index if smaller found
            }

            // Place the found minimum at the correct sorted position
            swap(arr, i, minin);
        }
    }

    /**
     * bubbleSort() — Bubble Sort
     *
     * Idea: Repeatedly compare adjacent elements and swap them if they're in
     * the wrong order. Larger elements "bubble up" to the end each pass.
     *
     * How it works:
     * Pass 1: bubbles the largest element to the last position
     * Pass 2: bubbles the 2nd largest to the 2nd last position
     * ...early-exit optimization: if no swaps happened, array is already sorted.
     *
     * Time: O(n) best (already sorted), O(n²) average/worst
     * Space: O(1) — in-place
     * Stable: YES — equal elements preserve relative order
     *
     * Good for: detecting nearly sorted arrays quickly (early exit)
     *
     * @param arr integer array to sort (sorted in ascending order in-place)
     *
     *            Example:
     *            Input: [5, 3, 8, 4, 2]
     *            Pass 1: [3, 5, 4, 2, 8] ← 8 bubbled to end
     *            Pass 2: [3, 4, 2, 5, 8] ← 5 in place
     *            Pass 3: [3, 2, 4, 5, 8]
     *            Pass 4: [2, 3, 4, 5, 8]
     *            Output: [2, 3, 4, 5, 8]
     */
    private static void bubbleSort(int[] arr) {
        // After each outer pass, the last i elements are in their final position
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false; // Optimization flag: track if any swap occurred

            // Compare adjacent pairs in the unsorted region
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    swapped = true;
                }
            }

            // Early exit: if no swaps occurred this pass, array is already sorted
            if (!swapped)
                break;
        }
    }

    /**
     * insertionSort() — Insertion Sort
     *
     * Idea: Build the sorted array one element at a time, like sorting playing
     * cards.
     * For each new element, insert it into the correct position in the
     * already-sorted portion to the left.
     *
     * How it works:
     * Start with index 1 (single element is trivially sorted).
     * Pick the current element (key) and shift all larger sorted elements
     * one position right to make room, then insert the key.
     *
     * Time: O(n) best (already sorted), O(n²) average/worst
     * Space: O(1) — in-place
     * Stable: YES — equal elements preserve relative order
     *
     * Good for: small arrays, nearly sorted data, online sorting (stream of data)
     * also used as a subroutine in TimSort (Java's Arrays.sort)
     *
     * @param arr integer array to sort (sorted in ascending order in-place)
     *
     *            Example:
     *            Input: [12, 11, 13, 5, 6]
     *            i=1: key=11 → shift 12 right → [11, 12, 13, 5, 6]
     *            i=2: key=13 → no shift needed → [11, 12, 13, 5, 6]
     *            i=3: key=5 → shift 13,12,11 right → [5, 11, 12, 13, 6]
     *            i=4: key=6 → shift 13,12,11 right → [5, 6, 11, 12, 13]
     *            Output: [5, 6, 11, 12, 13]
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;

        // Start from index 1; element at index 0 is trivially "sorted"
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // The element to be inserted into sorted portion
            int j = i - 1; // Start comparing from the last element of sorted portion

            // Shift elements of the sorted portion that are greater than key, one position
            // ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j]; // Shift right
                j--;
            }

            // Insert key at its correct sorted position
            arr[j + 1] = key;
        }
    }

    // ─────────────────────────────────────────────
    // Helper: print array contents to console
    // ─────────────────────────────────────────────
    private static void printArray(int[] arr, String label) {
        System.out.print(label + ": ");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    /**
     * main() — Demo all three sorting algorithms with different test cases.
     *
     * Test cases covered:
     * 1. Random unsorted array → tests general case
     * 2. Already sorted array → tests best-case (Bubble/Insertion exit early)
     * 3. Reverse sorted array → tests worst case
     * 4. Array with duplicates → tests stability behavior
     * 5. Single element array → edge case
     */
    public static void main(String[] args) {

        // ── Test Case 1: General unsorted array ──────────────────────────────
        System.out.println("=== Selection Sort ===");
        int[] arr1 = { 64, 25, 12, 22, 11 };
        printArray(arr1, "Before");
        selectionSort(arr1);
        printArray(arr1, "After ");
        // Expected: 11 12 22 25 64

        System.out.println();

        // ── Test Case 2: Already sorted array (bubble sort early exit) ───────
        System.out.println("=== Bubble Sort (already sorted — best case O(n)) ===");
        int[] arr2 = { 1, 2, 3, 4, 5 };
        printArray(arr2, "Before");
        bubbleSort(arr2);
        printArray(arr2, "After ");
        // Expected: 1 2 3 4 5 (only 1 pass needed, exits early)

        System.out.println();

        // ── Test Case 3: Reverse sorted array (worst case) ───────────────────
        System.out.println("=== Bubble Sort (reverse sorted — worst case O(n²)) ===");
        int[] arr3 = { 5, 4, 3, 2, 1 };
        printArray(arr3, "Before");
        bubbleSort(arr3);
        printArray(arr3, "After ");
        // Expected: 1 2 3 4 5

        System.out.println();

        // ── Test Case 4: Insertion sort with nearly sorted array ─────────────
        System.out.println("=== Insertion Sort (nearly sorted — close to O(n)) ===");
        int[] arr4 = { 1, 2, 4, 3, 5 }; // Only one pair out of order
        printArray(arr4, "Before");
        insertionSort(arr4);
        printArray(arr4, "After ");
        // Expected: 1 2 3 4 5

        System.out.println();

        // ── Test Case 5: Array with duplicate values ──────────────────────────
        System.out.println("=== Insertion Sort (with duplicates) ===");
        int[] arr5 = { 4, 2, 4, 1, 3, 2 };
        printArray(arr5, "Before");
        insertionSort(arr5);
        printArray(arr5, "After ");
        // Expected: 1 2 2 3 4 4

        System.out.println();

        // ── Test Case 6: Single element (edge case) ───────────────────────────
        System.out.println("=== Selection Sort (single element — edge case) ===");
        int[] arr6 = { 42 };
        printArray(arr6, "Before");
        selectionSort(arr6);
        printArray(arr6, "After ");
        // Expected: 42
    }
}
