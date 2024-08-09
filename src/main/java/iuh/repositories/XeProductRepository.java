package iuh.repositories;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import iuh.modal.XeProduct;
import jakarta.transaction.Transactional;

@Repository
public interface XeProductRepository extends JpaRepository<XeProduct, String> {
	@Query("SELECT x FROM XeProduct x")
	List<XeProduct> findAll();
	
	@Query("SELECT x FROM XeProduct x WHERE x.id = ?1")
	Optional<XeProduct> findById(String id);
	
	@Query("SELECT x FROM XeProduct x where x.danhMuc = 'Xe tay ga'")
	List<XeProduct> findXeTayGa(PageRequest pageRequest);
	
	@Query("SELECT x FROM XeProduct x where x.danhMuc = 'Xe số'")
	List<XeProduct> findXeSo(PageRequest pageRequest);
	
	@Query("SELECT x FROM XeProduct x where x.danhMuc = 'Xe tay ga'")
	List<XeProduct> findXeTayGa();
	
	@Query("SELECT x FROM XeProduct x where x.danhMuc = 'Xe số'")
	List<XeProduct> findXeSo();
	
	@Modifying
    @Transactional
    @Query("DELETE FROM XeProduct x WHERE x.maSP = ?1")
    void deleteXeByMaSP(String maSP);


}
