class Solution {
    public int maxLength(int[] ribbons, int k) {
        // Time complexity O(n * log(max ribbon))
        // Space complexity O(1)
        int left = 1, right = Integer.MIN_VALUE;
        long sum = 0;
        for(int ribbon : ribbons){
            sum += ribbon;
            right = Math.max(right, ribbon);
        }

        int maxCutLength = 0;
        while(left <= right){
            int cutLength = left + (right - left) / 2;
            if(canCut(ribbons, k, sum, cutLength)){
                maxCutLength = cutLength;
                left = cutLength + 1;
            }
            else{
                right = cutLength - 1;
            }
        }
        return maxCutLength;
    }

    private boolean canCut(int[] ribbons, int k, long sum, int cutLength){
        if(sum / cutLength < k){
            return false;
        }

        for(int ribbon : ribbons){
            k = k - (ribbon / cutLength);
            if(k <= 0){
                return true;
            }
        }

        return false;
    }
}
