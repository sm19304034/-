package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class DataInsert{
	//Driver�C���^�[�t�F�C�X����������N���X�����[�h����
	private static final String DATABASE_CLASS = "oracle.jdbc.driver.OracleDriver";
	//Connection�C���^�[�t�F�C�X����������N���X��
	//�C���X�^���X��Ԃ�
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

			//SQL����ϐ��Ɋi�[����
			String sql="insert into b_board "+
			"values(b_board_id.nextval, '"+title+"', '"+name+"','"+body+"', sysdate)";


			//Statement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			Statement statement = connection.createStatement();
	        statement.executeQuery(sql);

			//�X�e�[�g�����g���N���[�Y����
			connection.close();

		}catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void responseInsert(String name, String response_comment, int b_board_id){
		try{
			Connection connection =getOracleConnection();

			//SQL����ϐ��Ɋi�[����
			String sql="insert into response values(response_id.nextval,'"+name+"', '"+response_comment+"',sysdate,"+b_board_id+")";
			String sql2 = "UPDATE b_board SET b_date = sysdate WHERE b_board_id='"+b_board_id+"'";

			//Statement�C���^�[�t�F�C�X����������N���X��
			//�C���X�^���X���擾����
			Statement statement = connection.createStatement();
	        statement.executeQuery(sql);
	        statement.executeQuery(sql2);

			//�X�e�[�g�����g���N���[�Y����
			connection.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
