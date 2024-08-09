class NumberTest {
	public static void main(String[] args) {
		System.out.println(25 + 3);
		System.out.println("25" + "3");			//결합
		System.out.println("25 + 3");
		System.out.println("25 + 3 = "  + 25 + 3);	//결합 + 결합
		System.out.println("25 + 3 = "  + (25 + 3));
		System.out.println();
		System.out.println("26 + 3 = " + (26 + 3));
		System.out.println("26 - 3 = " + (26 - 3));
		System.out.println("26 * 3 = " + (26 * 3));
		System.out.println("26 / 3 = " + (26 / 3));
		System.out.println("26 / 3 = " + (26. / 3));
		System.out.println("26 / 3 = " + String.format("%.2f", (26. / 3))); //소수점 둘째자리
		System.out.println("26 % 3 = " + (26 % 3));
	}
}