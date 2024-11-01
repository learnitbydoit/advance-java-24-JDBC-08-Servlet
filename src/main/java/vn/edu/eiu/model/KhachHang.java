package vn.edu.eiu.model;

import java.util.Date;

public class KhachHang {
	private int idKhachHang;
	private String hoVaTen;
	private Date ngaySinh;
	private String diaChi;
	public int getIdKhachHang() {
		return idKhachHang;
	}
	public void setIdKhachHang(int idKhachHang) {
		this.idKhachHang = idKhachHang;
	}
	public String getHoVaTen() {
		return hoVaTen;
	}
	public void setHoVaTen(String hoVaTen) {
		this.hoVaTen = hoVaTen;
	}
	public Date getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public KhachHang() {
		super();
	}

	public KhachHang(int idKhachHang, String hoVaTen, Date ngaySinh, String diaChi) {
		super();
		this.idKhachHang = idKhachHang;
		this.hoVaTen = hoVaTen;
		this.ngaySinh = ngaySinh;
		this.diaChi = diaChi;
	}
	
	
}
