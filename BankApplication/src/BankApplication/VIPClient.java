package BankApplication;

public class VIPClient extends Client implements BankService {
	//������
	@Override 
	public int CheckBalance() {
		
		return this.getBalance();
	}
	
	@Override
	public void Deposit(int AmountMoney) {
		System.out.println("�����");
		setBalance(getBalance()+AmountMoney);
		
	}
	
	@Override
	public void Withdraw(int AmountMoney) {		
		System.out.println("�����");
		setBalance(getBalance() - AmountMoney);
	}
}
