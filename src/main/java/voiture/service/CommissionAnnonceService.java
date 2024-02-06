package voiture.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voiture.model.CommisssionAnnonce;
import voiture.repository.CommissionAnnonceRepository;

import java.util.List;

@Service
public class CommissionAnnonceService {

    private final CommissionAnnonceRepository commissionAnnonceRepository;

    @Autowired
    public CommissionAnnonceService(CommissionAnnonceRepository commissionAnnonceRepository) {
        this.commissionAnnonceRepository = commissionAnnonceRepository;
    }

    public CommisssionAnnonce createCommisssionAnnonce(CommisssionAnnonce commisssionAnnonce) {
        return commissionAnnonceRepository.save(commisssionAnnonce);
    }

    public List<CommisssionAnnonce> getAllCommissionAnnonce() {
        return commissionAnnonceRepository.findAll();
    }
}
