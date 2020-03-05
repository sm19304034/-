import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import database.DataSelect;
import database.DataInsert;
import java.util.ArrayList;
import database.ResponseBean;

// import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class ResponseServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
        throws IOException,ServletException{
        //文字コード指定
        req.setCharacterEncoding("Windows-31J");

        //Post要求によって送信されたパラメータを取得する
        String resname=req.getParameter("responsename");
        String rescomment=req.getParameter("rescomment");
		int b_board_id=Integer.parseInt(req.getParameter("b_board_id"));

		//データベースにコメントを書き込む
		DataInsert.responseInsert(resname, rescomment, b_board_id);

        	DataSelect ds=new DataSelect();
        	ArrayList arraylist1=ds.ResponseSelect(b_board_id);
			ArrayList arraylist2=ds.b_boardSelect(b_board_id);
        	//データベースにコメントを一件保存する

		//データベースから保存されたコメントを全て取り出す
        //ｱﾚｲｯ
        //req.setAttribute("",);
		req.setAttribute("reslist",arraylist1);
		req.setAttribute("b_boardlist",arraylist2);
		req.setAttribute("b_board_id",b_board_id);

		// 住所セット
         RequestDispatcher dis= req.getRequestDispatcher("/response.jsp");

	 	//送る
    	  dis.forward(req,res);

     }
	//
	public void doGet(HttpServletRequest req,HttpServletResponse res)
        throws IOException,ServletException{

		int b_board_id=Integer.parseInt(req.getParameter("b_board_id"));

			DataSelect ds=new DataSelect();
        	ArrayList arraylist1=ds.ResponseSelect(b_board_id);
			ArrayList arraylist2=ds.b_boardSelect(b_board_id);

			req.setAttribute("reslist",arraylist1);
			req.setAttribute("b_boardlist",arraylist2);
			req.setAttribute("b_board_id",b_board_id);

			RequestDispatcher dis=req.getRequestDispatcher("/response.jsp");

        	dis.forward(req,res);
        }
}
