package com.project.kelompok3.th2023.si_prodi_mi_api_web.repository;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Karyawan;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface KaryawanRepository extends CrudRepository<Karyawan, String> {
    @Query("SELECT k FROM Karyawan k WHERE k.npk =:npk")
    public Karyawan getKaryawanByNpk(@Param("npk") String npk);

    List<Karyawan> findAll();
}
