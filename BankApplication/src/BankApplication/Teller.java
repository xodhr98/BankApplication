package BankApplication;

import java.util.Scanner;

public class Teller {
	
	static Bank BankObj = new Bank();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); // scanner ��ü�� ����
		
		System.out.println("�������࿡ ���� ���� ȯ���մϴ�");
		
		while(true) { // ���¹�ȣ�� �Է¹ް� ó���ϴ� loop�� �ݺ�
			System.out.println("���񽺸� ���� ���¹�ȣ�� �Է����ּ���.");
			int acc_num = sc.nextInt();
			
			CallBankService(acc_num);
		}
	}
	
	static void CallBankService(int AccNum) { //�������� ����ó�� AccoNum
		
		Scanner sc = new Scanner(System.in);
		Client CliObj = null;
		CliObj = BankObj.GetRecord(AccNum); //������ �ߴ� bank Ŭ������ ��ü��
		
		System.out.println("���Ͻô� ���� ��ȣ�� �Է��� �ּ���.");
		System.out.println("1.�ܰ�Ȯ��  2.�Ա�  3.���  ");
		int command = sc.nextInt(); //��¾ �Է¹��� ( 1,2,3 �� �ϳ� )
		
		if(command == 1) { // �ܰ�Ȯ�� ( CliObj �����ִ� ������ ������
			System.out.println("���¹�ȣ : " + CliObj.getAccountNum() + "�ܰ�: "+ CliObj.getBalance());
			
		}
		else if(command == 2) { //�Ա��� �ݾ��� �߰��� ����
			System.out.println("�Ա� �ݾ��� �Է��ϼ���.");
			int AmountMoney = sc.nextInt();
			
			CliObj.Deposit(AmountMoney); //AmountMoney�� �޾Ƽ� Deposit ��� �޼ҵ带 ���� ������.
			
			System.out.println("���¹�ȣ : " + CliObj.getAccountNum() + "�ܰ�: "+ CliObj.getBalance());
			BankObj.Commit(CliObj); // ������Ʈ �� �ܰ���� ������ �����ͺ��̽��� ������Ʈ��
			
		}
		else if(command == 3) {
			System.out.println("��� �ݾ��� �Է��ϼ���.");
			int AmountMoney = sc.nextInt();
			
			CliObj.Withdraw(AmountMoney); //���
			
			System.out.println("���¹�ȣ : " + CliObj.getAccountNum() + "�ܰ�: "+ CliObj.getBalance());
			
			BankObj.Commit(CliObj); // �����ͺ��̽��� ���� ������Ʈ ����
		}
	}
}
