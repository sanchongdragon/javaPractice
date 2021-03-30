package java0120;
/*
 * 利用前端JAVA程式，撰寫相關連線語法，在後端資料庫建立資料庫x1及相關欄位(欄位自訂)
 * */
import java.sql.*;
public class Test44 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String url = "jdbc:mariadb://localhost:3306/test0126";
		final String user = "'or' 1 '=' 1";
		final String passwd = "'or' 1 '=' 1";
//		String query = "CREATE TABLE EMP(eno int(10) not null,ename varchar(10),job varchar(10),hiredate date)";
		String query = "select * from emp;";
//		String query = "CREATE SCHEMA if not exists TEST0126;";

		try {
			Class.forName("org.mariadb.jdbc.Driver");

			System.out.println("Driver Test OK");
//			Connection conn = DriverManager.getConnection(url, user, passwd);
			Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:3306/test0126?user=123 or 1=1&password=312 or 1 = 1");

			System.out.println("Connect OK");
			System.out.println("==================================================");
			Statement stmt = conn.createStatement();
			stmt.executeQuery(query);
			
			stmt.close();
			System.out.println("query success");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
