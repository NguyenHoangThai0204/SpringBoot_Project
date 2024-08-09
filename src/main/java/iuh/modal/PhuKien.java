package iuh.modal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "phukien")
public class PhuKien {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "ten_phu_kien")
	private String tenPhuKien;
	
	@Column(name = "gia")
	private long gia;
	
	@Column(name = "so_luong")
	private int soLuong;
	
	@Column(name = "image")
	private String image;

	@Override
	public String toString() {
		return "PhuKien [id=" + id + ", tenPhuKien=" + tenPhuKien + ", gia=" + gia + ", soLuong=" + soLuong + ", image="
				+ image + "]";
	}

	public PhuKien( String tenPhuKien, long gia, int soLuong, String image) {
		super();
		this.tenPhuKien = tenPhuKien;
		this.gia = gia;
		this.soLuong = soLuong;
		this.image = image;
	}

	public PhuKien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTenPhuKien() {
		return tenPhuKien;
	}

	public void setTenPhuKien(String tenPhuKien) {
		this.tenPhuKien = tenPhuKien;
	}

	public long getGia() {
		return gia;
	}

	public void setGia(long gia) {
		this.gia = gia;
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
	
	
	
	
	
	
	
}
