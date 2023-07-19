package com.project.kelompok3.th2023.si_prodi_mi_api_web.repository;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.DetailKelasInformasi;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Informasi;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface DetailKelasInformasiRepository extends CrudRepository<DetailKelasInformasi, Integer> {
    @Query("SELECT dki FROM DetailKelasInformasi dki WHERE dki.id =:id")
    public DetailKelasInformasi getDetailKelasInformasiById(@Param("id") Integer id);

    List<DetailKelasInformasi> findAll();
}
