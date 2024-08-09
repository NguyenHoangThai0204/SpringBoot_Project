package iuh.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import iuh.modal.User;
import iuh.modal.XeProduct;

@Repository
public interface DangKiRepository extends JpaRepository<User, Integer> {

}
