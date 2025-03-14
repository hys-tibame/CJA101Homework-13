package hw1;

public class hw1 {
	
	public static void main(String[] args) {
		
		//1. 請設計一隻Java程式,計算12,6這兩個數值的和與積
		System.out.println("---第一題---");
		int a = 12, b = 6;
		int sum = a + b, product = a * b;
		System.out.println("和 = " + sum + ", 積 = " + product);

		//2. 請設計一隻Java程式,計算200顆蛋共是幾打幾顆? (一打為12顆)
		System.out.println("---第二題---");
		int eggs = 200;
		int dozenCount = eggs / 12, leftCount = eggs % 12;
		System.out.println(eggs + " 顆蛋，共是 " + dozenCount + " 打又 " + leftCount + " 顆");

		//3. 請由程式算出256559秒為多少天、多少小時、多少分與多少秒
		System.out.println("---第三題---");
		int inputSec = 256559;
		int minuteSec = 60, hourSec = minuteSec * 60, daySec = hourSec * 24;
		int dayCount = inputSec / daySec;
		int leftSec = inputSec % daySec;
		int hourCount = leftSec / hourSec;
		leftSec %= hourSec;
		int minuteCount = leftSec / minuteSec;
		leftSec %= minuteSec;
		int secCount = leftSec;
		System.out.printf("%d 秒為 %d 天 %d 小時 %d 分 %d 秒 %n", inputSec, dayCount, hourCount, minuteCount, secCount);

		//4. 請定義一個常數為3.1415(圓周率),並計算半徑為5的圓面積與圓周長
		System.out.println("---第四題---");
		final double PI = 3.1415;
		double radius = 5;
		double area = radius * radius * PI, circumference = 2 * radius * PI;
		System.out.printf("半徑為 %.1f 的圓面積為 %.4f , 圓周長為 %.4f %n", radius, area, circumference);

		//5. 某人在銀行存入150萬,銀行利率為2%,如果每年利息都繼續存入銀行,請用程式計算10年後,本
		//   金加利息共有多少錢 (用複利計算,公式請自行google)
		//   本利和 = 本金 × (1 + 年利率) ^ 期間
		System.out.println("---第五題---");
		double depositBefore = 1_500_000;
		double apr = 0.02;
		int depositYear = 10;
		double depositAfter = depositBefore * Math.pow((1 + apr), depositYear);
		System.out.printf("存入 %.2f 元, 銀行利率為 %.2f , 經過 %d 年後, 本金加上利息共有 %.2f 元 %n", depositBefore, apr, depositYear, depositAfter);

		//6. 請寫一隻程式,利用System.out.println()印出以下三個運算式結果:
		//   5 + 5
		//   5 + ‘5’
		//   5 + “5”
		//   並請用註解各別說明答案的產生原因
		System.out.println("---第六題---");
		System.out.println(5 + 5); // int + int, 結果為int（10）
		System.out.println(5 + '5'); // int + char, char自動轉型成int進行運算, 結果為 5 + 53 = 58
		System.out.println(5 + "5"); // int + String, +號遇上字符串，成為字符串拼接運算, 結果為 "55"
		
	}

}
