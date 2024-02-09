package voiture.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import voiture.repository.AnnoncefavorisRepository;

@Service
public class AnnoncefavorisService {

    private final AnnoncefavorisRepository annoncefavorisRepository;

    @Autowired
    public AnnoncefavorisService(AnnoncefavorisRepository annoncefavorisRepository) {
        this.annoncefavorisRepository = annoncefavorisRepository;
    }


}
