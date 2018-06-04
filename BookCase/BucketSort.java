package BookCase;

public class BucketSort {
    public static void main(String[] args) {
        int[] ages = new int[]{100,22,11,22,3,44,44,2,22,11,10,2,3,4};
        SortAge(ages);
        for(int i :ages){
            System.out.print(i + " ");
        }
    }

    public static void SortAge(int[] ages){
        int[] bucket = new int[101];
        for (int i = 0; i < ages.length; i++) {
            bucket[ages[i]]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            if (bucket[i] != 0){
                for (int j = 0; j < bucket[i]; j++) {
                    ages[index] = i;
                    index++;
                }
            }
        }
    }
}
