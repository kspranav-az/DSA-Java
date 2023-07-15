package DivideAndConqure;

public class Search {
    
    public static int SearchSortedRotated(int arr[] ,int target , int si , int ei){
        int mid = si +(ei-si)/2;
        
        if(arr[mid]==target){
            return mid;
        }
        if(arr[si] <= arr[mid]){
            if(arr[si] <= target && target <  arr[mid]){
                return SearchSortedRotated(arr,target,si,mid-1);
            }else{
                return SearchSortedRotated(arr,target,mid+1,ei);
            }
        }else {
            if(arr[mid] < target && target <= arr[ei]){
                return SearchSortedRotated(arr,target,mid+1,ei);
            }else{
                return SearchSortedRotated(arr,target,si,mid-1);
            }
        }
    }
    
    public static void main(String args[]){
        int arr[] = {4,5,6,7,0,1,2,3};
        int tar = 2;
        int TIdx = SearchSortedRotated(arr,tar,0,arr.length-1);
        System.out.println(TIdx);
    }
}
