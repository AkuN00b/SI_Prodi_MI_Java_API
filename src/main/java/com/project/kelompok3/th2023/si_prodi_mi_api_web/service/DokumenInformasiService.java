package com.project.kelompok3.th2023.si_prodi_mi_api_web.service;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.DokumenInformasi;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Role;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.repository.DokumenInformasiRepository;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.Comparator;
import java.util.stream.Collectors;

@Service
public class DokumenInformasiService {
    @Autowired
    DokumenInformasiRepository dokumenInformasiRepository;

    public boolean save (DokumenInformasi dokumenInformasi) {
        dokumenInformasi.setCreated_date(LocalDateTime.now());
        DokumenInformasi result = dokumenInformasiRepository.save(dokumenInformasi);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public List<DokumenInformasi> getDokumenInformasiById(UUID id_informasi) {
        List<DokumenInformasi> dokumenInformasis = dokumenInformasiRepository.findAll();

        List<DokumenInformasi> filteredList = dokumenInformasis.stream()
                .filter(d -> d.getId_informasi().equals(id_informasi))
                .collect(Collectors.toList());

        return filteredList;
    }

    public void deleteDokumenInformasi(Integer id) {
        dokumenInformasiRepository.deleteDokumenInformasiById(id);
    }
}
