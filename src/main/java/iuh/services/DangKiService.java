package iuh.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import iuh.modal.User;
import iuh.repositories.DangKiRepository;

@Service
public class DangKiService {

    @Autowired
    private DangKiRepository dangKiRepository;

    public <S extends User > S addUser(S user) {
        return dangKiRepository.save(user); 
    }
}
