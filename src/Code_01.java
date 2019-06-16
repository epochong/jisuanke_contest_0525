import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author wangchong
 * @date 2019/5/25 13:57
 * @email 876459397@qq.com
 * @CSDN https://blog.csdn.net/wfcn_zyq
 * @describe
 */
public class Code_01 {
    public static boolean isKuoHao(String str) {
        if (str.length() % 2 != 0) {
            return false;
        } else {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(') {
                    stack.push('(');
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        while (input.hasNextLine()) {
            String str = input.nextLine();
            if (str.equals("")) {
                break;
            }
            arrayList.add(str);
        }
        for (int i = 0; i < arrayList.size(); i++) {
            int n = arrayList.get(i).length();
            for (int j = 0; j < n; j++) {
                String str = arrayList.get(i);
                if (isKuoHao(str.substring(n-j,n) + str.substring(0,n - j))) {
                    System.out.println("YES");
                    break;
                }
                if (j == n - 1) {
                    System.out.println("NO");
                }
            }
        }
    }
}
