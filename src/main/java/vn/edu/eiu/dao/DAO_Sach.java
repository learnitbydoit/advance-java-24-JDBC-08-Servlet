package vn.edu.eiu.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import vn.edu.eiu.database.JdbcDbConnector;
import vn.edu.eiu.model.Sach;

public class DAO_Sach implements DAO_Interface<Sach> {

	// Giúp không cầu tạo mới một đối tượng sách.
	public static DAO_Sach getInstance() {
		return new DAO_Sach();
	}

	@Override
	public int insert(Sach t) {
		try {
			// 1. Tạo kết nối đến DB
			JdbcDbConnector jdc = new JdbcDbConnector();
			Connection c = jdc.getConnection();
			// 2. Tạo statement
			Statement st = c.createStatement();
			// 3. Thực thi câu lệnh SQL
			String sql = "INSERT INTO sach(idSach, tenSach, giaBan, namXuatBan) " + 
					"VALUES (\"" + t.getIdSach() + "\", \"" + t.getTenSach() + "\", " + t.getGiaBan()
					+ ", " + t.getNamXuatBan() + ")";
			
			int result =st.executeUpdate(sql);
			
			//4. Xử lý kết quả
			System.out.println("Statement executed: " + sql);
			System.out.println(result + " row(s) were effected!");
			
			//5. Ngắt kết nối
			jdc.closeConnection(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int update(Sach t) {
		try {
			// 1. Kết nối db
			JdbcDbConnector jdc = new JdbcDbConnector();
			Connection c = jdc.getConnection();
			//2. Tạo đối tượng statement
			Statement st = c.createStatement();
			
			//3. Thực thi câu lệnh
			/**
			 * Nếu sử dụng nháy đôi cho giá trị chuỗi thì phía trước phải có dấu \
			 * Nếu dùng nháy đơn thì không cần.
			 */
			String sql = "UPDATE sach" +
						 " SET" + 
						 " tenSach=\"" + t.getTenSach() +"\", " +
						 " giaBan=" + t.getGiaBan() + ", " +
						 " namXuatBan=" + t.getNamXuatBan() +
						 " WHERE idSach=\"" + t.getIdSach() + "\"";
			System.out.println(sql);
			int result = st.executeUpdate(sql);
			
			//4 Xử lý kết quả trả về
			System.out.println("Statement executed: "+ sql);
			System.out.println(result + " row(s) were updated!");
			
			//5. Ngắt kết nối 
			jdc.closeConnection(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int delete(Sach t) {
		try {
			// 1. Kết nối db
			JdbcDbConnector jdc = new JdbcDbConnector();
			Connection c = jdc.getConnection();
			//2. Tạo đối tượng statement
			Statement st = c.createStatement();
			
			//3. Thực thi câu lệnh
			/**
			 * Nếu sử dụng nháy đôi cho giá trị chuỗi thì phía trước phải có dấu \
			 * Nếu dùng nháy đơn thì không cần.
			 */
			String sql = "DELETE FROM sach" +
						 " WHERE idSach=\"" + t.getIdSach() + "\"";
			
			//Test sql syntax
			System.out.println(sql);
			
			int result = st.executeUpdate(sql);
			
			//4 Xử lý kết quả trả về
			System.out.println("Statement executed: "+ sql);
			System.out.println(result + " row(s) were deleted!");
			
			//5. Ngắt kết nối 
			jdc.closeConnection(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public ArrayList<Sach> selectAll() {
		ArrayList<Sach> alSach = new ArrayList<Sach>();
		try {
			// 1. Kết nối db
			JdbcDbConnector jdc = new JdbcDbConnector();
			Connection c = jdc.getConnection();
			
			//2. Tạo đối tượng statement
			Statement st = c.createStatement();
			
			//3. Thực thi câu lệnh
			/**
			 * Nếu sử dụng nháy đôi cho giá trị chuỗi thì phía trước phải có dấu \
			 * Nếu dùng nháy đơn thì không cần.
			 */
			String sql = "SELECT * FROM sach";
			
			//Test sql syntax
			System.out.println(sql);
			ResultSet rS  =  st.executeQuery(sql);
			
			//4 Xử lý kết quả trả về
			/**
			 * 4.1 Duyệt qua từng kết quả trong rS để lấy từng giá trị;
			 * 4.2 Tạo mới đối tượng sách s từ thông tin đã lấy;
			 * 4.3 Đưa đối tượng vào arraylist Sách.
			 * */
			while(rS.next()) {
				//4.1
				String idSach = rS.getString("idSach");
				String tenSach = rS.getString("tenSach");
				int giaBan = rS.getInt("giaBan");
				int namXuatBan = rS.getInt("namXuatBan");
				//4.2
				Sach s = new Sach(idSach, tenSach, giaBan, namXuatBan);
				//4.3
				alSach.add(s);
			}
			System.out.println("Statement executed: "+ sql);
			
			//5. Ngắt kết nối 
			jdc.closeConnection(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return alSach;
	}

	@Override
	public Sach selectById(Sach t) {
		Sach s = null;
		try {
			// 1. Kết nối db
			JdbcDbConnector jdc = new JdbcDbConnector();
			Connection c = jdc.getConnection();
			
			//2. Tạo đối tượng statement
			Statement st = c.createStatement();
			
			//3. Thực thi câu lệnh
			/**
			 * Nếu sử dụng nháy đôi cho giá trị chuỗi thì phía trước phải có dấu \
			 * Nếu dùng nháy đơn thì không cần.
			 */
			String sql = "SELECT * FROM sach WHERE idSach = \"" + t.getIdSach() + "\"";
			
			//Test sql syntax
			//System.out.println(sql);
			
			ResultSet rS = st.executeQuery(sql);
			
			//4 Xử lý kết quả trả về
			System.out.println("Statement executed: "+ sql);
			
			while(rS.next()) {
				String idSach = rS.getString("idSach");
				String tenSach = rS.getString("tenSach");
				int giaBan = rS.getInt("giaBan");
				int namXuatBan = rS.getInt("namXuatBan");
				s = new Sach(idSach, tenSach, giaBan, namXuatBan);
			}
			//5. Ngắt kết nối 
			jdc.closeConnection(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return s;
	}

	@Override
	public ArrayList<Sach> selectByCondition(String condition) {
		ArrayList<Sach> alSach = new ArrayList<Sach>();
		try {
			// 1. Kết nối db
			JdbcDbConnector jdc = new JdbcDbConnector();
			Connection c = jdc.getConnection();
			
			//2. Tạo đối tượng statement
			Statement st = c.createStatement();
			
			//3. Thực thi câu lệnh
			/**
			 * Nếu sử dụng nháy đôi cho giá trị chuỗi thì phía trước phải có dấu \
			 * Nếu dùng nháy đơn thì không cần.
			 */
			String sql = "SELECT * FROM sach WHERE "+ condition;
			
			//Test sql syntax
			System.out.println(sql);
			
			ResultSet rS = st.executeQuery(sql);
			
			//4 Xử lý kết quả trả về
			System.out.println("Statement executed: "+ sql);
			while(rS.next()) {
				//4.1
				String idSach = rS.getString("idSach");
				String tenSach = rS.getString("tenSach");
				int giaBan = rS.getInt("giaBan");
				int namXuatBan = rS.getInt("namXuatBan");
				//4.2
				Sach s = new Sach(idSach, tenSach, giaBan, namXuatBan);
				//4.3
				alSach.add(s);
			}
			
			//5. Ngắt kết nối 
			jdc.closeConnection(c);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alSach;
	}
}
