package example;

public class OperatorExample {
	public static void main(String[] args) {
		//245678초를 일시분초 형식으로 변환하여 출력하세요.
		int totSec=245678;
		
		int day=totSec/(60*60*24);
		int hour=(totSec-day*60*60*24)/(60*60);
		int min=(totSec-day*60*60*24-hour*3600)/(60);
		int sec=totSec%60;
		
		System.out.print("잔여시간은");
		System.out.println(day+"일"+hour+"시간"+min+"분"+sec+"초");

		System.out.println("===============================================");
		//한대의 가격이 1억 5천원만인 비행기를 20대 구매할 경우 지불해야될 금액을 계산하여 출력하세요. 
		//단, 15대 이상 구매할 경우 1대당 25%의 할인율을 적용하여 계산하세요.
		//삼항연산자 ,Long 변수 사용
		int airplane=150_000_000;
		int buyer=10;
		double salePercent=0.75;
		long sale=(long)(airplane*salePercent*buyer);
		
		
		System.out.println("할인가능여부"+(buyer>=15?"가능":"불가능"));
		System.out.println("구매희망수량 = "+buyer);
		System.out.println("할인이 적용된 가격 = "+sale+"원");
		
		
		
		
		System.out.println("===============================================");
	}
}