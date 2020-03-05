package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class DataInsert{
	//Driverインターフェイスを実装するクラスをロードする
	private static final String DATABASE_CLASS = "oracle.jdbc.driver.OracleDriver";
	//Connectionインターフェイスを実装するクラスの
	//インスタンスを返す
	private static final String DATABASE_LOGIN_INFO = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String DATABASE_LOGIN_USER = "hata";
	private static final String DATABASE_LOGIN_PW = "hata";

	private static Connection getOracleConnection() throws Exception{
		Class.forName(DATABASE_CLASS);
		Connection connection = DriverManager.getConnection(DATABASE_LOGIN_INFO,
			DATABASE_LOGIN_USER, DATABASE_LOGIN_PW);
		return connection;
	}

	public static void b_boardinsert( String title, String name, String body){
		try{
			Connection connection =getOracleConnection();

			System.out.println("b_board_title="+title+"user_name="+name+",b_board_body="+body);

			//SQL文を変数に格納する
			String sql="insert into b_board "+
			"values(b_board_id.nextval, '"+title+"', '"+name+"','"+body+"', sysdate)";


			//Statementインターフェイスを実装するクラスの
			//インスタンスを取得する
			Statement statement = connection.createStatement();
	        statement.executeQuery(sql);

			//ステートメントをクローズする
			connection.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void responseInsert(String name, String response_comment, int b_board_id){
		try{
			Connection connection =getOracleConnection();

			//SQL文を変数に格納する
			String sql="insert into response values(response_id.nextval,'"+name+"', '"+response_comment+"',sysdate,"+b_board_id+")";
			String sql2 = "UPDATE b_board SET b_date = sysdate WHERE b_board_id='"+b_board_id+"'";

			//Statementインターフェイスを実装するクラスの
			//インスタンスを取得する
			Statement statement = connection.createStatement();
	        statement.executeQuery(sql);
	        statement.executeQuery(sql2);

			//ステートメントをクローズする
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
