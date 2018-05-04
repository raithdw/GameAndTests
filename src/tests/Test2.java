package tests;

public class Test2 {
    //Given an array that is sorted, but rotated to the right by an unknown number of times.
    // Find the position of an element.

    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int numb = arr.length;
        int key = 1;
        System.out.println("Index of the element " + key + " is : "
                + elementBinarySearch(arr, numb, key));

    }

    static int elementBinarySearch(int arr[], int numb, int key)
    {
        int pivot = findPivotElement(arr, 0, numb-1);

        if (pivot == -1){
            return binarySearch(arr, 0, numb-1, key);
        }else if (arr[pivot] == key){
            return pivot;
        }else if (arr[0] <= key){
            return binarySearch(arr, 0, pivot-1, key);
        }
        return binarySearch(arr, pivot+1, numb-1, key);
    }

    static int findPivotElement(int arr[], int low, int high)
    {
        if (high < low){
            return -1;
        }else  if (high == low){
            return low;
        }

        int mid = (low + high)/2;

        if (mid < high && arr[mid] > arr[mid + 1]){
            return mid;
        }else if (mid > low && arr[mid] < arr[mid - 1]){
            return (mid-1);
        }else if (arr[low] >= arr[mid]){
            return findPivotElement(arr, low, mid-1);
        }
        return findPivotElement(arr, mid + 1, high);

    }

    static int binarySearch(int arr[], int low, int high, int key)
    {
        if (high < low){
            return -1;
        }

        int mid = (low + high)/2;

        if (key == arr[mid]){
            return mid;
        }else if (key > arr[mid]){
            return binarySearch(arr, (mid + 1), high, key);
        }
        return binarySearch(arr, low, (mid -1), key);
    }

}
