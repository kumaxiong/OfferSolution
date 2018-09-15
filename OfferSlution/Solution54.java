package OfferSlution;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Queue;

public class Solution54 {

    private Queue<Character> firstAppearQueue = new ArrayDeque<>();
    private HashMap<Character, Integer> map = new HashMap<>();

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (map.get(ch) == null) {
            map.put(ch, 1);
            firstAppearQueue.add(ch);
        } else if (map.get(ch) >= 1) {
            map.put(ch, map.get(ch) + 1);
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        while (!firstAppearQueue.isEmpty()) {
            if (map.get(firstAppearQueue.peek()) == 1) {
                return firstAppearQueue.peek();
            } else {
                firstAppearQueue.remove();
            }
        }
        return '#';
    }

}

/*
class Test {

    public static void main(String[] args) {
        Solution54 first = new Solution54();
        first.Insert('g');
        System.out.println(first.FirstAppearingOnce());
        first.Insert('o');
        System.out.println(first.FirstAppearingOnce());

        first.Insert('o');
        System.out.println(first.FirstAppearingOnce());

        first.Insert('g');
        System.out.println(first.FirstAppearingOnce());

        first.Insert('l');
        System.out.println(first.FirstAppearingOnce());

        first.Insert('e');
        System.out.println(first.FirstAppearingOnce());


    }
}
*/
