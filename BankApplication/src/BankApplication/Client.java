package BankApplication;

public class Client implements BankService { //일반클래스로 정의한다, BankService 인터페이스를 구현해준다
	private int AccountNum; //계좌번호, 이름, 
	private String Name;
	private int Balance;
	private String Grade;
	private int interest_rate; // 이자율
	
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
	//BankService 인터페이스에 있는 3개의 메소드를 정의한 대로 구현해준다.
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
