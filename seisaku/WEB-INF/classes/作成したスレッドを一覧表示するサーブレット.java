import java.io.IOException;

import javax.naming.NotContextException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;    
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ip.NoContentException;
import datebase.CountSelect;
import datebase.DateInsert;
import datebase.DataSelect;
import java.util.ArrayList;

// import jdk.nashorn.internal.ir.RuntimeNode.Request;

public class ThreadServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
        throws IOException,ServletException{
        req.setCharacterEncoding("Windows-31J");

        String n=req.getParameter("name");
        String d=req.getParameter("date");

        


        // if(n==null||n.length()==0)
        //     throw new NoContentException("“ü—Í“à—e‚ª‚ ‚è‚Ü‚¹‚ñ",null);
        // if(d==null||d.length()==0)
        //     throw new NoContentException("“ü—Í“à—e‚ª‚ ‚è‚Ü‚¹‚ñ",null);
        	
        	// DateInsert dt=new DateInsert();
            // dt.datainsert(n,d);
        	
        	SendSelect ss=new SendSelect();
            ArrayList arraylist=ss.sendSelect();

            // CountSelect cs = new CountSelect();
            // String count = cs.getCount(d);

        req.setAttribute("list",arraylist);
        // req.setAttribute("count",count);



        RequestDispatcher dispatcher=
            req.getRequestDispatcher("/result.jsp");

        dispatcher.forward(req,res);
    }
	public void doGet(HttpServletRequest req,HttpServletResponse res)
        throws IOException,ServletException{
        	doPost(req,res);
        }
}