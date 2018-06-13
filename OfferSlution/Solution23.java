package OfferSlution;

/*class Test{
    public static void main(String[] args) {
        int[] a = new int[]{5,7,6,9,11,10,8};
        System.out.println(new Solution23().VerifySquenceOfBST(a));
    }
}*/
public class Solution23 {
    public boolean VerifySquenceOfBST(int[] sequence) {

        if(sequence.length == 0)
            return false;
        if(sequence.length == 1)
            return true;
        return VerifySquenceOfBST(sequence, 0, sequence.length - 1);
    }

    public boolean VerifySquenceOfBST(int[] sequence, int lo, int hi) {
        if(lo >= hi)
            return true;
        int i = lo;
        while (sequence[i] < sequence[hi])
            i++;
        // 此时 seq[i] > rootVal 右子树
        for (int j = i; j < hi; j++) {
            if(sequence[j] < sequence[hi])
                return false;
        }
        boolean left = VerifySquenceOfBST(sequence,lo,i - 1);
        boolean right = VerifySquenceOfBST(sequence,i,hi - 1);
        return right && left;
    }
}
