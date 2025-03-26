package hw5;

import java.util.Arrays;
import java.util.Scanner;

public class hw5 {
    public static void main(String[] args) {
//        請設計一個方法為starSquare(int width, int height)，當使用者鍵盤輸入寬與高時，即會印出對應的*長方形，如 圖：


       m1();


//        請設計一個方法為randAvg(),從10個 0~100(含100)的整數亂數中取平均值並印出這10個亂數與平均值,如圖:


//       m2_randAvg();


//        利用Overloading,設計兩個方法int maxElement(int x[][])與double maxElement(double x[][]),
//        可以找出二維陣列的最大值並回傳,如圖:


//       m3();


//        請設計一個類別MyRectangle...


//       m4 -> "請移步至MyRectangle類"


//        身為程式設計師的你,收到一個任務,要幫系統的註冊新增驗證碼的功能,請設計一個方法
//        genAuthCode(),當呼叫此方法時,會回傳一個8位數的驗證碼,此驗證碼內容包含了英文大小寫
//        與數字的亂數組合,如圖:


//        m5_genAuthCode();


    }


    public static void m1() {
        Scanner sca = new Scanner(System.in);
        int[] value = new int[2];
        outer:
        do {
            System.out.println("請輸入寬與高: ");

            for (int i = 0; i < 2; i++) {
                if (!sca.hasNextInt()) {
                    System.out.println("輸入有誤，請重新輸入...");
                    sca.nextLine();
                    value = new int[2];
                    continue outer;
                }
                value[i] = sca.nextInt();
            }
            break;
        } while (true);
        startSquare(value[0], value[1]);
    }


    public static void startSquare(int width, int height) {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }


    public static void m2_randAvg() {
        int sum = 0;
        int count = 10;

        System.out.println("本次亂數結果: ");
        for (int i = 0; i < count; i++) {
            int r = (int) (Math.random() * 101);
            System.out.print(r + " ");
            sum += r;
        }
        System.out.println();
        System.out.println(sum / count); // 無小數點
    }

    public static void m3() {
        int[][] intArray = {
                {1, 6, 3},
                {9, 5, 2}
        };

        double[][] doubleArray = {
                {1.2, 3.5, 2.2},
                {7.4, 2.1, 8.2}
        };

        System.out.println(maxElement(intArray));
        System.out.println(maxElement(doubleArray));
    }

    public static int maxElement(int x[][]) {
        int[] temp = new int[x.length];
        for (int i = 0; i < x.length; i++) {
            Arrays.sort(x[i]);
            temp[i] = x[i][x[i].length - 1];
        }
        Arrays.sort(temp);
        return temp[temp.length - 1];
    }

    public static double maxElement(double x[][]) {
        double[] temp = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            Arrays.sort(x[i]);
            temp[i] = x[i][x[i].length - 1];
        }
        Arrays.sort(temp);
        return temp[temp.length - 1];
    }

    public static void m5_genAuthCode() {
        char[] codes = new char[62];
        int count = 0;
        for (char c = '0'; c <= '9'; c++) {
//            System.out.print(c);
            codes[count] = c;
            count++;
        }

        for (char c = 'a'; c <= 'z'; c++) {
//            System.out.print(c);
            codes[count] = c;
            count++;
        }

        for (char c = 'A'; c <= 'Z'; c++) {
//            System.out.print(c);
            codes[count] = c;
            count++;
        }

        System.out.println("本次隨機產生驗證碼為: ");

        for (int i = 0; i < 8; i++) {
            int r = (int)(Math.random() * 62);
            System.out.print(codes[r]);
        }
    }


}

