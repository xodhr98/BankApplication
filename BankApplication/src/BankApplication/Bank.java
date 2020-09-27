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
                 Class.forName("com.mysql.jdbc.Driver"); //JDBC 드라이브 적재
                 System.out.println("드라이버 적재 성공");
                 con = DriverManager.getConnection(url, id, password); //DataBase 연결
                 System.out.println("데이터베이스 연결 성공");
          } catch (ClassNotFoundException e) {
                 System.out.println("드라이버를 찾을 수 없습니다.");
          } catch (SQLException e) {
                 System.out.println("연결에 실패하였습니다.");
          }
          return con;
    }

	public Client GetRecord(int Account_Num) {
		con = makeConnection(); //connection을 맺는다
		
		Client CliObj = null; // 객체 생성을 하여 null로 초기화해준다
		
		try {
			Statement stmt = con.createStatement(); //데이터베이스의 정보를 가지고 statement를 만듬
			String s = "select * from bankaccount where Account_Num = " + Account_Num;
			ResultSet rs = stmt.executeQuery(s); //입력받은 계좌번호를 가지고 데이터베이스의 레코드를 가져옴
			while(rs.next()) { // 가져온 레코드를 한 줄씩 처리해야함.
				
				if(rs.getString("Grade").equals("Ordinary"))
					CliObj = new OrdinaryClient(); //Ordinary일 때는 객체가 달라짐
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
				
				System.out.println(str); //문자열을 만들어서 출력해주고 마친다
				
			}
		}catch(SQLException e) {
			System.out.println(e.getMessage());
			System.exit(0);
		}
		return CliObj;
		
	}
	void Commit(Client CliObj) { //CliObj에 있는 데이터를 활용하여 데이터베이스를 업데이트 함
		try {
			Statement stmt = con.createStatement();
			
			String s= "update bankAccount set balance = " + CliObj.getBalance()
					+ " where Account_Num = " + CliObj.getAccountNum(); //SQL문을 만든다.
			
			int i = stmt.executeUpdate(s);
			
			s = "select * from bankAccount where Account_Num = " + CliObj.getAccountNum();
			ResultSet rs = stmt.executeQuery(s);
			while(rs.next()) { // 수정된 결과가 잘 나왔는 지 확인하는 부분
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

