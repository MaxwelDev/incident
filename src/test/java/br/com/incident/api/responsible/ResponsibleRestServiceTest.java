package br.com.incident.api.responsible;

import br.com.incident.domain.orm.Responsible;
import br.com.incident.service.ResponsibleService;
import br.com.incident.service.ResponsibleServiceImp;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.times;

public class ResponsibleRestServiceTest {

    private ResponsibleRestService responsibleRestService;

    private ResponsibleService responsibleService;

    @Before
    public void init() {
        responsibleService = Mockito.mock(ResponsibleServiceImp.class);
        responsibleRestService = new ResponsibleRestService(responsibleService);
    }

    @Test
    public void getAllResponsibleTest() throws Exception {
        List<Responsible> responsible = expectedResponsible();
        Mockito.when(responsibleService.findAllResponsible()).thenReturn(expectedResponsible());

        assertEquals(responsible, responsibleRestService.getAllResponsible());

        verify(responsibleService, times(1)).findAllResponsible();
    }

    private List<Responsible> expectedResponsible() {

        Responsible responsible = new Responsible();
        responsible.setId(1);
        responsible.setDate(LocalDate.now());
        responsible.setName("Test");
        responsible.setPosition(1);
        responsible.setAliasDate(LocalDate.now().getDayOfWeek().toString());

        return Arrays.asList(responsible);
    }
}