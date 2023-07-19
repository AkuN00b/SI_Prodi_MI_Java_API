package com.project.kelompok3.th2023.si_prodi_mi_api_web.repository;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Informasi;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface InformasiRepository extends CrudRepository<Informasi, UUID> {
    @Query("SELECT i FROM Informasi i WHERE i.idInformasi =:id")
    public Informasi getInformasiByIdInformasi(@Param("id") UUID id);

    List<Informasi> findAll();
}
