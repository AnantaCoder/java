import java.util.Arrays;
import java.util.HashSet;

public class MergeSort {

    // devide and concure techniques . arrays devides into 2 section recursively
    // until mid exists and we get an indivisual element and make this sort all
    // indivisually
    public static void MergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;

        // devide
        MergeSort(arr, left, mid);
        MergeSort(arr, mid + 1, right);

        // merge/concour
        merge(arr, left, mid, right);
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];

        // copy data
        for (int i = 0; i < n1; i++) {
            leftArr[i] = arr[left + i];
        }
        for (int i = 0; i < n2; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0, j = 0, k = left;

        // merger step sortin is done here
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k++] = leftArr[i++];
            } else {
                arr[k++] = rightArr[j++];
            }

        }

        // remaing elements
        while (i < n1) {
            arr[k++] = leftArr[i++];
        }

        while (j < n2) {
            arr[k++] = rightArr[j++];
        }
    }
    public boolean containsDuplicate(int[] nums) {
        //leetcode-217 contains duplicates

        // good (best in terms of complexity) o(logn)
        // Arrays.sort(nums);
        // for(int num:nums){
        //     System.out.println(num+" ");
        // }
        // for(int i=0;i<nums.length-1;i++){
        //     if(nums[i]==nums[i+1]){
        //         return true;
        //     }
            
        // }
        // return false;

        // better O(nlogn)
        HashSet<Integer> set = new HashSet<>();
        for(int num:nums){
            if(set.contains(num)) return true;
            else{
                set.add(num);
            }

        }
        return false;

        
    }


    public static void main(String[] args) {
        int[] arr = new int[] { 45, 154, 52, 4, 52, 122, 445, 7454, 5 };

        // MergeSort(arr, 0, arr.length - 1);
        Arrays.sort(arr);

        for (int num : arr) {
            System.out.print(num + " ");
        }
    }
}
