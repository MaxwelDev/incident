package br.com.incident.api.responsible;

import br.com.incident.domain.orm.Responsible;
import br.com.incident.service.ResponsibleService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class ResponsibleRestService {

    private final ResponsibleService responsibleService;

    @CrossOrigin(origins = "http://front-incident.surge.sh")
    @RequestMapping("im-day")
    public List<Responsible> getAllResponsible() {
        return responsibleService.findAllResponsible();
    }
}
