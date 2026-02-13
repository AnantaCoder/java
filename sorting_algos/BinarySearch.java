public class BinarySearch {

    void BinarySearch(int arr[], int target) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] == target) {
                System.out.println("Element found at index: " + mid);
                return;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println("Element " + target + " not found in the array");
    }

    public static void main(String[] args) {
        BinarySearch bs = new BinarySearch();
        int[] arr = { 2, 3, 4, 10, 40 };
        int target = 45;
        bs.BinarySearch(arr, target);
    }
}
