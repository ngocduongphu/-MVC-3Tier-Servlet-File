package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectSQL {
		private final String serverName = "localhost"; 
		private final String dbName = "ltwebst4";
		private final String portNumber="1433";
		private final String instance=""; //MSSQLSERVER LEAVE THIS ONE EMPTY IF YOUR SQL IS A SINGLE INSTANCE
	//	private final String userID = "";
	//	private final String password="217177";
		
		public Connection getConnection() throws Exception{ 
			
		
				
			String url="jdbc:sqlserver://"+serverName+":"+portNumber + "\\" + instance +";integratedSecurity=true; databaseName="+dbName;
				
			if(instance == null || instance.trim().isEmpty())
					url = "jdbc:sqlserver://"+serverName+": "+portNumber +";integratedSecurity=true;databaseName="+dbName;
		
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			
		return DriverManager.getConnection(url);
		
		 
		
}
		
		
		public static void main(String[] args){
			try {
				new DBConnectMySQL();
				System.out.println(new DBConnectSQL().getConnection());
				
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
}
