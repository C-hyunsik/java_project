package sungJukRe;

public class SungJukDTO implements Comparable<SungJukDTO>{
	private int no, kor, eng, math, tot;
	private double avg;
	private String name;
	
	public SungJukDTO() {}
	
	public SungJukDTO(int no, String name, int kor, int eng, int math) {
		super();
		this.no = no;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getTot() {
		return tot;
	}

	public void setTot(int tot) {
		this.tot = tot;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void calc() {
		tot = kor + eng + math;
		avg = tot / 3;
	}
	@Override
	public String toString() {
		return no + "\t" + name + "\t" + kor + "\t" + eng + "\t" + math + "\t" + tot + "\t" + avg;
	}

	@Override
	public int compareTo(SungJukDTO sungJukDTO) {
		if(this.tot > sungJukDTO.tot) return -1;
		else if(this.tot < sungJukDTO.tot) return 1;
		else return 0;
		
	}
	
}
/*
[문제] 성적처리

1. 필드로 번호(no), 이름(name), 국어(kor), 영어(eng), 수학(math), 총점(tot), 평균(avg) 잡는다
2. 번호 입력할 때 중복해서 넣지 않는다.
3. 1인분의 클래스로 SungJukDTO.java 사용한다.
4. SungJukDTO.java 에서 toString() Override 한다.
   toString()에서 평균은 소수이하 2째자리까지 한다.
   
   생성자
   setter / getter 메소드
   calc() - 총점과 평균을 계산한다.
   
5. 입력, 출력, 수정, 삭제, 소트하는 클래스는 반드시 interface를 상속받는다.
6. menu() 작성한다.
   만약에 1 ~ 6번 외의 숫자가 들어오면 "1~6중에 선택하세요" 메세지를 출력 후 다시 입력받는다.
   1. 입력
   2. 출력
   3. 수정
   4. 삭제
   5. 정렬
   6. 끝

7. SungJukInsert.java
- 번호, 이름, 국어, 영어, 수학를 입력하여 총점과 평균을 계산한다.

번호 입력 : 
이름 입력 : 
국어 입력 : 
영어 입력 : 
수학 입력 : 

입력되었습니다

8. SungJukPrint.java
- ArrayList에 저장된 모든 데이터를 출력한다.
 
번호	이름	국어	영어	수학	총점	평균

9. SungJukUpdate.java
- 없는 번호가 입력되면 "잘못된 번호 입니다." 라고 출력한다.
- 있는 번호가 입력되면 번호에 해당하는 데이틀 출력 후 수정한다.
  수정한 후에는 총점과 평균을 재계산해야 한다.

번호 입력 : 
잘못된 번호 입니다.

또는 

번호	이름	국어	영어	수학	총점	평균

수정 할 이름 입력 : 
수정 할 국어 입력 : 
수정 할 영어 입력 : 
수정 할 수학 입력 : 

수정하였습니다.

10. SungJukDelete.java
- 이름을 입력하여 없는 이름이면 "회원의 정보가 없습니다" 출력하시오
- 똑같은 이름이 있으면 모두 삭제한다.
- remove

삭제할 이름 입력 : 천사
회원의 정보가 없습니다

또는 

x건의 항목을 삭제하였습니다.

11. SungJukSort.java
- menu() 작성한다.

********************
  1. 총점으로 내림차순
  2. 이름으로 오름차순
  3. 이전 메뉴
********************
  번호 : 
*/
