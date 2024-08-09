package iuh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import iuh.modal.User;

public interface DangNhapRepository extends JpaRepository<User, Integer> {
	
	@org.springframework.data.jpa.repository.Query("SELECT u FROM User u WHERE u.email = ?1 AND u.password = ?2 ")
	User findByEmailAndPass(String username, String password);
	

}
