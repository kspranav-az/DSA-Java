package DivideAndConqure;

public class Qs {
    // Majority element in an Array

    public static int CountElement(int arr[],int num,int si,int ei){
        if(si>ei){
            return 0;
        }
        return (arr[si]==num?1:0) + CountElement(arr, num, si + 1, ei);
    }

    public static int Majority(int arr[],int si,int ei){
        if(si>=ei){
            return arr[ei];
        }
        int mid = si + (ei-si)/2;

        int left = Majority(arr,si,mid);
        int right = Majority(arr,mid+1,ei);
        if(left==right){
            return left;
        }
        int left_count = CountElement(arr,left,si,mid);
        int right_count = CountElement(arr,right,mid+1,ei);

        return left_count > right_count ? left : right ;
    }

    public static void main(String args[]){
        int arr[] = {1,2,3,2,2,6,3,2,6};
        System.out.println(Majority(arr,0,arr.length-1));
    }
}
