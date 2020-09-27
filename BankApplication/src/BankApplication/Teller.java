package BankApplication;

import java.util.Scanner;

public class Teller {
	
	static Bank BankObj = new Bank();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // scanner 객체를 만듬
		
		System.out.println("오리은행에 오신 것을 환영합니다");
		
		while(true) { // 계좌번호를 입력받고 처리하는 loop을 반복
			System.out.println("서비스를 위해 계좌번호를 입력해주세요.");
			int acc_num = sc.nextInt();
			
			CallBankService(acc_num);
		}
	}
	
	static void CallBankService(int AccNum) { //전반적인 업무처리 AccoNum
		
		Scanner sc = new Scanner(System.in);
		Client CliObj = null;
		CliObj = BankObj.GetRecord(AccNum); //이전에 했던 bank 클래스의 객체임
		
		System.out.println("원하시는 서비스 번호를 입력해 주세요.");
		System.out.println("1.잔고확인  2.입금  3.출금  ");
		int command = sc.nextInt(); //명력어를 입력받음 ( 1,2,3 중 하나 )
		
		if(command == 1) { // 잔고확인 ( CliObj 갖고있는 정보를 가져옴
			System.out.println("계좌번호 : " + CliObj.getAccountNum() + "잔고: "+ CliObj.getBalance());
			
		}
		else if(command == 2) { //입금할 금액을 추가로 받음
			System.out.println("입금 금액을 입력하세요.");
			int AmountMoney = sc.nextInt();
			
			CliObj.Deposit(AmountMoney); //AmountMoney를 받아서 Deposit 라는 메소드를 통해 저축함.
			
			System.out.println("계좌번호 : " + CliObj.getAccountNum() + "잔고: "+ CliObj.getBalance());
			BankObj.Commit(CliObj); // 업데이트 된 잔고들을 가지고 데이터베이스를 업데이트함
			
		}
		else if(command == 3) {
			System.out.println("출금 금액을 입력하세요.");
			int AmountMoney = sc.nextInt();
			
			CliObj.Withdraw(AmountMoney); //출금
			
			System.out.println("계좌번호 : " + CliObj.getAccountNum() + "잔고: "+ CliObj.getBalance());
			
			BankObj.Commit(CliObj); // 데이터베이스의 값을 업데이트 해줌
		}
	}
}
