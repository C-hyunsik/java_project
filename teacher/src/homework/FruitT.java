package homework;

//1인분
public class FruitT {

	private String pum;
	private int jan, feb, mar, tot;
	private static int sumJan, sumFeb, sumMar, sumTot;
	
	public FruitT(String pum, int jan, int feb, int mar) {
		
		this.pum = pum;
		this.jan = jan; 
		this.feb = feb;
		this.mar = mar;
	}
	
	public void calcTot() {
		tot = jan + feb + mar;
		sumJan += jan;
		sumFeb += feb;
		sumMar += mar;
		sumTot += tot;
	}
	public void display() {
		System.out.println(pum + "\t" + jan + "\t" + feb + "\t" + mar + "\t" + tot);
	}
	public static void output() {
		System.out.println("월별합계\t" + sumJan + "\t" + sumFeb + "\t" + sumMar + "\t" + sumTot);
	}
}
/*
과일 판매량 구하기
월별 매출합계도 구하시오

[클래스]
Fruit
[필드]
pum, jan, feb, mar, tot
sumJan, sumFeb, sumMar
[메소드]
생성자(품명, 1월, 2월, 3월)
calcTot()
display()
public static void output()

[클래스]
FruitMain

[실행결과]
---------------------------------------
PUM      JAN      FEB      MAR      TOT
---------------------------------------
사과      100      80       75       255
포도       30      25       10       xxx
딸기       25      30       90       xxx
---------------------------------------
월별합계   xxx      xxx      xxx            output()로 처리
*/