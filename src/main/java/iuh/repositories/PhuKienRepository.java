package iuh.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import iuh.modal.PhuKien;
import iuh.modal.XeProduct;
import jakarta.transaction.Transactional;

@Repository
public interface PhuKienRepository extends JpaRepository<PhuKien, Integer>	 {
	
	@Query("SELECT x FROM PhuKien x")
	List<PhuKien> findAll();
	
	@Query("SELECT x FROM PhuKien x WHERE x.id = ?1")
	Optional<PhuKien> findById(int id);
	
	@Modifying
    @Transactional
    @Query("DELETE FROM PhuKien x WHERE x.id = ?1")
    void deletePhuKienById(int maSP);
}
