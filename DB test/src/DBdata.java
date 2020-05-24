import java.sql.*;
import java.util.Scanner;

public class DBdata{
	String sql;
	Statement state = null;
	
	//생성자 
	public DBdata() {
		Connection con = null;
		
		//connecting
		try {
			  //connect to DB 
		      Class.forName("com.mysql.cj.jdbc.Driver");
		      String dbName ="covid";
		      String userName = "root";
		      String password = "coviddatabase";
		      String hostname = "covid.cfuiktet3gjm.ap-northeast-2.rds.amazonaws.com";
		      String port = "3306";
		      String driver = "com.mysql.jdbc.Driver";
		      
		      String url = "jdbc:mysql://"+hostname+":"+port+"/"+dbName+"?user="+userName+"&password="+password;
		      con = DriverManager.getConnection(url);
		      
		      //get Date from DB 
		      if(con != null) {
		    	  System.out.println("[MySQL connection successful.]");
		    	  state = con.createStatement();	    	  
		      }
		}catch (ClassNotFoundException e) { 
		    	
		}catch (SQLException e) { 
		    	
		}
	
		
	}
	
	//get name from Area
	public String[] getDistrictFromArea() {
		ResultSetMetaData rsmd=null;
		String sql = "SELECT name FROM Area;";
		String[] district = null;
		int resultCount;
		
		try {
			ResultSet rs = state.executeQuery(sql);
			rs.last();
			resultCount = rs.getRow();
			rs.beforeFirst();
			System.out.println("row:"+resultCount);
			district = new String[resultCount];
			//district = new String[100];
			int i=0;
			while(rs.next()) {
				district[i] = rs.getString("name");
				i++;
			}
			rs.close();
			
		}catch(SQLException e){
			
		}
		return district;
	}
	
	//get confirmedCaseTotal from Area ( CC = ConfirmedCase)
	public int[] getCCTotalFromArea() {
		ResultSetMetaData rsmd=null;
		String sql = "SELECT confirmedCaseTotal FROM Area;";
		int[] CCTotal = null;
		int resultCount;
		
		try {
			ResultSet rs = state.executeQuery(sql);
			rs.last();
			resultCount = rs.getRow();
			rs.beforeFirst();
			System.out.println("row:"+resultCount);
			CCTotal = new int[resultCount];
			//district = new String[100];
			int i=0;
			while(rs.next()) {
				CCTotal[i] =  Integer.parseInt(rs.getString("confirmedCaseTotal"));
				i++;
			}
			rs.close();
			
		}catch(SQLException e){
			
		}
		return CCTotal;
	}
	
	//get process form InfectionProcess
	public String[] getProcessFromInfectionProcess() {
		ResultSetMetaData rsmd=null;
		String sql = "SELECT process FROM InfectionProcess;";
		String[] process = null;
		int resultCount;
		
		try {
			ResultSet rs = state.executeQuery(sql);
			rs.last();
			resultCount = rs.getRow();
			rs.beforeFirst();
			System.out.println("row:"+resultCount);
			process = new String[resultCount];
			//district = new String[100];
			int i=0;
			while(rs.next()) {
				process[i] = rs.getString("process");
				i++;
			}
			rs.close();
			
		}catch(SQLException e){
			
		}
		return process;
	}

}