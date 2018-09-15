package BookCase;

public class HeapSort {

    private static void heapSort(int[] arr) {
        for (int i = arr.length / 2; i >= 0; i--) {
            heapAdjust(arr, i, arr.length);
        }

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i);
        }
    }

    /**
     * @param i 根节点的编号
     * @param n 数组长度
     */
    private static void heapAdjust(int[] arr, int i, int n) {
        int child;
        int father;
        father = arr[i];
        child = leftChild(i);

        for (; child < n; i = child) {
            // 判断左右子树
            if (child != n - 1 && arr[child] < arr[child + 1]) {
                child++;
            }

            if (father < arr[child]) {
                arr[i] = arr[child];
                arr[child] = father;
            }
        }
    }

    private static int leftChild(int i) {
        return 2 * i + 1;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index2];
        arr[index2] = arr[index1];
        arr[index1] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {50, 10, 90, 30, 70, 40, 80, 60, 20};
        System.out.println("排序之前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        // 堆排序
        heapSort(arr);

        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}

