package com.project.kelompok3.th2023.si_prodi_mi_api_web.service;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Informasi;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Karyawan;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.repository.InformasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class InformasiService {
    @Autowired
    InformasiRepository informasiRepository;

    public boolean save (Informasi informasi) {
        informasi.setStatusInformasi("Aktif");
        informasi.setCreateddateInformasi(LocalDateTime.now());
        informasi.setModifieddateInformasi(LocalDateTime.now());

        Informasi result = informasiRepository.save(informasi);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public boolean savePIC (Informasi informasi) {
        informasi.setStatusInformasi("Pengajuan");
        informasi.setCreateddateInformasi(LocalDateTime.now());
        informasi.setModifieddateInformasi(LocalDateTime.now());

        Informasi result = informasiRepository.save(informasi);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public Informasi getInformasi(UUID idInformasi) {
        Informasi informasi = informasiRepository.getInformasiByIdInformasi(idInformasi);
        return informasi;
    }

    public List<Informasi> getInformasis() {
        List<Informasi> informasis = informasiRepository.findAll();

        // Menggunakan Comparator untuk membandingkan statusInformasi secara terbalik (Pengajuan paling atas)
        Comparator<Informasi> comparator = Comparator.comparing((Informasi informasi) -> informasi.getStatusInformasi().equals("Pengajuan") ? 1 : 0)
                .thenComparing(Informasi::getModifieddateInformasi)
                .reversed();

        // Menyortir list berdasarkan statusInformasi dan modifieddateInformasi secara terbalik
        informasis.sort(comparator);

        return informasis;
    }

    public List<Informasi> getInformasisPIC(String byUser) {
        List<Informasi> informasis = informasiRepository.findAll();

        // Filter informasis by the createdbyInformasi field
        informasis = informasis.stream()
                .filter(informasi -> informasi.getCreatedbyInformasi().equals(byUser))
                .collect(Collectors.toList());

        // Sort informasis by modifieddateInformasi in descending order
        Comparator<Informasi> comparator = Comparator.comparing(Informasi::getModifieddateInformasi).reversed();
        informasis.sort(comparator);

        return informasis;
    }

    public boolean updateInformasi(Informasi informasi) {
        Informasi informasi1 = informasiRepository.getInformasiByIdInformasi(informasi.getIdInformasi());
        informasi1.setJudulInformasi(informasi.getJudulInformasi());
        informasi1.setDeskripsiInformasi(informasi.getDeskripsiInformasi());
        informasi1.setModifieddateInformasi(LocalDateTime.now());
        informasi1.setModifiedbyInformasi(informasi.getModifiedbyInformasi());

        Informasi result = informasiRepository.save(informasi1);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public void deleteInformasi(UUID id, String byUser) {
        Informasi informasi = informasiRepository.getInformasiByIdInformasi(id);
        informasi.setStatusInformasi("Tidak Aktif");
        informasi.setModifiedbyInformasi(byUser);

        informasiRepository.save(informasi);
    }

    public void accInformasi(UUID id, String byUser) {
        Informasi informasi = informasiRepository.getInformasiByIdInformasi(id);
        informasi.setStatusInformasi("Aktif");
        informasi.setModifiedbyInformasi(byUser);

        informasiRepository.save(informasi);
    }
}
