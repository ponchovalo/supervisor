package com.supervisor.indicadores.repository;

import com.supervisor.indicadores.dtos.Party;
import com.supervisor.indicadores.entity.Plantilla;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IPlantillaRepository extends JpaRepository<Plantilla, String> {

    @Query("select distinct new com.supervisor.indicadores.dtos.Party(p.party_number, p.party_desc) from Plantilla p where p.party_number != 'PARTIDA 0' order by p.party_number ASC")
    List<Party> findDistinctParties();

    @Query("select distinct p.device from Plantilla p where p.party_number = ?1")
    List<String> findDistinctDevices(String party);

    @Query("select distinct p.activity_type from Plantilla p where p.activity_type != 'ACTIVIDADES ADMINISTRATIVAS' order by p.activity_type ASC")
    List<String> findDistinctActivityTypes();

    @Query("select distinct p.ticket_description from Plantilla p where p.device = ?1 and p.activity_type = ?2 and p.ticket_description != 'MANTENIMIENTO PREVENTIVO'")
    List<String> findDistinctTiketDescription(String device, String activity_type);

    @Query("select p.tech_description from Plantilla p where p.device = ?1 and p.ticket_description = ?2")
    List<String> findByTicketDescription(String  device, String ticket_description );

}
