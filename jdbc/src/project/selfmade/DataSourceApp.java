package project.selfmade;

import java.sql.Connection;
import java.sql.SQLException;

import oracle.ucp.jdbc.PoolDataSource;
import oracle.ucp.jdbc.PoolDataSourceFactory;

public class DataSourceApp {
	public static void main(String[] args) throws SQLException {
		PoolDataSource pds=PoolDataSourceFactory.getPoolDataSource();
		pds.setConnectionFactoryClassName("oracle.jdbc.driver.OracleDriver");
		pds.setURL("jdbc:oracle:thin:@www.itwill.xyz:1521:xe");
		pds.setUser("jdbc_team10");
		pds.setPassword("jdbc_team10");
		pds.setInitialPoolSize(15);
		pds.setMaxPoolSize(20);	
		
		Connection con1=pds.getConnection();
		System.out.println("con1 = "+con1);
		Connection con2=pds.getConnection();
		System.out.println("con2 = "+con2);
		Connection con3=pds.getConnection();
		System.out.println("con3 = "+con3);
		Connection con4=pds.getConnection();
		System.out.println("con4 = "+con4);
		con4.close();
	}
}
