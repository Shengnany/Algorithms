public class QuickUnionUF {
    int[] id;
    int[] size;
    public QuickUnionUF(int N){
        id = new int[N];
        for (int i = 0; i < N ; i++) {
            id[i]=i;
        }
    }
    public int root(int i){
        while(i!=id[i]){
            i=id[i];
        }
        return i;
    }
    public int find(int i){
        return  root(i);
    }
    public void union(int p,int q){
        int i=root(p);
        int j=root(q);
        if(i==j) return ;
        if(size[i]<size[j]){
            id[i]=j;
            size[j]+=size[i];
        }
        else{
            id[j]=i;
            size[i]+=size[j];
        }
    }


    public boolean connected(int p, int q){
        return root(p)==root(q);
    }
}
