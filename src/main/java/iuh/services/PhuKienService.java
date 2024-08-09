package iuh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iuh.modal.PhuKien;
import iuh.modal.XeProduct;
import iuh.repositories.PhuKienRepository;

@Service
public class PhuKienService {

	@Autowired
	private PhuKienRepository phuKienRepository;
	
	public List<PhuKien> findAll() {
		return phuKienRepository.findAll();
	}
	public PhuKien findById(int id) {
		return phuKienRepository.findById(id).orElse(null);
	}
	
	public <S extends PhuKien> S save(S entity) {
		return phuKienRepository.save(entity);
	}
	
	public void deletePhuKienById(int id) {
		phuKienRepository.deletePhuKienById(id);
	}
	
}
