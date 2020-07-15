import java.io.IOException;
//テストナウ
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
		//���X�g�̒l�������Ă�����
        //再度追加
        ArrayList<B_boardBean> _b_board = DataSelect.b_boardSelect();

        //�f�[�^�x�[�X�ɕۑ����ꂽ�X���b�h�����o��
        req.setAttribute("_b_board",_b_board);
		//�]�����jsp���w��
        RequestDispatcher dispatcher=
            req.getRequestDispatcher("/result");
		//����
        dispatcher.forward(req,res);
    }
	public void doGet(HttpServletRequest req,HttpServletResponse res)
        throws IOException,ServletException{
        	doPost(req,res);
    }
}
