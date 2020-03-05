package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

public class DataSelect{
	private static final String DATABASE_CLASS = "oracle.jdbc.driver.OracleDriver";
	//Oracleに接続する
	private static final String DATABASE_LOGIN_INFO = "jdbc:oracle:thin:@localhost:1521:orcl";
	private static final String DATABASE_LOGIN_USER = "hata";
	private static final String DATABASE_LOGIN_PW = "hata";

	private static Connection getOracleConnection() throws Exception{
		Class.forName(DATABASE_CLASS);
		Connection connection = DriverManager.getConnection(DATABASE_LOGIN_INFO,
			DATABASE_LOGIN_USER, DATABASE_LOGIN_PW);
		return connection;
	}

	public static ArrayList<B_boardBean> b_boardSelect(){
			ArrayList<B_boardBean> _b_board = new ArrayList<B_boardBean>();
			try {
        		Connection connection =getOracleConnection();
				//select文
				String sql="select b_board_id,user_name,b_board_title,b_board_body,to_char(b_date,'YYYY\"年\"MM\"月\"DD\"日\" HH24:MI:SS') from b_board order by b_board_id desc";
				//Statementインターフェイスを実装するクラスをインスタンス化する、b_date
				Statement statement = connection.createStatement();

				//select文を実行し
				//ResultSetインターフェイスを実装したクラスの
				//インスタンスが返る
	            ResultSet resultSet = statement.executeQuery(sql);

	        	while (resultSet.next()) {
	        	B_boardBean board = new B_boardBean();
				board.setB_board_id(Integer.parseInt(resultSet.getString(1)));
				board.setUser_name(resultSet.getString(2));
				board.setB_board_title(resultSet.getString(3));
				board.setB_board_body(resultSet.getString(4));
				board.setB_date(resultSet.getString(5));

				_b_board.add(board);
			}

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

		return _b_board;
	}

	public static ArrayList<B_boardBean> b_boardSelect(int id){

		System.out.println("b_boardです");

			ArrayList<B_boardBean> _b_board = new ArrayList<B_boardBean>();
			try {
				Connection connection =getOracleConnection();
				//select文
				String sql="select b_board_id,user_name,b_board_title,b_board_body,to_char(b_date,'YYYY\"年\"MM\"月\"DD\"日\" HH24:MI:SS') from b_board where　b_board_id="+id+" order by b_board_id desc";
				//Statementインターフェイスを実装するクラスをインスタンス化する、b_date
				Statement statement = connection.createStatement();

				//select文を実行し
				//ResultSetインターフェイスを実装したクラスの
				//インスタンスが返る
				ResultSet resultSet = statement.executeQuery(sql);

				while (resultSet.next()) {
				B_boardBean board = new B_boardBean();
				board.setB_board_id(Integer.parseInt(resultSet.getString(1)));
				board.setUser_name(resultSet.getString(2));
				board.setB_board_title(resultSet.getString(3));
				board.setB_board_body(resultSet.getString(4));
				board.setB_date(resultSet.getString(5));

				_b_board.add(board);
			}

			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return _b_board;
	}

	//あああああああああああああああああああああああああああああああああああ
	public static ArrayList<ResponseBean> ResponseSelect(int b_board_id){
		ArrayList<ResponseBean> _response = new ArrayList<ResponseBean>();
			try {
        		Connection connection =getOracleConnection();
				//select文
				String sql="select RESPONSE_ID,RESPONSE_NAME,RESPONSE_COMMENT,RESPONSEDAY_DATE,B_BOARD_ID from RESPONSE where b_board_id="+b_board_id+" order by RESPONSEDAY_DATE desc";

				//Statementインターフェイスを実装するクラスをインスタンス化する
				Statement statement = connection.createStatement();

				//select文を実行し
				//ResultSetインターフェイスを実装したクラスの
				//インスタンスが返る
	            ResultSet resultSet = statement.executeQuery(sql);

	        	while(resultSet.next()){
					ResponseBean res = new ResponseBean();
					res.setResponse_id(Integer.parseInt(resultSet.getString(1)));
					res.setResponse_name(resultSet.getString(2));
					res.setResponse_comment(resultSet.getString(3));
					res.setResponseday_date(resultSet.getString(4));
					res.setB_board_id(Integer.parseInt(resultSet.getString(5)));

					_response.add(res);
				}

			//Oracleから切断する
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

		return _response;
	}

}
