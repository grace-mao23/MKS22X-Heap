import java.util.*;

public class MyHeap {

  private static void pushDown(int[]data,int size,int index) {
    int child1 = index * 2 + 1;
    int child2 = index * 2 + 2;
    int i = index;
    // not at a leaf
    while (child1 < size && child2 < size) {
    //  System.out.println(child1+" " + child2+" "+i);
      // none of the children are larger
      if (data[child1] <= data[i] && data[child2] <= data[i]) {
      //  System.out.println("a");
        i = size + 1; // will end while loop
      } else if (data[child1] > data[i] && data[child2] > data[i]) {
      //  System.out.println("b");
        // if both are larger
        if (data[child1] >= data[child2]) {
          swap(data, i, child1);
          i = child1;
        } else {
          swap(data, i, child2);
          i = child2;
        }
      } else if (data[child1] >= data[i]) {
      //  System.out.println("c");
        swap(data, i, child1);
        i = child1;
      } else {
    //    System.out.println("d");
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
    int parent = (index-1) / 2;
    int i = index;
    while (i != 0) {
      if (data[parent] < data[i]) {
        swap(data, i, parent);
        i = parent;
      }
      parent = (i-1) / 2;
    }
  }

  private static int powerOf2(int n) {
    int result = 1;
    while (result*2 <= n) {
      result *= 2;
      //System.out.println(result+" "+n);
    }
    return result;
  }

  public static void heapify(int[] data) {
    int start = powerOf2(data.length);
  //  System.out.println("Start: "+start);
    for (int i = start; i >= 0; i--) {
      System.out.println(i + ": " + Arrays.toString(data));
      pushDown(data, data.length, i);
      System.out.println("Done");
    }
  }

  public static void heapsort(int[] data) {

  }

  public static void main(String[] args) {
    int[] data = new int[] { 9, 5, 8, 2, 4, 6, 0 };
    MyHeap.pushDown(data, data.length, 2);
  //  MyHeap.pushUp(data, 5);
  //  MyHeap.heapify(data);
    System.out.println(Arrays.toString(data));
  }
}
