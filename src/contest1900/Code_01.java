package contest1900;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * @author wangchong
 * @date 2019/5/25 19:25
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */
public class Code_01 {
    static int sum = 0;
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        ArrayList[] arrayList = new ArrayList[n + 1];
        for (int i = 0; i < arrayList.length; i++) {
            arrayList[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < n - 1; i++) {
            int x = input.nextInt();
            int y = input.nextInt();
            boolean judge = false;
            for (int j = 0; j < arrayList.length; j++) {
                if (arrayList[j].contains(x)) {
                    arrayList[j].add(y);
                    judge = true;
                }
            }
            if (!judge) {
                arrayList[x].add(y);
            }
        }
        int max = 0;
        int index1 = 0;
        for (int i = 1; i < arrayList.length; i++) {
            if (arrayList[i] != null) {
                int len = arrayList[i].size();
                if (len > max) {
                    max = len;
                    index1 = i;
                }
            }

        }
        arrayList[index1].removeAll(arrayList[index1]);
        int index2 = 0;
        max = 0;
        for (int i = 0; i < arrayList.length; i++) {
            if (arrayList[i] != null) {
                int len = arrayList[i].size();
                if (len > max) {
                    max = len;
                    index2 = i;
                }
            }
        }

        arrayList[index2].removeAll(arrayList[index2]);
        for (int i = 1; i < arrayList.length; i++) {
            if (i == index1 || i == index2) {
                continue;
            }
            if (arrayList[i] != null) {
                if (arrayList[i].size() == 0) {
                    sum++;
                } else {
                    for (int j = 0; j < arrayList[i].size(); j++) {
                        int shouldRemove = (int)arrayList[i].get(j);
                        if (shouldRemove == index1 || shouldRemove == index2) {
                            sum++;
                            continue;
                        }
                        removeA(arrayList,shouldRemove);
                        if (j == arrayList[i].size() - 1) {
                            sum++;
                        }
                    }
                }
            }
        }
        System.out.println(sum);
    }
    public static void removeA(ArrayList[] arrayList, int index) {
        for (int i = 0; i < arrayList[index].size(); i++) {

            removeA(arrayList,(int)arrayList[index].get(i));
            arrayList[index].removeAll(arrayList[index]);
        }
        sum--;
    }
}
