import java.util.*;

public class MyHeap {

  private static void pushDown(int[]data,int size,int index) {
    boolean done = false;
    // not at a leaf
    while (!done) {
      int child1 = index * 2 + 1;
      int child2 = index * 2 + 2;
      if (child1 >= size && child2 >= size) {
        done = true;
      } else {
        int max = data[index];
        if (child1 < size) {
          max = Math.max(max, data[child1]);
        }
        if (child2 < size) {
          max = Math.max(max, data[child2]);
        }
        if (max == data[index]) {
          done = true;
        } else if (child1 < size && max == data[child1]) {
          swap(data, child1, index);
          index = child1;
        } else {
          swap(data, child2, index);
          index = child2;
        }
      }
    }
  }

  private static void swap(int[] data, int one, int two) {
    int temp = data[one];
    data[one] = data[two];
    data[two] = temp;
  }

  private static void pushUp(int[]data,int index) {
    boolean done = false;
    while (!done) {
      int parent = (index - 1) / 2;
      if (parent < 0) {
        done = true;
      } else {
        if (data[index] > data[parent]) {
          swap(data, parent, index);
          index = parent;
        } else {
          done = true;
        }
      }
    }
  }

  public static void heapify(int[] data) {
    int start = (int)(Math.log(data.length)/Math.log(2.0));
//    System.out.println("Start: "+start);
    for (int i = (int)(Math.pow(2,start)) - 2; i >= 0; i--) {
  //    System.out.println(i + ": " + Arrays.toString(data));
      pushDown(data, data.length, i);
    //  System.out.println("Done");
    }
  }

  public static void heapsort(int[] data) {
    heapify(data);
    int end = data.length - 1;
    while (end > 0) {
      swap(data, 0, end);
    //  System.out.println(Arrays.toString(data)+ " " + end + "!");
      pushDown(data, end, 0);
      end--;
    //  System.out.println(Arrays.toString(data) + " " + end);
    }
  }

  /*public static void main(String[] args) {
    int[] data = new int[] { 6,4,3,8,6,6,6,6,9,1,1,2 };
  //  MyHeap.pushDown(data, data.length, 2);
  //  MyHeap.pushUp(data, 5);
    MyHeap.heapify(data);
    System.out.println(Arrays.toString(data));
    MyHeap.heapsort(data);
    System.out.println(Arrays.toString(data));
  } */
  public static void main(String[]args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          MyHeap.heapsort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }



}
