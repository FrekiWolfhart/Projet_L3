package restful;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import modele.Auteur;

@Service
public class AuteurService {
    
    // Fait le lien entrre le repositiory et le service
    @Autowired
    private AuteurRepository auteurRepository;

    // Récupère tout les éléments du répository sous forme de liste
    public List<Auteur> list(){
        return auteurRepository.findAll();
    }
}