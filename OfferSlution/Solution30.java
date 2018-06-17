package OfferSlution;

public class Solution30 {
    public boolean gInvalidInput = false;
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length <= 0){
            gInvalidInput = true;
            return 0;
        }

        gInvalidInput = false;
        int nGreatestSum = Integer.MIN_VALUE;
        int nCurSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (nCurSum <= 0)
                nCurSum = array[i];
            else
                nCurSum += array[i];
            if(nCurSum > nGreatestSum)
                nGreatestSum = nCurSum;
        }
        return nGreatestSum;
    }
  }
