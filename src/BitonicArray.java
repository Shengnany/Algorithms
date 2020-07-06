/**
 * Coursera - Algorithms Part I
 * Week 1 - Interview Questions - Union Find
 *
 * Question 2: Search in a bitonic array
 * An array is bitonic if it is comprised of an increasing sequence of integers
 * followed immediately by a decreasing sequence of integers. Write a program
 * that, given a bitonic array of N distinct integer values, determines whether
 * a given integer is in the array.
 *
 * Standard version: Use ~3lgN compares in the worst case.
 * Signing bonus: Use ~2lgN compares in the worst case (and prove that no
 * algorithm can guarantee to perform fewer than ~2lgN compares in the worst case).
 */

/**
 * Solution:
 *
 * Use three binary searches.
 * 1) Locate the point in the array where ascending switchines to descending
 * 2) Perform binary search on each half of the array for the target integer
 * 包围法，一次缩短一半
 */
public class BitonicArray {
    public static void main(String[] args) {
        int[] array = { 1, 2, 3, 4, 5, 15, 10, 9, 8, 7, 6 };
        int peak = binarySearchPeak(array, 0, array.length-1);
        int target = 0;
        System.out.println(target + ": " + find(array, peak, target));
        target = 1;
        System.out.println(target + ": " + find(array, peak, target));
        target = 8;
        System.out.println(target + ": " + find(array, peak, target));
        target = 20;
        System.out.println(target + ": " + find(array, peak, target));
    }

    public static boolean find(int[]array, int peak, int target){
        return bitonicSearch(array, peak, target);
    }

   private static int binarySearchPeak(int[]array, int start, int end){
       int mid;
        while(start<end){
            mid=(start+end)/2;
            if(array[mid]<array[mid+1]) start=mid+1;
            else end=mid;
        }
        return end;
   }

   private static boolean bitonicSearch(int[] array,int peak, int target ){
        int st1=0;
        int en1=peak;
        int st2=peak;
        int en2=array.length-1;
        int mi1,mi2;
        boolean found=false;
        while(st1<en1){
            mi1=(st1+en1)/2;
            if(array[mi1]==target) found=true;
            if(array[mi1]<target) st1=mi1+1;
            else en1=mi1;
        }
       while(st2<en2){
           mi2=(st2+en2)/2;
           if(array[mi2]==target) found=true;
           if(array[mi2]>target) st2=mi2+1;
           else en2=mi2;
       }
        return found;
   }
}
