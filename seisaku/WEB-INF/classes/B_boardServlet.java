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
//コメント
public class B_boardServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
        throws IOException,ServletException{
        //DataInsert inser = new DataInsert();
        //�����R�[�h�ݒ�
        req.setCharacterEncoding("Windows-31J");

		//jsp��name�ɓ����
        String title=req.getParameter("title");
        String name=req.getParameter("name");
        String body=req.getParameter("body");
		System.out.println(title);

        //�f�[�^�x�[�X�Ɉꌏ��������

        	DataInsert.b_boardinsert(title, name, body);

        DataSelect ds=new DataSelect();
        ArrayList arraylist=ds.b_boardSelect();
        //�f�[�^�x�[�X�Ɉꌏ�ۑ�����
        	//�A���C����Ƃ�
        	System.out.println("List = " +arraylist);
        	System.out.println("�v�f�� = " + arraylist.size());
        //

		//�ۑ�����Ă�����̑S�Ă����o��
        req.setAttribute("list",arraylist);

        //�����Z�b�g
        RequestDispatcher dispatcher=
            req.getRequestDispatcher("result");

		//����
        dispatcher.forward(req,res);
    }
	// private void b_board(String t,String n,String b){
 	//DataInsert.b_boardinsert(t,n,b);
 	//System.out.println(t);
 //}
	//
	//select�p
    public void doGet(HttpServletRequest req,HttpServletResponse res)throws IOException,ServletException{
    DataSelect ds=new DataSelect();
     //request���Ŏg���Ă镶���R�[�h�̐ݒ�
      req.setCharacterEncoding("Windows-31J");

      //id���󂯎��
      String id = req.getParameter("id");
	  ArrayList arraylist=ds.b_boardSelect();

	  System.out.println("List = " +arraylist);
	  System.out.println("�v�f�� = " + arraylist.size());

  	//�ۑ�����Ă�����̑S�Ă����o��
 	req.setAttribute("list",arraylist);
      //res_table�\��������list�ƁAthread_id��request��set
      req.setAttribute("id",id);
      //req.setAttribute("users",list);

      //�����̎w��ijsp��action�Ɠ���)
      RequestDispatcher dis= req.getRequestDispatcher("result");
      //���ۂɑ���
      dis.forward(req,res);
    }
}
