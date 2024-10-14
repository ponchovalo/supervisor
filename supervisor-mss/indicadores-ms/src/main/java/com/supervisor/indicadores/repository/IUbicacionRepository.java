package com.supervisor.indicadores.repository;

import com.supervisor.indicadores.dtos.AreaFuncional;
import com.supervisor.indicadores.dtos.Party;
import com.supervisor.indicadores.dtos.UnidadFuncional;
import com.supervisor.indicadores.entity.Ubicacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IUbicacionRepository extends JpaRepository<Ubicacion, String> {

    @Query("select distinct new com.supervisor.indicadores.dtos.AreaFuncional(a.area_conocida, a.id_area, a.nombre_area) from Ubicacion a  order by a.id_area ASC")
    List<AreaFuncional> findDistinctAreas();

    @Query("select new com.supervisor.indicadores.dtos.UnidadFuncional(a.id_unidad, a.nombre_unidad) from Ubicacion a where a.id_area = ?1 ")
    List<UnidadFuncional> findUnidadesPorArea(String id_area);
}
