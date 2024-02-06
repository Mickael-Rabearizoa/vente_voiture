package voiture.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voiture.model.Commission;
import voiture.repository.CommissionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommissionService {

    private final CommissionRepository commissionRepository;

    @Autowired
    public CommissionService(CommissionRepository commisionRepository) { this.commissionRepository = commisionRepository; }

    public Commission getLastCommission() {
        return commissionRepository.getCommisssionAnnonce();
    }

    public Commission createCommission(Commission commission) { return commissionRepository.save(commission); }

    public Optional<Commission> getCommissionById(Integer idCommission) { return commissionRepository.findById(idCommission); }

    public Commission updateCommission(Commission commission) {
        return commissionRepository.save(commission);
    }

    public void deleteCommission(Integer IdCommission) {
        commissionRepository.deleteById(IdCommission);
    }
}

