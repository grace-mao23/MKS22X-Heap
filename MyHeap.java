import java.util.*;

public class MyHeap {

  private static void pushDown(int[]data,int size,int index) {
    int child1 = index * 2 + 1;
    int child2 = index * 2 + 2;
    int i = index;
    // not at a leaf
    while (child1 < size && child2 < size) {
      // none of the children are larger
      if (data[child1] <= data[i] && data[child2] <= data[i]) {
        child1 = size + 1; // will end while loop
      } else if (data[child1] > data[i] && data[child2] > data[i]) {
        // if both are larger
        if (data[child1] > data[child2]) {
          swap(data, i, child1);
          i = child1;
        } else {
          swap(data, i, child2);
          i = child2;
        }
      } else if (data[child1] > data[i]) {
        swap(data, i, child1);
        i = child1;
      } else {
        swap(data, i, child2);
        i = child2;
      }
      child1 = i * 2 + 1;
      child2 = i * 2 + 2;
    }
  }

  private static void swap(int[] data, int one, int two) {
    int temp = data[one];
    data[one] = data[two];
    data[two] = temp;
  }

  private static void pushUp(int[]data,int index) {

  }

  public static void heapify(int[] data) {

  }

  public static void heapsort(int[] data) {

  }

  public static void main(String[] args) {
    int[] data = new int[] { 3, 10, 8, 5, 2, 4 };
    MyHeap.pushDown(data, 6, 0);
    System.out.println(Arrays.toString(data));
  }
}
