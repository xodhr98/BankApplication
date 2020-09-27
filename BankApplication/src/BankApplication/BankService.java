package BankApplication;

public interface BankService {
	//interface인 BankService는 간단히 메소드에 대한 정의만 해준다
	public int CheckBalance();
	void Deposit(int AmountMoney);
	void Withdraw(int AmountMoney);

}
