package com.project.kelompok3.th2023.si_prodi_mi_api_web.service;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Karyawan;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Mahasiswa;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Role;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.repository.KaryawanRepository;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

import static com.project.kelompok3.th2023.si_prodi_mi_api_web.service.MahasiswaService.encryptSHA256;

@Service
public class KaryawanService {
    @Autowired
    KaryawanRepository karyawanRepository;

    @Autowired
    RoleRepository roleRepository;

    public boolean save (Karyawan karyawan) {
        karyawan.setStatus("Aktif");
        karyawan.setRegister_date(Date.valueOf(LocalDate.now()));

        try {
            karyawan.setPassword(encryptSHA256(karyawan.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error occurred during password encryption: " + e.getMessage());
        }

        Karyawan result = karyawanRepository.save(karyawan);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public Karyawan getKaryawan(String npk) {
        Karyawan karyawan = karyawanRepository.getKaryawanByNpk(npk);
        return karyawan;
    }

    public List<Karyawan> getKaryawans() {
        return karyawanRepository.findAll();
    }

    public boolean updateKaryawan(Karyawan karyawan) {
        karyawan.setStatus("Aktif");

        try {
            karyawan.setPassword(encryptSHA256(karyawan.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error occurred during password encryption: " + e.getMessage());
        }

        Karyawan result = karyawanRepository.save(karyawan);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public boolean updateRoleKaryawan (String npk, String nama, String email, String password, UUID id_role) throws NoSuchAlgorithmException {
        Karyawan karyawan = karyawanRepository.getKaryawanByNpk(npk);
        karyawan.setId_role(id_role);
        karyawan.setNama(nama);
        karyawan.setEmail(email);

        if(!password.equals(null) && !password.trim().isEmpty() && !password.equals("")) {
            karyawan.setPassword(encryptSHA256(password));
        }

        Karyawan result = karyawanRepository.save(karyawan);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public void deleteKaryawan(String npk) {
        Karyawan karyawan = karyawanRepository.getKaryawanByNpk(npk);
        karyawan.setStatus("Tidak Aktif");

        karyawanRepository.save(karyawan);
    }
}
