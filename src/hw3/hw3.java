package hw3;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Scanner;

public class hw3 {

    public static void main(String[] args) {

        // 請設計一隻程式,使用者輸入三個數字後,輸出結果會為正三角形、
        // 等腰三角形、直角三角形、其它三角形或不是三角形,如圖示結果:

//        m1();

        // • 請設計一隻程式,會亂數產生一個0~9的數字,然後可以玩猜數字遊戲,猜錯會顯示錯誤訊息,猜
        // 對則顯示正確訊息,如圖示結果:
        // (提示:Scanner,亂數方法,無窮迴圈)
        // (進階功能:產生0~100亂數,每次猜就會提示你是大於還是小於正確答案)

        // 基本

//        m2();

        // 進階

//        m2Plus();

//        • 阿文很喜歡簽大樂透(1~49),但他是個善變的人,上次討厭數字是4,但這次他想要依心情決定討
//        厭哪個數字,請您設計一隻程式,讓阿文可以輸入他不想要的數字(1~9),畫面會顯示他可以選擇
//        的號碼與總數,如圖:
//        (提示:Scanner)
//        (進階挑戰:輸入不要的數字後,直接亂數印出6個號碼且不得重複)

        // 基本

//        m3();

        // 進階

//        m3Plus();

    }

    public static void m1() {
        Scanner sca = new Scanner(System.in);
        int[] arr = new int[3];
        do {
            System.out.println("請輸入三個整數：");
            int count;
            for (count = 0; count < arr.length; count++) {
                if (sca.hasNextInt()) {
                    arr[count] = sca.nextInt();
                } else {
                    System.out.println("輸入錯誤，請重新輸入！");
                    sca.nextLine();
                    break;
                }
            }
            if (count == arr.length) {
                break;
            }
        } while (true);

        // 不是三角形
        // 正三角形
        // 等腰三角形 (都是整數，不會出現等腰直角三角形)
        // 其它三角形
        Arrays.sort(arr);
        if (arr[0] + arr[1] <= arr[2]) {
            System.out.println("不是三角形");
        } else if (arr[0] == arr[2]) {
            System.out.println("正三角形");
        } else if (arr[0] == arr[1] || arr[1] == arr[2]) {
            System.out.println("等腰三角形");
        } else if ((arr[0] * arr[0]) + (arr[1] * arr[1]) == (arr[2] * arr[2])) {
            System.out.println("直角三角形");
        } else {
            System.out.println("其他三角形");
        }
    }

    public static void m2() {
        // 基本
        int r = (int) (Math.random() * 10);
        System.out.println("開始猜數字吧！");
        do {
            Scanner sca = new Scanner(System.in);
            if (!sca.hasNextInt()) {
                System.out.println("輸入錯誤，請重新輸入...");
                //sca.nextLine();
                continue;
            }
            int n = sca.nextInt();
            if (r != n) {
                System.out.println("猜錯囉");
            } else {
                System.out.println("答對了！答案就是 " + n);
                break;
            }
        } while (true);
    }

    public static void m2Plus() {
        //進階
        int r = (int) (Math.random() * 101);
        System.out.println("開始猜數字吧！(0 ~ 100)");
        do {
            Scanner sca = new Scanner(System.in);
            if (!sca.hasNextInt()) {
                System.out.println("輸入錯誤，請重新輸入...");
                //sca.nextLine();
                continue;
            }
            int n = sca.nextInt();
            if (r != n) {
                System.out.println("猜錯囉");
                if (n > r) {
                    System.out.println("提示：你猜的數大於正確答案...");
                } else {
                    System.out.println("提示：你猜的數小於正確答案...");
                }
            } else {
                System.out.println("答對了！答案就是 " + n);
                break;
            }
        } while (true);
    }

    public static void m3() {
        System.out.println("阿文...請輸入你討厭哪個數字？");
        int n;
        do {
            Scanner sca = new Scanner(System.in);
            if (!sca.hasNextInt()) {
                System.out.println("輸入錯誤，請重新輸入！");
                continue;
            }
            n = sca.nextInt();
            if (n < 1 || n > 9) {
                System.out.println("請輸入 1 ~ 9 ，請重新輸入！");
                continue;
            }
            System.out.println();
            break;

        } while (true);

        int count = 0;
        boolean fastComp = (n <= (49 / 10));
        for (int i = 1; i <= 49; i++) {
            // 優化思路：
            // n > 10位數，只需要比較個位數
            // n -> 只要比到n，剩下不用比了(? 多寫 i % 10 > n 好像不會比較快

            if ((i % 10 == n) || (fastComp && ((i / 10) == n))) {
                continue;
            }

            System.out.print(i + "\t");
            count++;

            if (count % 6 == 0) {
                System.out.println();
            }
        }
        System.out.println("\n總共有 " + count + " 數字可選");
    }

    public static void m3Plus() {
        System.out.println("阿文...請輸入你討厭哪個數字？");
        int n;
        do {
            Scanner sca = new Scanner(System.in);
            if (!sca.hasNextInt()) {
                System.out.println("輸入錯誤，請重新輸入！");
                continue;
            }
            n = sca.nextInt();
            if (n < 1 || n > 9) {
                System.out.println("請輸入 1 ~ 9 ，請重新輸入！");
                continue;
            }
            System.out.println();
            break;

        } while (true);

        int count = 0;
        int preR = -1;
        while (count < 6) {
            int r = (int) (Math.random() * 49) + 1;
            if (preR == r) {
                continue;
            }
            if (r % 10 == n || r / 10 == n) {
                continue;
            }
            System.out.print(r + " ");
            preR = r;
            count++;
        }
    }


}
