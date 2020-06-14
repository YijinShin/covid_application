import java.sql.*;
import java.util.Scanner;

public class DBdata{
	String sql;
	Statement state = null;
	PreparedStatement pstmt = null;
	Connection con = null;
	
	//������
	public DBdata() {
		
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
	
	//get countries from country
	public String[] getCountryFromCountry() {
		ResultSetMetaData rsmd=null;
		String sql = "SELECT name FROM Country;";
		String[] country = null;
		int resultCount;
		
		try {
			ResultSet rs = state.executeQuery(sql);
			rs.last();
			resultCount = rs.getRow();
			rs.beforeFirst();
			System.out.println("row:"+resultCount);
			country = new String[resultCount];
			//district = new String[100];
			int i=0;
			while(rs.next()) {
				country[i] = rs.getString("name");
				i++;
			}
			rs.close();
			
		}catch(SQLException e){
			
		}
		return country;
	}
	
	// get CCCtotal (CCC = Country ConfirmedCase)
	public int[] getCCCTotalFromArea() {
		ResultSetMetaData rsmd = null;
		String sql = "SELECT confirmedCaseTotal FROM Country;";
		int[] CCCTotal = null; // array for CCC
		int resultCount; //number of row in result
		
		try {
			ResultSet rs = state.executeQuery(sql);
			rs.last();
			resultCount = rs.getRow();
			rs.beforeFirst();
			System.out.println("row:"+resultCount);
			CCCTotal = new int[resultCount];
			//district = new String[100];
			int i=0;
			while(rs.next()) {
				CCCTotal[i] =  Integer.parseInt(rs.getString("confirmedCaseTotal"));
				i++;
			}
			rs.close();
			
		}catch(SQLException e){
			
		}
		return CCCTotal;
	}
	
	// get CPtotal (CP = Country Population)
	public int[] getCPTotalFromArea() {
		ResultSetMetaData rsmd = null;
		String sql = "SELECT population FROM Country;";
		int[] CPtotal = null; // array for CP
		int resultCount; //number of row in result
		
		try {
			ResultSet rs = state.executeQuery(sql);
			rs.last();
			resultCount = rs.getRow();
			rs.beforeFirst();
			System.out.println("row:"+resultCount);
			CPtotal = new int[resultCount];
			//district = new String[100];
			int i=0;
			while(rs.next()) {
				CPtotal[i] =  Integer.parseInt(rs.getString("population"));
				i++;
			}
			rs.close();
			
		}catch(SQLException e){
			
		}
		return CPtotal;
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
	
	//get infectionProcess confirmedCaseTotal
	public int[] getInfectionProcessTotal() {
		ResultSetMetaData rsmd=null;
		String sql = "SELECT confirmedCaseTotal FROM InfectionProcess;";
		int[] processTotal = null;
		int resultCount;
			
		try {
			ResultSet rs = state.executeQuery(sql);
			rs.last();
			resultCount = rs.getRow();
			rs.beforeFirst();
			System.out.println("row:"+resultCount);
			processTotal = new int[resultCount];
			//district = new String[100];
			int i=0;
			while(rs.next()) {
				processTotal[i] = Integer.parseInt(rs.getString("confirmedCaseTotal"));
				i++;
			}
			rs.close();
			
		}catch(SQLException e){
				
		}
		return processTotal;
	}
	
	public void insertScore() {

		//ResultSetMetaData rsmd=null;
		String sql = "insert into AppUser(score) values("+MainPanel.s+");";
		System.out.println(sql);
		try {
			int rs = state.executeUpdate(sql);
			System.out.println("score inserted");
			
		}catch(SQLException e){
			 System.out.println("오류가 발생했습니다 : "+e.getMessage());
		}
	}
		
		
	public int getUserInfo() {
		
		ResultSetMetaData rsmd=null;
		String sql = "SELECT score FROM AppUser;";
		int totalscore = 0;
		int resultCount = 0;
		int avgscore = 0;
		
		try {
			ResultSet rs = state.executeQuery(sql);
			rs.last();
			resultCount = rs.getRow();
			rs.beforeFirst();
			System.out.println("# of user:"+resultCount);
			int i=0;
			while(rs.next()) {
				totalscore += Integer.parseInt(rs.getString("score"));
				System.out.println("calc total:"+totalscore);
			}
			rs.close();
			
		}catch(SQLException e){
				
		}
		if(resultCount!=0)
			avgscore = totalscore/resultCount;
		else avgscore = totalscore;		
		
		return avgscore;

	}
		
	
	public int[] getClinicID() {
		ResultSetMetaData rsmd=null;
		String sql = "SELECT clinicID FROM ClinicLocation WHERE district = '" + MainPanel.userDistrict +"';";
		
		int[] clinicID = null;
		int resultCount;
			
		try {
			ResultSet rs = state.executeQuery(sql);
			rs.last();
			resultCount = rs.getRow();
			rs.beforeFirst();
			System.out.println("# of clinic:"+resultCount);
			clinicID= new int[resultCount];
			int i=0;
			while(rs.next()) {
				clinicID[i] = Integer.parseInt(rs.getString("clinicID"));
				i++;
			}
			rs.close();
		}catch(SQLException e){
			 System.out.println("오류가 발생했습니다 : "+e.getMessage());
		}
		return clinicID;
	}
		
}