package BankApplication;

public class VIPClient extends Client implements BankService {
	//檜濠徽
	@Override 
	public int CheckBalance() {
		
		return this.getBalance();
	}
	
	@Override
	public void Deposit(int AmountMoney) {
		System.out.println("辦熱堅偌");
		setBalance(getBalance()+AmountMoney);
		
	}
	
	@Override
	public void Withdraw(int AmountMoney) {		
		System.out.println("辦熱堅偌");
		setBalance(getBalance() - AmountMoney);
	}
}
