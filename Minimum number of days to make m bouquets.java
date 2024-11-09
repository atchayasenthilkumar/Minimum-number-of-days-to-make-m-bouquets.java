class Solution 
{
    boolean helper(int[] arr , int day, int m , int k){
        int count=0;
        int ans = 0;
        for(int i=0;i<arr.length;i++)
        {
            if(arr[i]<=day)
            count++;
            else
            {
               ans += count/k;
               count=0;
            }
        }
        ans += count/k;
        if(ans>=m)
        return true;
        return false;
    }
    public int minDays(int[] bloomDay, int m, int k) 
    {
        if(m*k>bloomDay.length)
        return -1;
        int start = Integer.MAX_VALUE;
        int end = 0;
        for(int i=0;i<bloomDay.length;i++)
        {
            start = Math.min(start,bloomDay[i]);
            end = Math.max(end,bloomDay[i]);
        }
        int ans = -1;
        while(start<=end)
        {
            int mid = (start+end)/2;
            if(helper(bloomDay , mid , m ,k) == true)
            {
            end=mid-1;
            ans=mid;
            }
            else
            {
            start = mid+1; 
            }
        }
        return ans;
    }
}
