/**
 * Decimal dominants. Given an array with nn keys, design an algorithm to find all values that occur more than n/10 times.
 * The expected running time of your algorithm should be linear.
 *
 * Solution: you may use 3-way-partition quick-select to find the (n/10)th largest element of the array, a
 * nd then check whether it's decimal-dominant; if not, recur in the right sub-array.
 * Alternate solution hint: use 9 counters.
 *
 */


import java.util.Arrays;

/** ====================================================================================================================
 * public class DecimalDominants {
 public static void sort(Comparable[] arr) {
 sort(arr, 0, arr.length - 1);
 }

 private static void sort(Comparable[] arr, int lo, int hi) {
 if (lo >= hi) return;
 int lt = lo, gt = hi;
 Comparable v = arr[lo];
 int i = lo;
 while (i <= gt) {
 int cmp = arr[i].compareTo(v);
 if (cmp < 0) swap(arr, lt++, i++);
 else if (cmp > 0) swap(arr, i, gt--);
 else i++;
 }
 int times = gt - lt + 1;
 if (times > arr.length / 10) System.out.printf("%s repeats %d times\n", v, times);
 sort(arr, lo, lt - 1);
 sort(arr, gt + 1, hi);
 }

 private static void swap(Comparable[] arr, int i, int j) {
 Comparable swap = arr[i];
 arr[i] = arr[j];
 arr[j] = swap;
 }

 public static void main(String[] args) {
 Integer[] arr = {1, 2, 1, 2, 1, 2, 1, 4, 3, 2, 4, 2, 3, 5, 6, 7, 8, 9, 3, 2, 4, 5, 2, 3, 6, 7, 8, 3, 2, 5};
 System.out.println("print numbers which repeat more then " + arr.length / 10);
 sort(arr);
 }
 }
 * =====================================================================================================================
 */

public class DecimalDominants {

    private static void quickSelect(Integer[] arr, int k,int st){
        if(st>=arr.length-1) return;
        int answer;
        int lo=st,hi= arr.length-1;
            int j;
            boolean found =true;
            while (lo<hi&&found) {
               j=partition(arr,lo,hi);
               if(j<k) lo=j+1;
               else if(j>k) hi=j-1;
               else {
                   found=false;
               }
            }
            if(lo==hi) {
                if(check(arr,arr[lo],arr.length/k))
                    System.out.println("1");
            }
           else if( check(arr,arr[k],arr.length/k))
               System.out.println("1");
           quickSelect(arr,k,st+k);
    }
    private static int partition(Integer[]arr, int lo, int hi){
        Integer v = arr[lo];
        int lt = lo, gt = hi;
        int i = lo;
        if(lo < hi)  {
            while (i <= gt) {
                int cmp = arr[i].compareTo(v);
                if (cmp < 0) swap(arr, lt++, i++);
                else if (cmp > 0) swap(arr, i, gt--);
                else i++;
            }
            return lt;
        }
       else return lo;
    }
    private static boolean check(Integer[]arr, Integer a,int times){
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(a.equals(arr[i]))
            count++;

        }
        if(count>=times) return true;
        else return false;
    }
    private static void swap(Integer[] arr, int i, int j) {
        int swap = arr[i];
        arr[i] = arr[j];
        arr[j] = swap;
    }

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 1, 2, 1, 2, 1, 4, 3, 2, 4, 2, 3, 5, 6, 7, 8, 9, 3, 2, 4, 5, 2, 3, 6, 7, 8, 3, 2, 5};
        System.out.println("print numbers which repeat more then " + arr.length / 10);
        quickSelect(arr,arr.length / 10,0);
    }

}
