package br.com.incident.api.responsible;

import br.com.incident.system.SwaggerConstant;
import br.com.incident.domain.orm.Responsible;
import br.com.incident.service.ResponsibleService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class ResponsibleRestService {

    private final ResponsibleService responsibleService;

    @ApiOperation(value = "List Responsible", response = Responsible.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = SwaggerConstant.HTTP_200_MSG),
            @ApiResponse(code = 400, message = SwaggerConstant.HTTP_400_MSG),
            @ApiResponse(code = 401, message = SwaggerConstant.HTTP_401_MSG),
            @ApiResponse(code = 403, message = SwaggerConstant.HTTP_403_MSG),
            @ApiResponse(code = 500, message = SwaggerConstant.HTTP_500_MSG)
    })
    @RequestMapping(value = "/im-day", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
//    @CrossOrigin(origins = "http://incident.surge.sh")
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Responsible> getAllResponsible() {
        return responsibleService.findAllResponsible();
    }
}