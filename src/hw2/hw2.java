package hw2;

public class hw2 {
	
	public static void main(String[] args) {

		// 1. • 請設計一隻Java程式,計算1~1000的偶數和 (2+4+6+8+...+1000)
		int sum1 = 0;
		for(int i = 1; i <= 1000; i++){
		    if(i % 2 == 0) {
		        sum1 += i;
		    }
		}

//		        int sum2 = 0;
//		        for(int i = 2; i <= 1000; i+=2) {
//		            sum2 += i;
//		        }

		System.out.println("偶數和：" + sum1);
		//System.out.println("偶數和：" + sum2);

		System.out.println("===");
		// • 請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用for迴圈)
		//   可變化：n * (n+1) * (n+2)... ~ 10
		int product = 1;
		for(int i = product + 1; i <= 10; i++) {
		    product *= i;
		}
		System.out.println("連乘積(for)：" + product);

		System.out.println("===");

		// • 請設計一隻Java程式,計算1~10的連乘積 (1*2*3*...*10) (用while迴圈)
		int count = 1, product_ = 1;
		while(count <= 10) {
		    product_ *= count;
		    count++;
		}
		System.out.println("連乘積(while)：" + product_);

		System.out.println("===");

		// • 請設計一隻Java程式,輸出結果為以下:
		//   1 4 9 16 25 36 49 64 81 100
		//   1 2 3 4 5 6 7 8 9 10
		for(int i = 1; i <= 10; i++) {
		    System.out.print(i * i + " ");
		}

		System.out.println("\n===");
		// • 阿文很熱衷大樂透 (1 ~ 49),但他不喜歡有4的數字,不論是個位數或是十位數。請設計一隻程式,
		//   輸出結果為阿文可以選擇的數字有哪些?總共有幾個?
		//   (0 ~ 4) * 10 + 0 ~ 9 * 1
		int numCounter = 0;
		for(int i = 0; i <= 4; i++) {
		    if(i == 4) {
		        break;
		    }
		    for(int j = 0; j <= 9; j++) {
		        if(j == 4) {
		            continue;
		        }
		        int result = (i * 10) + j;
		        if(result == 0) {
		            continue;
		        }
		        System.out.printf(result + " ");
		        numCounter++;
		    }
		}
		System.out.println("\n總共有 " + numCounter + " 個");

//		        int numCounter2 = 0;
//		        for(int i = 1; i <= 49; i++) {
//		            if(i / 10 != 4 && i % 10 != 4) {
//		                System.out.print(i + " ");
//		                numCounter2++;
//		            }
//		        }
//		        System.out.println("\n總共有 " + numCounter2 + " 個");


		System.out.println("===");
		// • 請設計一隻Java程式,輸出結果為以下:
		//   1 2 3 4 5 6 7 8 9 10
		//   1 2 3 4 5 6 7 8 9
		//   1 2 3 4 5 6 7 8
		//   1 2 3 4 5 6 7
		//   1 2 3 4 5 6
		//   1 2 3 4 5
		//   1 2 3 4
		//   1 2 3
		//   1 2
		//   1
		for(int i = 10; i >= 1; i--) {
		    for(int j = 1; j <= i; j++) {
		        System.out.print(j + " ");
		    }
		    System.out.println();
		}

//		        for(int i = 1; i <= 10; i++) {
//		            for(int j = 1; j <= 10 - i + 1; j++) {
//		                System.out.print(j + " ");
//		            }
//		            System.out.println();
//		        }

		System.out.println("===");
		// • 請設計一隻Java程式,輸出結果為以下:
		//   A
		//   BB
		//   CCC
		//   DDDD
		//   EEEEE
		//   FFFFFF


		char c = 'A';
		for(int i = 1; i <= 6; i++) {
		    for(int j = 1; j <= i; j++) {
		        System.out.print(c);
		    }
		    System.out.println();
		    c++;
		}

//		        for(char ch = 'A'; ch <= 'F'; ch++) {
//		            for(char n = 'A'; n <= ch; n++) {
//		                System.out.print(ch);
//		            }
//		            System.out.println();
//		        }

	}

}
