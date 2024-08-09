package personal;
import java.util.Scanner;

public class Rock_Sissor_Paper_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int baseBatt = 1000;

        while (true) {
        	int com = (int) (Math.random() * 3 + 1);
        	System.out.println(com);
        	
            System.out.print("가위(1), 바위(2), 보자기(3) 입력: ");
            int pl = sc.nextInt();

            System.out.print("베팅 금액: ");
            int batt = sc.nextInt();

            if (batt < 0) {
                System.out.println("베팅 금액은 음수가 될 수 없습니다.");
                continue;
            }
            if (batt > baseBatt) {
                System.out.println("보유 금액보다 많은 금액을 베팅할 수 없습니다.");
                continue;
            }

            String com1 = "";
            switch (com) {
                case 1:
                    com1 = "가위";
                    break;
                case 2:
                    com1 = "바위";
                    break;
                case 3:
                    com1 = "보자기";
                    break;
            }
            String pl1 = "";
            switch (pl) {
                case 1:
                    pl1 = "가위";
                    break;
                case 2:
                    pl1 = "바위";
                    break;
                case 3:
                    pl1 = "보자기";
                    break;
            }

            if (com == pl) {
                System.out.println("컴퓨터는 " + com1 + " 나도 " + pl1);
                System.out.println("ᅳ_ᅳ 비겼다");
                System.out.println("현재 금액은 " + baseBatt + "원");
            } else if ((com == 1 && pl == 2) || (com == 2 && pl == 3) || (com == 3 && pl == 1)) {
                System.out.println("컴퓨터는 " + com1 + " 나는 " + pl1);
                System.out.println("^^b 이겼다!");
                baseBatt += batt;
                System.out.println("현재 금액은 " + baseBatt + "원");
            } else if ((com == 1 && pl == 3) || (com == 2 && pl == 1) || (com == 3 && pl == 2)) {
                System.out.println("컴퓨터는 " + com1 + " 나는 " + pl1);
                System.out.println("ᅲ^ᅲ.. 졌다");
                baseBatt -= batt;
                System.out.println("현재 금액은 " + baseBatt + "원");
            }

            if (baseBatt <= 0) {
                System.out.println("잔액이 부족하여 게임을 종료합니다.");
                break;
            }
        }
        sc.close();
    }
}