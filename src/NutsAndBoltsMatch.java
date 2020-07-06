/**
 *
 * This algorithm first performs a partition by picking last element of bolts array as pivot, rearrange the array of nuts and returns the partition index ‘i’ such that all nuts smaller than nuts[i] are on the left side and all nuts greater than nuts[i] are on the right side. Next using the nuts[i] we can partition the array of bolts. Partitioning operations can easily be implemented in O(n). This operation also makes nuts and bolts array nicely partitioned. Now we apply this partitioning recursively on the left and right sub-array of nuts and bolts.
 *
 * As we apply partitioning on nuts and bolts both so the total time complexity will be Θ(2*nlogn) = Θ(nlogn) on average.
 *
 * Here for the sake of simplicity we have chosen last element always as pivot. We can do randomized quick sort too.
 *
 * Below is the implementation of the above idea:
 */

// Java program to solve nut and bolt problem using Quick Sort
public class NutsAndBoltsMatch
{
    //Driver method
    public static void main(String[] args)
    {
        // Nuts and bolts are represented as array of characters
        char nuts[] = {'@', '#', '$', '%', '^', '&'};
        char bolts[] = {'$', '%', '&', '^', '@', '#'};

        // Method based on quick sort which matches nuts and bolts
        matchPairs(nuts, bolts, 0, 5);

        System.out.println("Matched nuts and bolts are : ");
        printArray(nuts);
        printArray(bolts);
    }

    // Method to print the array
    private static void printArray(char[] arr) {
        for (char ch : arr){
            System.out.print(ch + " ");
        }
        System.out.print("n");
    }

    // Method which works just like quick sort
    private static void matchPairs(char[] nuts, char[] bolts, int low,
                                   int high)
    {
        if (low < high)
        {
            // Choose last character of bolts array for nuts partition.
            int pivot = partition(nuts, low, high, bolts[high]);

            // Now using the partition of nuts choose that for bolts
            // partition.
            partition(bolts, low, high, nuts[pivot]);

            // Recur for [low...pivot-1] & [pivot+1...high] for nuts and
            // bolts array.
            matchPairs(nuts, bolts, low, pivot-1);
            matchPairs(nuts, bolts, pivot+1, high);
        }
    }
    private static void  exch(char[] arr, int i, int j){
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    // Similar to standard partition method.
    // pivot is
    private static int partition(char[] arr, int low, int high, char pivot)
    {
        int i = low;
        for (int j = low; j < high; j++)
        {
            if (arr[j] < pivot){
                exch(arr,i++,j);
            }
            else if(arr[j] == pivot){
                exch(arr,j--,high);
            }
            // 每一轮 : 此处大于pivot    此处等于pivot      j此处小于pivot
            //          j+           j与high换 j不变      j与i换 j+i-
            // i： 遇到一个比pivot小的
            // for bolts the last element from array, fornuts we give the pivot,
            // textbook：dont set pivot until i crosses j; here; i is the flag, dont set pivot until we iterate all elements
            // invariant：  （小于pivo）i（ 大于pivot ）j high <=> lo (小于pivot) i j(大于pivot)
            // another way to implement duplicate but when duplicate keys occurs a bit less efficient
        }
        exch(arr,i,high);

        // Return the partition index of an array based on the pivot
        // element of other array.
        return i;
    }
}
