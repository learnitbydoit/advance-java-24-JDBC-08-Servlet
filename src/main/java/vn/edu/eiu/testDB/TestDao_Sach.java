package vn.edu.eiu.testDB;

import java.util.ArrayList;

import vn.edu.eiu.dao.DAO_Sach;
import vn.edu.eiu.model.Sach;
/**
 * Lưu ý: để chạy test class này, các bạn chạy bằng Java Application
 */
public class TestDao_Sach {

	public static void main(String[] args) {
		
		//Test SelectAll
		ArrayList<Sach> alSach1 = DAO_Sach.getInstance().selectAll();
		for (Sach s : alSach1) {
			System.out.println(s.toString());
		}
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		
		//Test SeclectById
		Sach sFind = new Sach();
		sFind.setIdSach("CSE456");
		Sach sResult = DAO_Sach.getInstance().selectById(sFind);
		System.out.println(sResult.toString());
		
		System.out.println("+++++++++++++++++++++++++++++++++++++++");
		
		//Test SeclectByCondition
		/**
		 * Trong MySQL: 
		 * % là ký tự đại diện cho 0...n ký tự;
		 * _ đại diện cho duy nhất một ký tự bất kỳ.
		 */
		String strCond = "tenSach LIKE \"Pro%\" and giaBan <= 100000";
		
		//Test syntax
		//System.out.println(strCond);
		
		ArrayList<Sach> alSach2 = DAO_Sach.getInstance().selectByCondition(strCond);
		for (Sach s : alSach2) {
			System.out.println(s.toString());
		}
	}
}
