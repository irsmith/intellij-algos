package array;

/**
   Given 'Mr R Smith' substitute spaces in place '%20'
  */
public class MrSmith {

    public static void main(String[] args) {
        String s = "Mr R Smith";
        String s2 = "Mr R Smith ";
        String s3 = "";

        char []a = s.toCharArray();

        // count
        int nbrSpaces = 0;

        for (int i=0;i<a.length-1;i++) {
            if (a[i] == ' ') {
                nbrSpaces++;
            }
        }
        int lastNonSpace = a.length-1;

        // alloc
        String x = s + new String(new char[nbrSpaces*2]);
        a = x.toCharArray();
        printit(a);

        // walk
        int k = lastNonSpace;
        int p = a.length -1;
        while (k>0) {
            if (a[k] == ' ') {
                insertEntity(a,k,p);
                p -= 3;
            } else {
                //swap(a, k, p); NO if swap then we loose data!
                // copyOrigChar(a, k, p);  NO! cannot increment primitive arg!
                a[p] = a[k];
                p--;
            }
            k--;
        }

        printit(a);
    }

    private static void printit(char[] a) {
        for (int i=0;i<a.length-1;i++) {
            System.out.print(a[i]);
        }
        System.out.println();
    }

    private static void insertEntity(char[] a, int k, int p) {
        a[p-2]='%';
        a[p-1]='2';
        a[p]='0';
        p =-3;  //NO
    }
    private static void copyOrigChar(char[] a, int k, int p) {
        a[p] = a[k];
        p--;
    }

}
