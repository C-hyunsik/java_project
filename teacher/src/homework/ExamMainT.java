package homework;

import java.util.Scanner;


public class ExamMainT {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
        System.out.print("인원수 입력 : ");
        int size = scan.nextInt();
        
        ExamT[] ar = new ExamT[size];
        for (int i = 0; i < size; i++) {
            ar[i] = new ExamT();
            ar[i].compare();
        }//for i
        
        //출력
        System.out.println();
        System.out.println("이름\t1 2 3 4 5\t점수");
        for (int i = 0; i < size; i++) {
        	System.out.print(ar[i].getName()+"\t");
        	
        	for(int j = 0; j < ar[i].getOx().length; j++) {
	            System.out.print(ar[i].getOx()[j] + " ");
        	}//for j
        	
	        System.out.println("\t" + ar[i].getScore());
        
        }
     scan.close();   
	}

}
