package iuh.modal;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	
	@jakarta.persistence.Id
	@jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
	@jakarta.persistence.Column(name = "id")
	private int id;
	
	@ManyToOne
	@jakarta.persistence.JoinColumn(name = "phuKien_id")
	private PhuKien phuKien;
	
	@ManyToOne
	@jakarta.persistence.JoinColumn(name = "xeProduct_id")
	private XeProduct xeProduct;
	
	@jakarta.persistence.Column(name = "quantity")
	private int quantity;
	
	@jakarta.persistence.Column(name = "price")
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public PhuKien getPhuKien() {
		return phuKien;
	}

	public void setPhuKien(PhuKien phuKien) {
		this.phuKien = phuKien;
	}

	public XeProduct getXeProduct() {
		return xeProduct;
	}

	public void setXeProduct(XeProduct xeProduct) {
		this.xeProduct = xeProduct;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", phuKien=" + phuKien + ", xeProduct=" + xeProduct + ", quantity=" + quantity
				+ ", price=" + price + "]";
	}

	public Cart(int id, PhuKien phuKien, XeProduct xeProduct, int quantity, double price) {
		super();
		this.id = id;
		this.phuKien = phuKien;
		this.xeProduct = xeProduct;
		this.quantity = quantity;
		this.price = price;
	}

	public Cart(XeProduct xeProduct, int quantity, double price) {
		super();
		this.id = id;
		this.xeProduct = xeProduct;
		this.quantity = quantity;
		this.price = price;
	}

	public Cart(PhuKien phuKien, int quantity, double price) {
		super();
		this.phuKien = phuKien;
		this.quantity = quantity;
		this.price = price;
	}

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(PhuKien phuKien, XeProduct xeProduct, int quantity, double price) {
		super();
		this.phuKien = phuKien;
		this.xeProduct = xeProduct;
		this.quantity = quantity;
		this.price = price;
	}
	
	

}
