package jaxyws;


import javax.jws.WebService;

import com.sun.xml.internal.ws.util.StringUtils;  


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@WebService(endpointInterface="jaxyws.HelloWorld")  
public class HelloWorldImpl implements HelloWorld{  
  
 private Connection conn;
private Statement stmt;
private ResultSet rs;

public String helloWorld(String name) { 
	 String Output="";
	 String query;
	 String condition="SELECT * FROM sailboatMarina.info where ";
	 String colName[]={"slipNo","sailboatType","sailboatYear","sailboatLength","slipPayment","sailboatMotor","slipassign","sailorFname","sailorLname"};
	
	 boolean flag[]=new boolean[4];
	 System.out.println(name);
	 
	 String[] parts = name.split("[|]");
	 for(int i=0;i<parts.length;i++){
			 System.out.println(parts[i]);
	 }
	  
		 for(int j=0;j<9;j++)
			 if(!parts[j].equals("Empty"))
			 {
				 condition+=colName[j]+"='"+parts[j]+"' AND ";
			 }
		condition+="5=5;";
		System.out.println(condition); 
		try {
			 String host="jdbc:mysql://localhost/mysql?useSSL=false";
			   String uName="akash";
			   String uPass="Create123";
			   
			   conn= DriverManager.getConnection(host, uName, uPass);
				stmt = conn.createStatement();
			    //rs = stmt.executeQuery(condition);

			    // or alternatively, if you don't know ahead of time that
			    // the query will be a SELECT...

			    if (stmt.execute(condition)) {
			        rs = stmt.getResultSet();
			       
			        while (rs.next()) {
			            String slipNo = rs.getString("slipNo");
			            String sFname = rs.getString("sailorFname");
			            String sLname = rs.getString("sailorLname");
			            String Type = rs.getString("sailboatType");
			            String Year = rs.getString("sailboatYear");
			            String Length = rs.getString("sailboatLength");
			            String Motor = rs.getString("sailboatMotor");
			            String Payment = rs.getString("slipPayment");
			            Output+=slipNo+ " " + sFname + " " + sLname + " " + Type +
			                               " " + Year + " " + Length + " " + Motor + " " + Payment+ " |";
			        
			    }
			    
			    
			    }} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
			 
	 return Output;  
 
  
}
}