package BankApplication;

public class Client implements BankService { //�Ϲ�Ŭ������ �����Ѵ�, BankService �������̽��� �������ش�
	private int AccountNum; //���¹�ȣ, �̸�, 
	private String Name;
	private int Balance;
	private String Grade;
	private int interest_rate; // ������
	
	public int getAccountNum() {
		return AccountNum;
	}
	
	public void setAccountNum(int accountNum) {
		AccountNum = accountNum;
	}
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	
	public int getBalance() {
		return Balance;
	}
	
	public void setBalance(int balance) {
		Balance = balance;
	}
	
	public String getGrade() {
		return Grade;
	}
	
	public void setGrade(String grade) {
		Grade = grade;
	}
	
	public int getInterest_rate() {
		return interest_rate;
	}
	
	public void setInterest_rate(int interest_rate) {
		this.interest_rate = interest_rate;
	}
	//BankService �������̽��� �ִ� 3���� �޼ҵ带 ������ ��� �������ش�.
	@Override
	public int CheckBalance() {		
		return 0;
	}
	
	@Override
	public void Deposit(int AmountMoney) {
	}
	
	@Override
	public void Withdraw(int AmountMoney) {
	}

}
