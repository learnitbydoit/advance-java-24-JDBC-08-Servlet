package vn.edu.eiu.model;

public class Sach {
	private String idSach;
	private String tenSach;
	private int giaBan;
	private int namXuatBan;
	public String getIdSach() {
		return idSach;
	}
	public void setIdSach(String idSach) {
		this.idSach = idSach;
	}
	public String getTenSach() {
		return tenSach;
	}
	public void setTenSach(String tenSach) {
		this.tenSach = tenSach;
	}
	public int getGiaBan() {
		return giaBan;
	}
	public void setGiaBan(int giaBan) {
		this.giaBan = giaBan;
	}
	public int getNamXuatBan() {
		return namXuatBan;
	}
	public void setNamXuatBan(int namXuatBan) {
		this.namXuatBan = namXuatBan;
	}
	public Sach() {
		super();
	}

	public Sach(String idSach, String tenSach, int giaBan, int namXuatBan) {
		super();
		this.idSach = idSach;
		this.tenSach = tenSach;
		this.giaBan = giaBan;
		this.namXuatBan = namXuatBan;
	}
	@Override
	public String toString() {
		return "Sach [idSach=" + idSach + ", tenSach=" + tenSach + ", giaBan=" + giaBan + ", namXuatBan=" + namXuatBan
				+ "]";
	}
	
	
}
