package sungJukT;

public class SungJukDTOT implements Comparable<SungJukDTOT>{
	private int no;
	private String name;
	private int kor;
	private int eng;
	private int math;
	private int tot;
	private double avg;
	public SungJukDTOT() {}
	public SungJukDTOT(int no, String name, int kor, int eng, int math) {
		super();
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}
	public void setNo(int no) {
		this.no = no;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setKor(int kor) {
		this.kor = kor;
	}
	
	public void setEng(int eng) {
		this.eng = eng;
	}
	
	public void setMath(int math) {
		this.math = math;
	}
	
	public void setTot(int tot) {
		this.tot = tot;
	}
	
	public void setAvg(double avg) {
		this.avg = avg;
	}
	
	public int getNo() {
		return no;
	}
	
	public String getName() {
		return name;
	}
	
	public int getKor() {
		return kor;
	}
	
	public int getEng() {
		return eng;
	}
	
	public int getMath() {
		return math;
	}
	
	public int getTot() {
		return tot;
	}
	
	public double getAvg() {
		return avg;
	}
	public void calc() {
		tot = kor + eng + math;
		avg = tot / 3.0;
	}
	@Override
	public String toString() {
		return no + "\t"
				+ name + "\t"
				+ kor + "\t"
				+ eng + "\t"
				+ math + "\t"
				+ tot + "\t"
				+ String.format("%.2f",avg);
	}
	@Override
	public int compareTo(SungJukDTOT sungJukDTOT) {
		//총점으로 내림차순
		if(this.tot > sungJukDTOT.tot) return -1;
		
		else if(this.tot < sungJukDTOT.tot) return 1;
		else return 0;
	}
	
}
