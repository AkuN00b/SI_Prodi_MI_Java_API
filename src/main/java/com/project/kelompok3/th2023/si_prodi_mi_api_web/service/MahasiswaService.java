package com.project.kelompok3.th2023.si_prodi_mi_api_web.service;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Mahasiswa;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.repository.MahasiswaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class MahasiswaService {
    @Autowired
    MahasiswaRepository mahasiswaRepository;

    public static String encryptSHA256(String password) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] encodedHash = digest.digest(password.getBytes(StandardCharsets.UTF_8));

        // Konversi byte array menjadi bentuk string heksadesimal
        StringBuilder hexString = new StringBuilder();
        for (byte b : encodedHash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();
    }

    public boolean save (Mahasiswa mahasiswa) {
        mahasiswa.setStatus("Aktif");
        mahasiswa.setRegister_date(Date.valueOf(LocalDate.now()));

        try {
            mahasiswa.setPassword(encryptSHA256(mahasiswa.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Error occurred during password encryption: " + e.getMessage());
        }

        Mahasiswa result = mahasiswaRepository.save(mahasiswa);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public Mahasiswa getMahasiswa(String nim) {
        Mahasiswa mahasiswa = mahasiswaRepository.getMahasiswaByNim(nim);
        return mahasiswa;
    }

    public List<Mahasiswa> getMahasiswas() {
        return mahasiswaRepository.findAll();
    }

    public boolean updateMahasiswa(Mahasiswa mahasiswa) {
        mahasiswa.setStatus("Aktif");
        Mahasiswa result = mahasiswaRepository.save(mahasiswa);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public void deleteMahasiswa(String nim) {
        Mahasiswa mahasiswa = mahasiswaRepository.getMahasiswaByNim(nim);
        mahasiswa.setStatus("Tidak Aktif");

        mahasiswaRepository.save(mahasiswa);
    }
}
