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
//もう一回
//パスワードはData
public class ResponseServlet extends HttpServlet{
    public void doPost(HttpServletRequest req,HttpServletResponse res)
        throws IOException,ServletException{
        //�����R�[�h�w��
        req.setCharacterEncoding("Windows-31J");

        //Post�v���ɂ���đ��M���ꂽ�p�����[�^���擾����
        String resname=req.getParameter("responsename");
        String rescomment=req.getParameter("rescomment");
		int b_board_id=Integer.parseInt(req.getParameter("b_board_id"));

		//�f�[�^�x�[�X�ɃR�����g����������
		DataInsert.responseInsert(resname, rescomment, b_board_id);

        	DataSelect ds=new DataSelect();
        	ArrayList arraylist1=ds.ResponseSelect(b_board_id);
			ArrayList arraylist2=ds.b_boardSelect(b_board_id);
        	//�f�[�^�x�[�X�ɃR�����g���ꌏ�ۑ�����

		//�f�[�^�x�[�X����ۑ����ꂽ�R�����g��S�Ď��o��
        //�ڲ�
        //req.setAttribute("",);
		req.setAttribute("reslist",arraylist1);
		req.setAttribute("b_boardlist",arraylist2);
		req.setAttribute("b_board_id",b_board_id);

		// �Z���Z�b�g
         RequestDispatcher dis= req.getRequestDispatcher("/response.jsp");

	 	//����
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
