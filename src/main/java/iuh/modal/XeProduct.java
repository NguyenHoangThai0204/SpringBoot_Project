package iuh.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "xeproduct")
public class XeProduct {
	@Id
	@Column(name = "maSP")
	private String maSP;
	@Column(name = "phienBan")
	private String phienBan;
	@Column(name = "danhMuc")
	private String danhMuc;
	@Column(name = "xuatXu")
	private String xuatXu;
	@Column(name = "nhanHieu")
	private String nhanHieu;
	@Column(name = "gia")
	private long gia;
	@Column(name = "thongTin")
	private String thongTin;
	@Column(name = "image")
	private String image;
	@Column(name = "soLuong")
	private int soLuong;
	
	public XeProduct(String maSP, String phienBan, String danhMuc, String xuatXu, String nhanHieu, long gia,
			String thongTin, String image, int soLuong) {
		super();
		this.maSP = maSP;
		this.phienBan = phienBan;
		this.danhMuc = danhMuc;
		this.xuatXu = xuatXu;
		this.nhanHieu = nhanHieu;
		this.gia = gia;
		this.thongTin = thongTin;
		this.image = image;
		this.soLuong = soLuong;
	}

	@Override
	public String toString() {
		return "XeProduct [maSP=" + maSP + ", phienBan=" + phienBan + ", danhMuc=" + danhMuc + ", xuatXu=" + xuatXu
				+ ", nhanHieu=" + nhanHieu + ", gia=" + gia + ", thongTin=" + thongTin + ", image=" + image
				+ ", soLuong=" + soLuong + "]";
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public XeProduct() {
		super();
	}
	
	public String getMaSP() {
		return maSP;
	}

	public void setMaSP(String maSP) {
		this.maSP = maSP;
	}

	public String getPhienBan() {
		return phienBan;
	}

	public void setPhienBan(String phienBan) {
		this.phienBan = phienBan;
	}

	public String getDanhMuc() {
		return danhMuc;
	}

	public void setDanhMuc(String danhMuc) {
		this.danhMuc = danhMuc;
	}

	public String getXuatXu() {
		return xuatXu;
	}

	public void setXuatXu(String xuatXu) {
		this.xuatXu = xuatXu;
	}

	public String getNhanHieu() {
		return nhanHieu;
	}

	public void setNhanHieu(String nhanHieu) {
		this.nhanHieu = nhanHieu;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
	}

	public String getThongTin() {
		return thongTin;
	}

	public void setThongTin(String thongTin) {
		this.thongTin = thongTin;
	}
	
}
