/**
 * Divide And Conquer Approach 2
 * While the above implementation is very efficient,
 * we can still get away with making it more efficient.
 * Instead of dividing the array into segments of n / 2 and m / 2 then recursing,
 * we can divide them both by k / 2 and recurse.o(log(k))
 */
public class KthInToStedArr {
    static int kth(int arr1[], int arr2[], int m,
                   int n, int k, int st1, int st2)
    {
        // In case we have reached end of array 1
        if (st1 == m)
        {
            return arr2[st2 + k - 1];
        }

        // In case we have reached end of array 2
        if (st2 == n)
        {
            return arr1[st1 + k - 1];
        }

        // k should never reach 0 or exceed sizes
        // of arrays
        if (k == 0 || k > (m - st1) + (n - st2))
        {
            return -1;
        }

        // Compare first elements of arrays and return
        if (k == 1)
        {
            return (arr1[st1] < arr2[st2])
                    ? arr1[st1] : arr2[st2];
        }

        int curr = k / 2;
        // Size of array 1 is less than k / 2
        if (curr - 1 >= m - st1)
        {

            // Last element ofde array 1 is not kth
            // We can directly return the (k - m)th
            // element in array 2
            if (arr1[m - 1] < arr2[st2 + curr - 1])
            {
                return arr2[st2 + (k - (m - st1) - 1)];
            }
            else
            {
                return kth(arr1, arr2, m, n, k - curr,
                        st1, st2 + curr);
            }
        }

        // Size of array 2 is less than k / 2
        if (curr - 1 >= n - st2)
        {
            if (arr2[n - 1] < arr1[st1 + curr - 1])
            {
                return arr1[st1 + (k - (n - st2) - 1)];
            }
            else
            {
                return kth(arr1, arr2, m, n, k - curr,
                        st1 + curr, st2);
            }
        }
        else

            // Normal comparison, move starting index
            // of one array k / 2 to the right
            if (arr1[curr + st1 - 1] < arr2[curr + st2 - 1])
            // 小的肯定有的
            {
                return kth(arr1, arr2, m, n, k - curr,
                        st1 + curr, st2);
            }
            else
            {
                return kth(arr1, arr2, m, n, k - curr,
                        st1, st2 + curr);
            }
    }

    // Driver code
    public static void main(String[] args)
    {
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int k = 5;
        int st1 = 0, st2 = 0;
        System.out.println(kth(arr1, arr2, 5, 4, k, st1, st2));
    }
}

// Java Program to find kth element
// from two sorted arrays

class Main
{
    static int kth(int arr1[], int arr2[], int m, int n, int k)
    {
        int[] sorted1 = new int[m + n];
        int i = 0, j = 0, d = 0;
        while (i < m && j < n)
        {
            if (arr1[i] < arr2[j])
                sorted1[d++] = arr1[i++];
            else
                sorted1[d++] = arr2[j++];
        }
        while (i < m)
            sorted1[d++] = arr1[i++];
        while (j < n)
            sorted1[d++] = arr2[j++];
        return sorted1[k - 1];
    }

    // main function
    public static void main (String[] args)
    {
        int arr1[] = {2, 3, 6, 7, 9};
        int arr2[] = {1, 4, 8, 10};
        int k = 5;
        System.out.print(kth(arr1, arr2, 5, 4, k));
    }
}

/* This code is contributed by Harsh Agarwal */
