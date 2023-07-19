package com.project.kelompok3.th2023.si_prodi_mi_api_web.repository;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.DetailKelasInformasi;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Mahasiswa;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MahasiswaRepository extends CrudRepository<Mahasiswa, String> {
    @Query("SELECT m FROM Mahasiswa m WHERE m.nim =:nim")
    public Mahasiswa getMahasiswaByNim(@Param("nim") String nim);

    List<Mahasiswa> findAll();
}
