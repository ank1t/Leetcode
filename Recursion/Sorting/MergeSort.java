import java.util.*;

class MergeSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1,77,5,5,44,33,22,11,0,100};
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        divide(arr, 0, arr.length - 1);
    }

    private static void divide(int[] arr, int low, int high) {
        if(low >= high) { return; }

        int mid = (low + high)/2;
        divide(arr, low, mid);
        divide(arr, mid + 1, high);

        merge(arr, low, mid, high);
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> temp = new ArrayList<Integer>();

        int l = low;
        int r = mid + 1;
        while(l <= mid && r <= high) {
            if(arr[l] <= arr[r]) {
                temp.add(arr[l]);
                l++;
            } else {
                temp.add(arr[r]);
                r++;
            }
        }
        while(l <= mid) {
            temp.add(arr[l]);
            l++;
        }

        while(r <= high) {
            temp.add(arr[r]);
            r++;
        }
        for(int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }
}