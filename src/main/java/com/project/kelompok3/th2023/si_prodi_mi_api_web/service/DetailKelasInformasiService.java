package com.project.kelompok3.th2023.si_prodi_mi_api_web.service;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.DetailKelasInformasi;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.repository.DetailKelasInformasiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailKelasInformasiService {
    @Autowired
    DetailKelasInformasiRepository detailKelasInformasiRepository;

    public boolean save (DetailKelasInformasi detailKelasInformasi) {
        DetailKelasInformasi result = detailKelasInformasiRepository.save(detailKelasInformasi);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public DetailKelasInformasi getDetailKelasInformasi(Integer id) {
        DetailKelasInformasi detailKelasInformasi = detailKelasInformasiRepository.getDetailKelasInformasiById(id);
        return detailKelasInformasi;
    }

    public List<DetailKelasInformasi> getDetailKelasInformasis() {
        return detailKelasInformasiRepository.findAll();
    }

    public boolean updateDetailKelasInformasi(DetailKelasInformasi detailKelasInformasi) {
        DetailKelasInformasi result = detailKelasInformasiRepository.save(detailKelasInformasi);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }
}
