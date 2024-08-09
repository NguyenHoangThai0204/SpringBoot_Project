package iuh.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import iuh.modal.XeProduct;
import iuh.repositories.XeProductRepository;

@Service
public class XeProductService {
	@Autowired
	private XeProductRepository xeProductRepository;

	public <S extends XeProduct> S save(S entity) {
		return xeProductRepository.save(entity);
	}

	public List<XeProduct> findAll() {
		return xeProductRepository.findAll();
	}
	public List<XeProduct> findXeTayGa(int number) {
		return xeProductRepository.findXeTayGa(PageRequest.of(0, number));
	}
	public List<XeProduct> findXeSo(int number) {
		return xeProductRepository.findXeSo(PageRequest.of(0, number));
	}
	public List<XeProduct> findXeTayGa() {
		return xeProductRepository.findXeTayGa();
	}
	public List<XeProduct> findXeSo() {
		return xeProductRepository.findXeSo();
	}
	public void deleteAll() {
		xeProductRepository.deleteAll();
	}

	public XeProduct findById(String id) {
		return xeProductRepository.findById(id).orElse(null);
	}
	
	public void deleteXeByMaSP(String id) {
		xeProductRepository.deleteXeByMaSP(id);
	}
	

}
