package BankApplication;
//Client의 상속을 받았고 BankService를 implements 해준다.
public class OrdinaryClient extends Client implements BankService{

	@Override 
	public int CheckBalance() { // 시간에 대한 개념
		
		
		return this.getBalance();
	}
	@Override
	public void Deposit(int AmountMoney) { //입금
		System.out.println("일반고객");
		setBalance(getBalance()+AmountMoney);
		//+을 이용하여 setBalance 해준다.
		
	}
	
	@Override
	public void Withdraw(int AmountMoney) { //출금
		System.out.println("일반고객");
		setBalance(getBalance() - AmountMoney);
		// -를 이용하여  setBalance 해준다.
	}
}
