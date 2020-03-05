import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.DataSelect;
import database.B_boardBean;
import java.util.ArrayList;


// import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class ThreadServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
        throws IOException,ServletException{
        req.setCharacterEncoding("Windows-31J");
		//リストの値を持ってきたい
        //
        ArrayList<B_boardBean> _b_board = DataSelect.b_boardSelect();

        //データベースに保存されたスレッドを取り出す
        req.setAttribute("_b_board",_b_board);
		//転送先のjspを指定
        RequestDispatcher dispatcher=
            req.getRequestDispatcher("/result");
		//送る
        dispatcher.forward(req,res);
    }
	public void doGet(HttpServletRequest req,HttpServletResponse res)
        throws IOException,ServletException{
        	doPost(req,res);
    }
}
