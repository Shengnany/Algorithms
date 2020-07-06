public class DutchNationalFlag {

    //It is very smiliar with the QuickSort3Way
    public void sort(Character[] flags) {

        int red = 0;// Initial index for red
        int blue = flags.length - 1;//Initial index for blue
        int i = 0;
        while (i <= blue) {
            if (flags[i] == 'r') {
                swap(flags, red++, i++);
            } else if (flags[i] == 'b') {
                swap(flags, blue--, i);
                //Here don't increase i, since after swap, the flags[i] has not been checked.
            } else {
                i++;
            }
        }
    }
    public void swap(Character[] t, int i, int j) {
        Character tmp = t[i];
        t[i] = t[j];
        t[j] = tmp;
    }

    public static void main(String[] args) {
        DutchNationalFlag f = new DutchNationalFlag();

        Character[] t = {'b', 'r', 'w', 'w', 'r', 'b', 'r'};
        f.sort(t);
        for (char c : t) {
            System.out.print(c);
        }
        System.out.println();;
    }
}

