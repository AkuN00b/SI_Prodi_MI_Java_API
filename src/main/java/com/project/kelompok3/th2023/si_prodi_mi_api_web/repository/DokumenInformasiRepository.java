package com.project.kelompok3.th2023.si_prodi_mi_api_web.repository;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.DetailKelasInformasi;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.DokumenInformasi;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

public interface DokumenInformasiRepository extends CrudRepository<DokumenInformasi, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM DokumenInformasi di WHERE di.id = :id")
    public void deleteDokumenInformasiById(@Param("id") Integer id);

    List<DokumenInformasi> findAll();
}
