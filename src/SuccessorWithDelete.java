/*
  Coursera - Algorithms Part II
  Week 1 - Interview Questions
  Question 3: Successor with delete.
  Given a set of N integers S={0,1,...,N−1} and a sequence of requests of the
  following form:
  - Remove x from S
  - Find the successor of x: the smallest y in S such that y≥x.
  Design a data type so that all operations (except construction) should take
  logarithmic time or better.
*/
/*
  Solution:
  Use union find data structure to mark successor of each integer. When an
  integer is removed, the union find data structure connects to the next
  integer in the list (which may be farther up the list). Must be careful with
  optimizations since connected component id is the successor integer.
*/

public class SuccessorWithDelete {
    private QuickUnionUF uf;
    public SuccessorWithDelete(int N) {
        uf = new QuickUnionUF(N);
    }
    public void remove (int x){
        if(x==uf.id.length-1)
            uf.union(x,0);
        else
            uf.union(x, x+1);
    }
    public int successor(int x) {
        return uf.find(x);
    }
}

