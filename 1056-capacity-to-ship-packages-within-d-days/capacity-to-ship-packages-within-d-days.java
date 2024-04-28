class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int start = 0,end=0,ans =-1;
        for(int i = 0;i<weights.length;i++){
        start = Math.max(weights[i], start);
        end+=weights[i];
        }
        
        while(start<=end){
            int mid = start+(end-start)/2;
            if(isValid(mid, weights, days)){
                ans = mid;
                end=mid-1;
            }
            else
            start = mid+1;
        }
        return ans;
    }
    public static boolean isValid(int target, int[] arr, int d) {
    int count = 1; // Start with 1 day
    int end = 0;

    for (int i = 0; i < arr.length; i++) {
        end += arr[i];
        if (end > target) { // If the current weight exceeds the target
            count++; // Increment the number of days needed
            end = arr[i]; // Reset the end to the current weight
        }
    }

    return count <= d; // Check if the number of days needed is less than or equal to the given days
}
}