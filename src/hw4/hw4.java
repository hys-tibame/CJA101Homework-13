package hw4;

import java.util.Arrays;
import java.util.Scanner;

public class hw4 {
    public static void main(String[] args) {

//    • 有個一維陣列如下:
//    {29, 100, 39, 41, 50, 8, 66, 77, 95, 15}
//    請寫出一隻程式能輸出此陣列所有元素的平均值與大於平均值的元素
//    (提示:陣列,length屬性)


        m1();


//    • 請建立一個字串,經過程式執行後,輸入結果是反過來的
//    例如String s = “Hello World”,執行結果即為dlroW olleH
//    (提示:String方法,陣列)


        // 1. 使用StringBuilder

//        m2_1();

        // 2. 使用String方法

//        m2_2();

        // 2. 使用Char陣列

//        m2_3();


//    • 有個字串陣列如下 (八大行星):
//    {“mercury”, “venus”, “earth”, “mars”, “jupiter”, “saturn”, “uranus”, “neptune”}
//    請用程式計算出這陣列裡面共有多少個母音(a, e, i, o, u)
        //
//    (提示:字元比對,String方法)


//        m3();


//    阿文上班時忘了帶錢包,想要向同事借錢,和他交情比較好的同事共有 5 個,其員工編號與身上現金列
//    表如下:
//        25   32  8   19   27
//        2500 800 500 1000 1200
//    請設計一個程式,可以讓小華輸入欲借的金額後,便會顯示哪些員工編號的同事
//    有錢可借他;並且統計有錢可借的總人數:例如輸入 1000 就顯示「有錢可借的
//    員工編號: 25 19 27 共 3 人!」
//    (提示:Scanner,二維陣列)


//        m4();


//    請設計由鍵盤輸入三個整數,分別代表西元yyyy年,mm月,dd日,執行後會顯示是該年的第幾天
//
//    例:輸入 1984 9 8 三個號碼後,程式會顯示「輸入的日期為該年第252天」
//
//    (提示1:Scanner,陣列)
//    (提示2:需將閏年條件加入)
//    (提示3:擋下錯誤輸入:例如月份輸入為2,則日期不該超過29)


//        m5(); // 猴子算法

//        m5Plus(); // 正常人算法


//     班上有8位同學,他們進行了6次考試結果如下:
//     請算出每位同學考最高分的次數
//     (提示:二維陣列)


//        m6();


    }

    public static void m1() {
        int[] arr = {29, 100, 39, 41, 50, 8, 66, 77, 95, 15};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        double average = (double) sum / arr.length;
        System.out.println("平均值 = " + average);
        System.out.println("以下陣列元素大於平均值：");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > average) {
                System.out.println("arr陣列[" + i + "] = " + arr[i] + " ");
            }
        }
    }

    public static void m2_1() {
        // 1. 使用String方法
        String s = "Hello World";
        String reverse = new StringBuilder(s).reverse().toString();
//        String reverse = new StringBuffer(s).reverse().toString();
        System.out.println(reverse);
    }

    public static void m2_2() {
        String s = "Hello World";
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(s.length() - i - 1));
        }
    }

    public static void m2_3() {
        String s = "Hello World";
        char[] c = new char[s.length()];
        for (int i = 0; i < c.length; i++) {
            c[i] = s.charAt(c.length - i - 1);
        }
//        String reverse = new String(c);
        String reverse = String.valueOf(c);
        System.out.println(reverse);
    }

    public static void m3() {
        String[] words = {"mercury", "venus", "earth", "mars", "jupiter", "saturn", "uranus", "neptune"};
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        int totalCounter = 0;
        int[] vowelsCounter = new int[vowels.length];
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length(); j++) {
                for (int k = 0; k < vowels.length; k++) {
                    if (words[i].charAt(j) == vowels[k]) {
                        totalCounter++;
                        vowelsCounter[k]++;
                    }
                }
            }
        }
        System.out.println("總共有 " + totalCounter + " 個母音");
        String result = "";
        for (int o : vowelsCounter) {
            result += (o + " ");
        }
        System.out.println("a e i o u 分別有: ");
        System.out.println(result + "個");

    }

    public static void m4() {
        int[][] atmList = new int[][]{{25, 2500}, {32, 800}, {8, 500}, {19, 1000}, {27, 1200}};
        Scanner sca = new Scanner(System.in);
        int value;
        do {
            System.out.println("請輸入借款金額: ");
            if (!sca.hasNextInt()) {
                System.out.println("輸入有誤，請重新輸入...");
                sca.nextLine();
                continue;
            }
            value = sca.nextInt();
            break;
        } while (true);

        System.out.print("有錢可借的員工編號: ");
        int counter = 0;
        for (int i = 0; i < atmList.length; i++) {
            if (atmList[i][1] >= value) {
                System.out.print(atmList[i][0] + " ");
                counter++;
            }
        }
        if (counter == 0) {
            System.out.print(" null ... ");
        }
        System.out.println("共 " + counter + " 人!");
    }

    public static void m5() {

        // 思路
        // 總天數 = (月份 - 1) * 30 -(1 or 2) + n        + day
        //         baseMonth * 30  -f        + addDays + day

        Scanner sca = new Scanner(System.in);
        outer:
        do {
            int year, month, day;
            boolean isLeapYear = false;
            int[] date = new int[3]; // 儲存3組數字，代表年、月、日
            int f = -2; // 決定2月 -2天 或 -1天
            System.out.println("請輸入日期: ");
            for (int i = 0; i < date.length; i++) {
                if (!sca.hasNextInt()) {
                    System.out.println("請輸入數字！請重新輸入...");
                    sca.nextLine();
                    continue outer;
                }
                date[i] = sca.nextInt();
            }

            year = date[0];
            month = date[1];
            day = date[2];

            // 簡易判斷日期輸入
            if (year < 0 || month <= 0 || month > 12 || day > 31 || day <= 0 || (month == 2 && day > 29)) {
                System.out.println("日期輸入有誤！請重新輸入...");
                sca.nextLine();
                continue;
            }

            // 閏年判斷
            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                isLeapYear = true;

            }
            if (isLeapYear) {
                f++;
            } else {
                if (month == 2 && day > 28) {
                    System.out.println("日期輸入有誤！請重新輸入...");
                    sca.nextLine();
                    continue;
                }
            }

            // 1 & 2月先判斷
            int daysOfYear = 0;
            if (month == 2) {
                daysOfYear = 31 + day;
                System.out.println("輸入的日期為該年第 " + daysOfYear + " 天");
                break;
            } else if (month == 1) {
                daysOfYear = day;
                System.out.println("輸入的日期為該年第 " + daysOfYear + " 天");
                break;
            }

            // 月份是 31 or 30 天數計算

            int baseMonth = month - 1;
            int addDays = 1; // 1月: 31d
            int reset = 0; // 去掉多加的天數
            for (int i = 2; i <= month; i++) {
                if (i < 8) {
                    if (i % 2 != 0) {
                        addDays++;
                        reset = -1;
                    } else {
                        if (day > 30) {
                            System.out.println("月份與日期關係有誤！請重新輸入...");
                            sca.nextLine();
                            continue outer;
                        }
                        reset = 0;
                    }
                } else {
                    if (i % 2 == 0) {
                        addDays++;
                        reset = -1;
                    } else {
                        if (day > 30) {
                            System.out.println("月份與日期關係有誤！請重新輸入...");
                            sca.nextLine();
                            continue outer;
                        }
                        reset = 0;
                    }
                }
            }

            // 總天數計算
            daysOfYear = baseMonth * 30 + f + addDays + day + reset;
            System.out.println("輸入的日期為該年第 " + daysOfYear + " 天");
            break;

        } while (true);
    }

    public static void m5Plus() {
        Scanner sca = new Scanner(System.in);
        int year, month, day;
        outer:
        do {
            System.out.println("請輸入日期: ");
            int[] date = new int[3];
            for (int i = 0; i < date.length; i++) {
                if (!sca.hasNextInt()) {
                    System.out.println("請輸入數字！請重新輸入...");
                    sca.nextLine();
                    continue outer;
                }
                date[i] = sca.nextInt();
            }

            year = date[0];
            month = date[1];
            day = date[2];

            if (year < 0 || month <= 0 || month > 12 || day <= 0) {
                // 輸入有誤
                System.out.println("日期範圍輸入有誤！請重新輸入...");
                sca.nextLine();
                continue;
            }

            int[] monthDay = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            boolean isLeapYear = false;

            if (((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0)) {
                isLeapYear = true;
                monthDay[1] = 29;
            }

            if (day > monthDay[month - 1]) {
                // 輸入有誤
                System.out.println("月份與日期對應範圍有誤！請重新輸入...");
                sca.nextLine();
                continue;
            }

            int daysOfYear = 0;
            for (int i = 0; i < month - 1; i++) {
                daysOfYear += monthDay[i];
            }

            daysOfYear += day;

            System.out.println("輸入的日期為該年第 " + daysOfYear + " 天");
            break;

        } while (true);
    }

    public static void m6() {
        int[][] scores = new int[][]{
                {10, 35, 40, 100, 90, 85, 75, 70},
                {37, 75, 77, 89, 64, 75, 70, 95},
                {100, 70, 79, 90, 75, 70, 79, 90},
                {77, 95, 70, 89, 60, 75, 85, 89},
                {98, 70, 89, 90, 75, 90, 89, 90},
                {90, 80, 100, 75, 50, 20, 99, 75}
        };

        int[] list = new int[scores[0].length];
        for (int i = 0; i < scores.length; i++) {
            int[] temp = Arrays.copyOf(scores[i], scores[i].length);
            Arrays.sort(temp);
            for (int j = 0; j < scores[i].length; j++) {
                if (temp[temp.length - 1] == scores[i][j]) {
                    list[j]++;
                    // continue; 如果只有唯一的最高分
                }
            }
        }

        for (int i = 0; i < list.length; i++) {
            System.out.print(i + 1 + " 號: ");
            System.out.print(list[i] + " 次");
            System.out.println();
        }
    }
}
