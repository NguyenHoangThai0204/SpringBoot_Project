package iuh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import iuh.modal.Cart;
import iuh.modal.PhuKien;

@org.springframework.stereotype.Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
	

}
