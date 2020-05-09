import java.sql.*;
import java.util.Scanner;

public class DBconnect{
	String sql;
	
	//생성자 
	public DBconnect() {
		Statement state = null;
		Connection con = null;
		
		//connecting
		try {
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      String dbName ="covid";
		      String userName = "root";
		      String password = "coviddatabase";
		      String hostname = "covid.cfuiktet3gjm.ap-northeast-2.rds.amazonaws.com";
		      String port = "3306";
		      String driver = "com.mysql.jdbc.Driver";
		      
		      String url = "jdbc:mysql://"+hostname+":"+port+"/"+dbName+"?user="+userName+"&password="+password;
		      con = DriverManager.getConnection(url);
		      if(con != null) {
		    	  System.out.println("[MySQL connection successful.]");
		    	  state = con.createStatement();
		    	  
		    	  //값 가져와보기 
		    	  //sql = inputQuery();
		    	  sql = "SELECT * FROM InfectionProcess";
				  ResultSet rs = state.executeQuery(sql);
					
				  while(rs.next()) {
					    String process = rs.getString("process");
						String confirmedCaseTotal = rs.getString("confirmedCaseTotal");
						System.out.println("process:"+process + ", confirmedCaseTotal:"+confirmedCaseTotal+"\n");
				  }
		      }
		}catch (ClassNotFoundException e) { 
		    	
		}catch (SQLException e) { 
		    	
		}
	
		
	}
	
	
	public String inputQuery() {
		Scanner sc = new Scanner(System.in);
		String sql;
		System.out.println("enter qurey here: ");
		sql =  sc.nextLine();
		System.out.println("query entered\n");
		return sql;
	}
}
	
