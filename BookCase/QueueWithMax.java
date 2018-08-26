package BookCase;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

/**
 * 队列的最大值——> 参照滑动窗口的最大值
 */
public class QueueWithMax {


    private static class InternalData {

        public InternalData(int number, int index) {
            this.number = number;
            this.index = index;
        }

        int number;
        int index;
    }

    private Deque<InternalData> mData = new ArrayDeque<>();
    private Deque<InternalData> mMaxData = new ArrayDeque<>();
    private int currentIndex = 0;

    public void add(int number) {
        InternalData data = new InternalData(number,currentIndex);
        mData.add(data);
        while (!mMaxData.isEmpty() && mMaxData.getLast().number < number) {
            mMaxData.removeLast();
        }
        mMaxData.add(data);
        currentIndex++;
    }

    public int remove() {
        assert !mData.isEmpty();
        InternalData data = mData.remove();

        assert !mMaxData.isEmpty();
        if (mMaxData.peek().index == data.index) {
            mMaxData.remove();
        }

        return data.number;
    }

    public int getMax() {
        assert !mMaxData.isEmpty();
        return mMaxData.peek().number;
    }
}

/*
class Test {

    public static void main(String[] args) {
        QueueWithMax queue = new QueueWithMax();
        queue.add(1);
        queue.add(3);
        queue.add(7);
        queue.add(2);
        queue.add(9);
        queue.add(5);
        queue.add(3);
        System.out.println(queue.getMax());

        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        queue.remove();
        System.out.println(queue.getMax());
    }
}*/
