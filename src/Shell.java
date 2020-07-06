public class Shell {
    public static void sort(IntersectionPoint[] a){
        int count=0;
        int N = a.length;
        int h=1;
        while(h<N/3)
            h=3*h+1;
        while(h>=1){
            for(int i=h;i<N;i++){
                for(int j=i;j>=h;j-=h){
                    count++;
                    if(less(a[j],a[j-h])) {
                        exch(a, j, h - h);
                    }
                    else break;
                }
            }
            h=h/3;
        }
        System.out.println(count);
    }
    public static boolean less(IntersectionPoint a,IntersectionPoint b){
        if(a.x>b.x) return false;
        else if(a.x<b.x) return true;
        else return (a.y<b.y);
    }
    public static void exch(IntersectionPoint[] a, int i, int j){
        IntersectionPoint temp=a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
