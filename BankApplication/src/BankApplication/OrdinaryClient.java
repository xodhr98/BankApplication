package BankApplication;
//Client�� ����� �޾Ұ� BankService�� implements ���ش�.
public class OrdinaryClient extends Client implements BankService{

	@Override 
	public int CheckBalance() { // �ð��� ���� ����
		
		
		return this.getBalance();
	}
	@Override
	public void Deposit(int AmountMoney) { //�Ա�
		System.out.println("�Ϲݰ�");
		setBalance(getBalance()+AmountMoney);
		//+�� �̿��Ͽ� setBalance ���ش�.
		
	}
	
	@Override
	public void Withdraw(int AmountMoney) { //���
		System.out.println("�Ϲݰ�");
		setBalance(getBalance() - AmountMoney);
		// -�� �̿��Ͽ�  setBalance ���ش�.
	}
}
