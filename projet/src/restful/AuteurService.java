package restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modele.Auteur;

@Service
public class AuteurService {
    
    @Autowired
    private AuteurRepository auteurRepository;

    public List<Auteur> list(){
        return auteurRepository.findAll();
    }
}