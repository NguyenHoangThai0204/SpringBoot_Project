package iuh.services;

import iuh.modal.Cart;
import iuh.modal.XeProduct;

@org.springframework.stereotype.Service
public class CartService {

	@org.springframework.beans.factory.annotation.Autowired
	private iuh.repositories.CartRepository cartRepository;
	
	@org.springframework.beans.factory.annotation.Autowired
	private iuh.repositories.XeProductRepository xeProductRepository;

	public iuh.modal.Cart save(String proId, double price, int quantity) {
		
		XeProduct xe = new iuh.modal.XeProduct();
		
		xe = xeProductRepository.findById(proId).get();
		
		Cart cart = new Cart();
		cart.setXeProduct(xe);
		cart.setPrice(price);
		cart.setQuantity(quantity);
		
		return cartRepository.save(cart);
	}

	
}
