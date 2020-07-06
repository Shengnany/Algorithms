/**
 * Decimal dominants. Given an array with n keys, design an algorithm to find all values that occur more than  n/10 times. The expected running time of your algorithm should be linear.
 *
 * 分析：
 *
 * 直观上将n个元素遍历一遍，并记录每个元素出现的次数就可以实现，虽然时间复杂度是O(n)，但是空间复杂度却高达n，这肯定不是该题目的初衷。对于n个元素来说，出现n/10次的元素最多有10个，那么出现超过n/10次的元素最多不超过9个，所以需要9个额外空间auxs就能满足需求。
 *
 * 这9个辅助空间aux怎么使用呢？可采用俄罗斯方块的消去一行的思路。只不过这里消去一行的情况是该行中元素各不相同。
 *
 * 1. 遍历数组array中的每个元素array[i]
 *
 * 2. 如果array[i]在aux中存在，将其在aux中的计数+1
 *
 * 3. 如果array[i]在aux中不存在
 *
 * 　　3.1 如果aux未满，将其放入aux中，并记录其个数为1
 *
 * 　　3.2 如果aux已满，将aux中已经存在的各个元素的计数都减去1，直到某个元素的个数变成0，将array[i]放入aux中该位置处，并记录其个数为1
 *
 * 每个球都会被放在一个位置，
 *
 * 4. 出现次数超过n/10的元素在array遍历完了之后，还会继续存在于aux中，当然aux中可存在着位于array后方但出现次数不满足要求的元素。这时只需要遍历aux的同时再遍历一遍array，记录aux中各个元素在array中出现的次数，将其中出现次数真正超过n/10的元素找出来即可。
  */
import java.util.ArrayList;
   import java.util.Arrays;
// 小球要么被计数，要么消去别人的
public class DecimalDominantsAlternate {

    private class Element{//辅助空间元素定义，用来记录元素值及其出现次数
        public int element;
        public int count;
        public Element(int e,int c){
            this.element = e;
            this.count = c;
        }
    }
    private Element[] elems = new Element[9]; //申请9个辅助空间


    public ArrayList<Integer> findElements(int[] arrays){
        int n = arrays.length;
        for(int k=0;k<9;k++){
            elems[k] = new Element(0,0); //辅助空间初始化
        }
        for(int i=0;i<n;i++){
            int index = findIndex(arrays[i]);
            if(index >= 0)
                elems[index].count ++;
            else
                addToElems(arrays[i]);
        }
        return verifyElems(arrays);
    }

    private int findIndex(int e){
        for(int k = 0; k<9;k++){
            if(elems[k].element == e)
                return k;
            else if(elems[k].count == 0){
                elems[k].element = e;
                return k;
            }
        }
        return -1;
    }


    private void addToElems(int e){
        boolean insertFlag = false;
        while(!insertFlag){
            for(int k=0; k<9;k++){
                elems[k].count --;
                }
            for(int k=0;k<9;k++){
                if(elems[k].count <= 0){
                    elems[k].element = e;
                    elems[k].count = 1;
                    insertFlag = true;
                    break;
                }
            }
        }
    }
    private ArrayList<Integer> verifyElems(int[] arrays){
        int n = arrays.length;
        for(int k = 0; k< 9; k++){
            elems[k].count = 0;
            for(int i = 0; i< n;i++){
                if(arrays[i]==elems[k].element)
                    elems[k].count++;
            }
        }
        ArrayList<Integer> elemList = new ArrayList<Integer>();
        for(int k = 0; k< 9; k++){
            if(elems[k].count > n/10)
                elemList.add(elems[k].element);
        }
        return elemList;
    }

    public static void main(String[] args){
        int n = 20;
        int[] array = new int[n];
        for(int i=0;i<n;i++){
            array[i] = (int) (Math.random()*10);
        }
        System.out.println(Arrays.toString(array));
        DecimalDominantsAlternate elems = new DecimalDominantsAlternate();
        ArrayList<Integer> elemList =  elems.findElements(array);
        System.out.println(elemList.toString());
    }
}