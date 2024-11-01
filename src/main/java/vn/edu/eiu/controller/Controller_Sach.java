package vn.edu.eiu.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vn.edu.eiu.dao.DAO_Sach;
import vn.edu.eiu.database.JdbcDbConnector;
import vn.edu.eiu.model.Sach;



/**
 * Servlet implementation class DatabaseController
 */
@WebServlet("/save-sach")
public class Controller_Sach extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller_Sach() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		//Đường dẫn trả về sau khi xử lý dữ liệu
		String url ="";
		
		String idSach = request.getParameter("idSach");
		String tenSach = request.getParameter("tenSach");
		int giaBan = Integer.parseInt(request.getParameter("giaBan"));
		int namXuatBan = Integer.parseInt(request.getParameter("namXuatBan"));
		
		Sach sInsert = new Sach(idSach, tenSach, giaBan, namXuatBan);
		
		//Kiểm tra thông tin, nếu chưa đúng thì quay lại trang nhập
		boolean check_Err = false;
		//Lấy sách từ cơ sở dữ liệu
		if(DAO_Sach.getInstance().selectById(sInsert) != null) {
			check_Err = true;
			request.setAttribute("err_idSach", "Mã sách này đã tồn tại trong cơ sở dữ liệu!");
			request.setAttribute("idSach", idSach);
			url = "/index.jsp";
		}
		else {
			//Nếu thông tin đúng thì chuyển sang trang hiển thị danh mục sách
			url = "/danhmucsach.jsp";
			DAO_Sach.getInstance().insert(sInsert);
			
			ArrayList<Sach> dmSach = DAO_Sach.getInstance().selectAll();
			request.setAttribute("dmSach", dmSach);
		}
		
		//Điều hướng kết quả xử lý yêu cầu
		RequestDispatcher rD = request.getServletContext().getRequestDispatcher(url);
		rD.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
