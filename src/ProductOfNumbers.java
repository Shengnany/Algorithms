/*
mplement the class ProductOfNumbers that supports two methods:

1. add(int num)

Adds the number num to the back of the current list of numbers.

2. getProduct(int k)

Returns the product of the last k numbers in the current list.
You can assume that always the current list has at least k numbers.
At any time, the product of any contiguous sequence of numbers will fit into a single 32-bit integer without overflowing.
 */


import java.util.ArrayList;
import java.util.List;

public class ProductOfNumbers {
     List<Integer> prod;
     int p;

    public ProductOfNumbers() {
        prod = new ArrayList<>();
        p = 1;
    }

    public void add(int num) {
        if (num == 0) {
            prod = new ArrayList<>();
            p = 1;
            return;
        }
        p *= num;
        prod.add(p);
    }

    public int getProduct(int k) {
        if (prod.size() < k) return 0;
        int ans = prod.get(prod.size() - 1);
        if (prod.size() == k) return ans;
        return (ans / prod.get(prod.size() - k - 1));
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */
