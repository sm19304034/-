import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import database.DataSelect;
import database.DataInsert;
import java.util.ArrayList;
import database.B_boardBean;

//import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class B_boardServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
        throws IOException,ServletException{
        //DataInsert inser = new DataInsert();
        //文字コード設定
        req.setCharacterEncoding("Windows-31J");

		//jspのnameに入れる
        String title=req.getParameter("title");
        String name=req.getParameter("name");
        String body=req.getParameter("body");
		System.out.println(title);

        //データベースに一件書き込む

        	DataInsert.b_boardinsert(title, name, body);

        DataSelect ds=new DataSelect();
        ArrayList arraylist=ds.b_boardSelect();
        //データベースに一件保存する
        	//アレイ入れとけ
        	System.out.println("List = " +arraylist);
        	System.out.println("要素数 = " + arraylist.size());
        //

		//保存されているもの全てを取り出す
        req.setAttribute("list",arraylist);

        //送り先セット
        RequestDispatcher dispatcher=
            req.getRequestDispatcher("result");

		//送る
        dispatcher.forward(req,res);
    }
	// private void b_board(String t,String n,String b){
 	//DataInsert.b_boardinsert(t,n,b);
 	//System.out.println(t);
 //}
	//
	//select用
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
    DataSelect ds=new DataSelect();
     //request内で使ってる文字コードの設定
      req.setCharacterEncoding("Windows-31J");

      //idを受け取る
      String id = req.getParameter("id");
	  ArrayList arraylist=ds.b_boardSelect();

	  System.out.println("List = " +arraylist);
	  System.out.println("要素数 = " + arraylist.size());

  	//保存されているもの全てを取り出す
 	req.setAttribute("list",arraylist);
      //res_table表が入ったlistと、thread_idをrequestにset
      req.setAttribute("id",id);
      //req.setAttribute("users",list);

      //送り先の指定（jspのactionと同じ)
      RequestDispatcher dis= req.getRequestDispatcher("result");
      //実際に送る
      dis.forward(req,res);
    }
}
