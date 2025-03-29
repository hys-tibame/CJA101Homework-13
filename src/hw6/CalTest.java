package hw6;

import java.util.Scanner;

public class CalTest {

    public static void main(String[] args) {

        Calculator calculator = new Calculator();
        Scanner sca = new Scanner(System.in);

        while (true) {
            int x, y;
            System.out.println("請輸入x的值： ");
            if(!sca.hasNextInt()) {
                System.out.println("輸入格式不正確");
                sca.nextLine();
                continue;
            }
            x = sca.nextInt();
            sca.nextLine();
            System.out.println("請輸入y的值： ");
            if(!sca.hasNextInt()) {
                System.out.println("輸入格式不正確");
                sca.nextLine();
                continue;
            }
            y = sca.nextInt();
            sca.nextLine();

            try {
                calculator.powerXY(x, y);
                break;
            } catch (CalException e) {
                System.out.println(e.getMessage());
            }

        }



    }
}
