class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend==Integer.MIN_VALUE&&divisor==-1){
            return Integer.MAX_VALUE;
        }
        long a=Math.abs((long)dividend);
        long b=Math.abs((long)divisor);
        int res=0;
        for(int i=31;i>=0;i--){
            if(a>>>i>=b){
                a-=b<<i;
                res+=1<<i;
            }
        }     
        return (dividend^divisor)>=0?res:-res;
    }
}

class Solution {
    public int search(int[] nums, int target) {
        if(nums.length==0){
            return -1;
        }
        int l=0;
        int r=nums.length-1;
        while(l<=r){
            int mid=(l+r)>>>1;
            if(nums[mid]==target){
                return mid;
            }else if(nums[mid]>=nums[0]){
                if(target>=nums[l]&&target<=nums[mid]){
                    r=mid-1;
                }else{
                    l=mid+1;
                }
            }else{
                if(target>=nums[mid]&&target<=nums[r]){
                    l=mid+1;
                }else{
                    r=mid-1;
                }
            }
        }
        return -1;
    }
}

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res={-1,-1};
        int l=0;
        int r=nums.length;
        while(l<r){
            int mid=(l+r)>>>1;
            if(nums[mid]==target){
                r=mid;
            }else if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        res[0]=l==nums.length||nums[l]!=target?-1:l;
        l=0;
        r=nums.length;
        while(l<r){
            int mid=(l+r)>>>1;
            if(nums[mid]==target){
                l=mid+1;
            }else if(nums[mid]<target){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        res[1]=r==0||nums[r-1]!=target?-1:l-1;
        return res;
    }
}

class Solution {
    public double myPow(double x, int n) {
        double pow=1;
        int i=n;
        while(i!=0){
            if(i%2!=0){
                pow*=x;
            }
            i/=2;
            x*=x;
        }
        return n>0?pow:1/pow;
    }
}

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int row=0;
        int col=matrix[0].length-1;
        while(row<matrix.length&&col>=0){
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]>target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }
}


class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0){
            return false;
        }
        int row=matrix.length;
        int col=matrix[0].length;
        int left=0;
        int right=row*col-1;
        while(left<=right){
            int mid=(left+right)>>>1;
            if(matrix[mid/col][mid%col]==target){
                return true;
            }else if(matrix[mid/col][mid%col]<target){
                left=mid+1;
            }else{
                right=mid-1;
            }
        }
        return false;
    }
}

class Solution {
    public boolean search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int mid=(left+right)>>>1;
            if(nums[mid]==target){
                return true;
            }
            if(nums[left]==nums[mid]){
                left++;
                continue;
            }
            if(nums[mid]>nums[left]){
                if(target>=nums[left]&&target<=nums[mid]){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }else {
                if(target>=nums[mid]&&target<=nums[right]){
                    left=mid+1;
                }else{
                    right=mid-1;
                }
            }
        }
        return false;
    }
}


class Solution {
    public int findMin(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=(left+right)>>>1;
            if(nums[mid]>nums[right]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return nums[left];
    }
}

class Solution {
    public int findPeakElement(int[] nums) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid=(left+right)>>>1;
            if(nums[mid]<nums[mid+1]){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return left;
    }
}

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum=0;
        int count=nums.length+1;
        int left=0;
        int right=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            right=i;
            if(sum>=s){
                count=Math.min(count,right-left+1);
            }
            while(sum-nums[left]>=s){
                sum-=nums[left];
                left++;
                count=Math.min(count,right-left+1);
            }
        }
        return count==nums.length+1?0:count;
    }
}

