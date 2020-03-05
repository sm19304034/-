package database;

public class ResponseBean{
	private int response_id;
	private String response_name;
	private String response_comment;
	private String responseday_date;
	private int b_board_id;

	public void setResponse_id(int response_id){
		this.response_id=response_id;
	}
	public int getResponse_id(){
		return response_id;
	}
	public void setResponse_name(String response_name){
		this.response_name=response_name;
	}
	public String getResponse_name(){
		return response_name;
	}
	public void setResponse_comment(String response_comment){
		this.response_comment=response_comment;
	}
	public String getResponse_comment(){
		return response_comment;
	}
	public void setResponseday_date(String responseday_date){
		this.responseday_date=responseday_date;
	}
	public String getResponseday_date(){
		return responseday_date;
	}
	public void setB_board_id(int b_board_id){
		this.b_board_id=b_board_id;
	}
	public int getB_board_id(){
		return b_board_id;
	}
}
