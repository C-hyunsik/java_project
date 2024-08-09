package personal;

public class Gugudan {

	public static void main(String[] args) {
		int dan;
		int i, j;
		for(j = 2; j <=8;j+=3) {					//j = 1, j = 2, j = 3 또는 j = 2, j = 5 , j = 8
			for( i = 1; i <=9; i++) {
				for( dan = j; dan<=j+2; dan++ ) {	//j를 이용해서 2~4단 5~7단 8~10단 출력
					
					if(dan != 10) {					//10단 제외
						System.out.print(dan + "*"+ i + "=" + dan * i + "\t");
					}
					
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
