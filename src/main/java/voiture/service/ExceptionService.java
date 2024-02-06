package voiture.service;

import org.springframework.stereotype.Service;

@Service
public class ExceptionService {

    public boolean isInternalServerError(Exception e) {
        return e instanceof RuntimeException || e instanceof IllegalArgumentException;
    }
}
