package br.com.incident.domain.repository;

import br.com.incident.domain.orm.Responsible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResponsibleRepository extends JpaRepository<Responsible, Integer> {

    @Query("select res from Responsible res order by res.date asc")
    List<Responsible> findResponsible();

}
