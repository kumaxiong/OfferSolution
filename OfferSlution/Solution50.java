package OfferSlution;

import java.util.HashMap;

public class Solution50 {

    // Parameters:
    //    numbers:     an array of integers
    //    length:      the length of array numbers
    //    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
    //                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
    //    这里要特别注意~返回任意重复的一个，赋值duplication[0]
    // Return value:       true if the input is valid, and there are some duplications in the array number
    //                     otherwise false
    public boolean duplicate(int numbers[], int length, int[] duplication) {
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean searchResult = false;
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null) {
                duplication[0] = numbers[i];
                searchResult = true;
                break;
            } else {
                map.put(numbers[i], -1);
            }
        }
        return searchResult;
    }

    // 使用通过判断数字是否是复数来作为标志位进行判断。
    public boolean duplicate2(int numbers[], int length, int[] duplication) {
        if (numbers == null || length <= 1) {
            return false;
        }
        boolean searchResult = false;
        for (int i = 0; i < numbers.length; i++) {
            numbers[i]++;
            if (numbers[i] > numbers.length + 1) {
                return false;
            }
        }

        for (int i = 0; i < numbers.length; i++) {
            int numIndex = numbers[i];
            if (numIndex < 0) {
                numIndex *= -1;
            }
            numIndex -= 1;
            if (numbers[numIndex] > 0) {
                numbers[numIndex] *= -1;
            } else {
                duplication[0] = numIndex;
                searchResult = true;
                break;
            }
        }
        return searchResult;
    }
}

// class Test {
//
//     public static void main(String[] args) {
//         int[] result = new int[1];
//         boolean searchResult = new Solution50().duplicate2(new int[]{}, 0, result);
//         System.out.println(searchResult);
//         System.out.println(result[0]);
//     }
// }