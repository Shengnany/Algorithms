//
//Question 1: Intersection of two sets
//        Given two arrays a[] and b[], each containing N distinct 2D points in the plane,
//        design a subquadratic algorithm to count the number of points that are contained
//        both in array a[] and array b[].


public class IntersectionPoint implements Comparable<IntersectionPoint> {
    public int x;
    public int y;

    public IntersectionPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(IntersectionPoint that) {
        if (that.x > this.x) return -1;
        if (that.x < this.x) return 1;
        if (that.y > this.y) return -1;
        if (that.y < this.y) return 1;
        return 0;
    }
    public static int countIntersection(IntersectionPoint[] a, IntersectionPoint[] b){
        Shell.sort(a);
        Shell.sort(b);
        int i = 0;
        int j = 0;
        int count = 0;

        while (i < a.length && j < b.length) {
            if (a[i].compareTo(b[j]) == 0) {
                count++;
                i++;
                j++;
            }
            else if (a[i].compareTo(b[j]) < 0) i++;
            else j++;
        }
        return count;
    }

    public static void main(String[] args) {
        IntersectionPoint a=new IntersectionPoint(1,2);
        IntersectionPoint b=new IntersectionPoint(1,2);
        IntersectionPoint c=new IntersectionPoint(2,3);
        IntersectionPoint d=new IntersectionPoint(2,3);
        IntersectionPoint e=new IntersectionPoint(1,2);
        IntersectionPoint[] x=new IntersectionPoint[2];
        x[0]=a;
        x[1]=c;
        IntersectionPoint[] y=new IntersectionPoint[3];
        y[0]=d;
        y[1]=b;
        y[2]=e;
        System.out.println(countIntersection(x,y));
    }
}
