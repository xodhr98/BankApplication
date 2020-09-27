package BankApplication;

import java.sql.*;


public class Bank {
	
	private Connection con;
	
    public static Connection makeConnection()
    {
          String url = "jdbc:mysql://localhost/bank_db";
          String id = "root";
          String password = "apmsetup";
          Connection con = null;
          try {
                 Class.forName("com.mysql.jdbc.Driver"); //JDBC ����̺� ����
                 System.out.println("����̹� ���� ����");
                 con = DriverManager.getConnection(url, id, password); //DataBase ����
                 System.out.println("�����ͺ��̽� ���� ����");
          } catch (ClassNotFoundException e) {
                 System.out.println("����̹��� ã�� �� �����ϴ�.");
          } catch (SQLException e) {
                 System.out.println("���ῡ �����Ͽ����ϴ�.");
          }
          return con;
    }

	public Client GetRecord(int Account_Num) {
		con = makeConnection(); //connection�� �δ´�
		
		Client CliObj = null; // ��ü ������ �Ͽ� null�� �ʱ�ȭ���ش�
		
		try {
			Statement stmt = con.createStatement(); //�����ͺ��̽��� ������ ������ statement�� ����
			String s = "select * from bankaccount where Account_Num = " + Account_Num;
			ResultSet rs = stmt.executeQuery(s); //�Է¹��� ���¹�ȣ�� ������ �����ͺ��̽��� ���ڵ带 ������
			while(rs.next()) { // ������ ���ڵ带 �� �پ� ó���ؾ���.
				
				if(rs.getString("Grade").equals("Ordinary"))
					CliObj = new OrdinaryClient(); //Ordinary�� ���� ��ü�� �޶���
				else 
					CliObj = new VIPClient();
				
				CliObj.setAccountNum(rs.getInt("Account_Num"));
				CliObj.setBalance(rs.getInt("Balance"));
				CliObj.setName(rs.getString("Name"));
				CliObj.setGrade(rs.getString("Grade"));
				CliObj.setInterest_rate(rs.getInt("Interest_rate"));
				
				String str = "" + CliObj.getAccountNum() + "  "
								+ CliObj.getBalance() + "  "
								+ CliObj.getName() + "  "
								+ CliObj.getGrade() + "  "
								+ CliObj.getInterest_rate();
				
				System.out.println(str); //���ڿ��� ���� ������ְ� ��ģ��
				
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return CliObj;
		
	}
	void Commit(Client CliObj) { //CliObj�� �ִ� �����͸� Ȱ���Ͽ� �����ͺ��̽��� ������Ʈ ��
		try {
			Statement stmt = con.createStatement();
			
			String s= "update bankAccount set balance = " + CliObj.getBalance()
					+ " where Account_Num = " + CliObj.getAccountNum(); //SQL���� �����.
			
			int i = stmt.executeUpdate(s);
			
			s = "select * from bankAccount where Account_Num = " + CliObj.getAccountNum();
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()) { // ������ ����� �� ���Դ� �� Ȯ���ϴ� �κ�
				CliObj.setAccountNum(rs.getInt("Account_Num"));
				CliObj.setBalance(rs.getInt("Balance"));
				CliObj.setName(rs.getString("Name"));
				CliObj.setGrade(rs.getString("Grade"));
				CliObj.setInterest_rate(rs.getInt("Interest_rate"));
				
				String str = "" + CliObj.getAccountNum() + "  "
								+ CliObj.getBalance() + "  "
								+ CliObj.getName() + "  "
								+ CliObj.getGrade() + "  "
								+ CliObj.getInterest_rate();
				
				System.out.println(str);
			}
		}catch (SQLException e) {
			System.out.println(e.getMessage());
			System.exit(0);
			}	
		}
}

