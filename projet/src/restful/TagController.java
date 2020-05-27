package restful;

import controleur.PersistanceServiceLecture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.text.html.HTML;
import java.util.Collection;

@RestController
@EnableAutoConfiguration
public class TagController {
    @Autowired
    private PersistanceServiceLecture persistance;

//    @GetMapping("/Tags")
//    public Collection<Tag>

}

