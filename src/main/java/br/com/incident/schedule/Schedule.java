package br.com.incident.schedule;

import br.com.incident.domain.orm.Responsible;
import br.com.incident.domain.repository.ResponsibleRepository;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
@EnableScheduling
@AllArgsConstructor
public class Schedule {

    private static final String SATURDAY = "SATURDAY";
    private static final String SUNDAY = "SUNDAY";
    private static final String FRIDAY = "FRIDAY";
    private static final String TIME_ZONE = "America/Sao_Paulo";

    private final ResponsibleRepository responsibleRepository;


    @org.springframework.scheduling.annotation.Scheduled(cron = "0 10 0 * * *", zone = TIME_ZONE)
//    @org.springframework.scheduling.annotation.Scheduled(fixedDelay = 60000, zone = TIME_ZONE)
    public void updateDate() {

        if (!LocalDate.now().getDayOfWeek().toString().equals(SATURDAY)
                && !LocalDate.now().getDayOfWeek().toString().equals(SUNDAY)) {

            List<Responsible> responsible = responsibleRepository.findResponsible();
            Responsible first = responsible.get(0);

            if (responsible.get(responsible.size() - 1).getDate().getDayOfWeek().toString().equals(FRIDAY)) {

                first.setDate(responsible.get(responsible.size() - 1).getDate().plusDays(3));

            } else {

                first.setDate(responsible.get(responsible.size() - 1).getDate().plusDays(1));

            }

            responsibleRepository.save(first);
        }
    }
}