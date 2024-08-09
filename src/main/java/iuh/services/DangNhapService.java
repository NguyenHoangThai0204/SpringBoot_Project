package iuh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.modal.User;
import iuh.repositories.DangNhapRepository;

@Service
public class DangNhapService {
	
	@Autowired
	private DangNhapRepository dangNhapRepository;
	
	public User login(String email, String password) {
		User user = dangNhapRepository.findByEmailAndPass(email, password);
		if ( user != null) {
			return user;
		}
		return null;
	}
	

	
}
