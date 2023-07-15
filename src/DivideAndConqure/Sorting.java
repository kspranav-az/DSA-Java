package DivideAndConqure;

public class Sorting {
    public static void PrintArr(int[] arr){
        for (int j : arr) {
            System.out.print(" " + j + " ");
        }
        System.out.println();
    }

    // Merge Sort
    public static void MergeSort(int[] arr, int si , int ei ){
        int mid = si + (ei-si)/2;
        if(si >= ei){
            return;
        }
        MergeSort(arr,si,mid);
        MergeSort(arr,mid+1,ei);
        Merge(arr,si,mid,ei);
    }
    public static void Merge(int[] arr, int si , int mid , int ei){
        int[] temp = new int[ei-si+1];
        int i = si , j = mid+1 , k = 0;

        while (i <= mid && j <= ei){
            if(arr[i] > arr[j]){
                temp[k++] = arr[j++];
            }else{
                temp[k++] = arr[i++];
            }
        }
        while(i<=mid){
            temp[k++] = arr[i++];
        }
        while (j<=ei){
            temp[k++] = arr[j++];
        }

        for( i = si , k = 0 ; k < temp.length ; i++,k++){
            arr[i] = temp[k];
        }
    }

    // Quick Sort

    public static void QuickSort(int arr[] , int si , int ei){

        if(si>=ei){
            return;
        }

        int pvt = partition(arr,si,ei);
        QuickSort(arr, si, pvt-1);
        QuickSort(arr,pvt+1,ei);
    }

    public static int partition(int[] arr , int si , int ei){
        int pvt = arr[ei],i=si-1;
        for(int k = si ; k < ei ; k++){
            if(arr[k] < pvt){
                int temp = arr[k];
                arr[k] = arr[++i];
                arr[i] = temp;
            }
        }
        int temp = arr[ei];
        arr[ei] = arr[++i];
        arr[i] = temp;

        return i;
    }

    public static void main(String args[]){
        int[] arr = {5,2,5,1,8,2,6,9,12,2,1,4};
        QuickSort(arr,0, arr.length-1);
        PrintArr(arr);
    }
}
