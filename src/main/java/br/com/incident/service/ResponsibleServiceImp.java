package br.com.incident.service;

import br.com.incident.domain.orm.Responsible;
import br.com.incident.domain.repository.ResponsibleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ResponsibleServiceImp implements ResponsibleService {

    private static final String FRIDAY = "FRIDAY";
    private static final String MONDAY = "MONDAY";

    private final ResponsibleRepository responsibleRepository;

    @Override
    public List<Responsible> findAllResponsible() {

        List<Responsible> responsibles = responsibleRepository.findResponsible();

        for (int i = 0; i < responsibles.size(); i++) {
            if(responsibles.get(i).getDate().getDayOfWeek().toString().equals(FRIDAY)) {
                Responsible saturday = new Responsible();

                saturday.setName("Phone");
                saturday.setDate(responsibles.get(i).getDate().plusDays(1));
                responsibles.add(i + 1, saturday);

                Responsible sunday = new Responsible();
                sunday.setName("Phone");
                sunday.setDate(responsibles.get(i).getDate().plusDays(2));
                responsibles.add(i + 2, sunday);

                i++;
            }
        }

        if(responsibles.get(0).getDate().getDayOfWeek().toString().equals(MONDAY)) {

            Responsible saturday = new Responsible();
            saturday.setName("Phone");
            saturday.setDate(responsibles.get(0).getDate().minusDays(2));
            responsibles.add(responsibles.size(), saturday);

            Responsible sunday = new Responsible();
            sunday.setName("Phone");
            sunday.setDate(responsibles.get(0).getDate().minusDays(1));
            responsibles.add(responsibles.size(), sunday);

        }

        Responsible responsibleYesterday = responsibles.stream().filter(item ->
                new Integer(responsibles.get(0).getPosition().intValue()-1).equals(item.getPosition()))
                .collect(Collectors.toList()).get(0);

        Responsible yesterday = new Responsible();

        yesterday.setName(responsibleYesterday.getName());
        yesterday.setDate(responsibles.get(0).getDate().minusDays(1));
        yesterday.setPosition(responsibles.get(responsibles.size()-1).getPosition());
        yesterday.setId(responsibles.get(responsibles.size()-1).getId());
        yesterday.setAliasDate("Yesterday");
        responsibles.add(0, yesterday);
        responsibles.get(1).setAliasDate("Today");
        responsibles.get(2).setAliasDate("Tomorrow");

        return responsibles;
    }
}
