package database;

public class B_boardBean{
	private int b_board_id;
	private String user_name;
	private String b_boad_title;
	private String b_board_body;
	private String b_date;

	public void setB_board_id(int b_board_id){
		this.b_board_id=b_board_id;
	}
	public int getB_board_id(){
		return b_board_id;
	}
	public void setUser_name(String user_name){
		this.user_name=user_name;
	}
	public String getUser_name(){
		return user_name;
	}
	public void setB_board_title(String b_boad_title){
		this.b_boad_title=b_boad_title;
	}
	public String getB_board_title(){
		return b_boad_title;
	}
	public void setB_board_body(String b_board_body){
		this.b_board_body=b_board_body;
	}
	public String getB_board_body(){
		return b_board_body;
	}
	public void setB_date(String b_date){
		this.b_date=b_date;
	}
	public String getB_date(){
		return b_date;
	}
}
