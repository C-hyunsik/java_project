package classhomework;

import java.util.Scanner;

public class MemberServiceT {
	private MemberDTOT[] ar = new MemberDTOT[5];
	private Scanner scan = new Scanner(System.in);
	
	public MemberServiceT() {
		System.out.println("MemberServiceT 기본 생성자");
	}
	public void menu() {
		int num;
		
		while(true) {
			System.out.println();
			System.out.println("*************");
			System.out.println("\t1. 가입");
			System.out.println("\t2. 출력");
			System.out.println("\t3. 수정");
			System.out.println("\t4. 탈퇴");
			System.out.println("\t5. 끝내기");
			System.out.println("*************");
			System.out.print("번호 : ");
			num = scan.nextInt();
			
			if(num == 5) break;
			if(num == 1) this.insert();
			else if(num == 2) this.list();
			else if(num == 3) this.update();
			else if(num == 4) this.delete();
		}//while
	}//menu()
	
	public void insert() {
		int i;
		for(i  = 0; i < ar.length; i++) {
			if(ar[i] == null) break;
		}//for i
		if(i == ar.length) {
			System.out.println(ar.length + "명의 정원이 꽉 찼습니다.");
			return;		//메소드를 벗어나라
		}
		ar[i] = new MemberDTOT();
		System.out.print("이름 입력 : ");
		ar[i].setName(scan.next());
		System.out.print("나이 입력 : ");
		ar[i].setAge(scan.nextInt());
		System.out.print("핸드폰 입력 : ");
		ar[i].setPhone(scan.next());
		System.out.print("주소 입력 : ");
		ar[i].setAddress(scan.next());
		
	}//insert()
	public void list() {
		System.out.println();
		for(MemberDTOT dto : ar) {
			if(dto != null)
			System.out.println(dto.getName() + "\t"
							   + dto.getAge() + "\t"
							   + dto.getPhone() + "\t"
							   + dto.getAddress());
		}
	}//list()
	public void update() {
		System.out.println();
		System.out.print("핸드폰 번호 입력 :");
		String phone = scan.next();
		
		int i;
		for(i = 0; i < ar.length; i++) {
			if(ar[i].getPhone().equals(phone)) {
				System.out.println(ar[i].getName() + "\t"
						   + ar[i].getAge() + "\t"
						   + ar[i].getPhone() + "\t"
						   + ar[i].getAddress());
				System.out.println();
				System.out.print("수정 할 이름 입력 : ");
				ar[i].setName(scan.next());
				System.out.print("수정 할 나이 입력 : ");
				ar[i].setAge(scan.nextInt());
				System.out.print("수정 할 핸드폰 입력 : ");
				ar[i].setPhone(scan.next());
				System.out.print("수정 할 주소 입력 : ");
				ar[i].setAddress(scan.next());
				System.out.println("\n회원의 정보를 수정하였습니다.");
				break;
			}
		}//for i
		if( i == ar.length)
			System.out.println("찾는 회원이 없습니다.");
	}//update()
	public void delete() {
		System.out.println();
		System.out.print("핸드폰 번호 입력 :");
		String phone = scan.next();
		
		int i;
		for(i = 0; i < ar.length; i++) {
			if(ar[i].getPhone().equals(phone)) {
				
				System.out.println();
				ar[i] = null;
				System.out.println("\n회원의 정보를 삭제하였습니다.");
				break;
			}
		}//for i
		if( i == ar.length)
			System.out.println("찾는 회원이 없습니다.");
	}//delete()
	
}
