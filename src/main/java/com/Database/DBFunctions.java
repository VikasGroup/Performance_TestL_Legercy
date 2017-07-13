package com.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class DBFunctions {
	public static void setData(String tableName, double homePage, double login, double dashbord, double productPg,int round,String day,String time)
			throws SQLException, ClassNotFoundException {

		Statement stmt = null;
		Connection conn = DBConnection.conn();
		stmt = conn.createStatement();
		String sql;
		sql = "INSERT INTO `"+tableName+"`(`round`, `daystamp`, `homepage`, `loginpage`, `dashboardpage`, `productpage`, `timestamp`) VALUES ('"+round+"','"+day+"','"+homePage+"','"+login+"','"+dashbord+"','"+productPg+"','"+time+"');";
		stmt.executeUpdate(sql);
        conn.close();
		
	}

}
