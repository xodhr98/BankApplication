package BankApplication;

public interface BankService {
	//interface�� BankService�� ������ �޼ҵ忡 ���� ���Ǹ� ���ش�
	public int CheckBalance();
	void Deposit(int AmountMoney);
	void Withdraw(int AmountMoney);

}
