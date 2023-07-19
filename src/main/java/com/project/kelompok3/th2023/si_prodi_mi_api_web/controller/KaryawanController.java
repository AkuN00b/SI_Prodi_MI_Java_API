package com.project.kelompok3.th2023.si_prodi_mi_api_web.controller;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.Result;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Informasi;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Karyawan;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Mahasiswa;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.service.KaryawanService;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.service.MahasiswaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static com.project.kelompok3.th2023.si_prodi_mi_api_web.service.MahasiswaService.encryptSHA256;

@RestController
public class KaryawanController {
    @Autowired
    KaryawanService karyawanService;

    @GetMapping("/saveKaryawan")
    public ResponseEntity<Void> save(HttpServletResponse response,
                                     @RequestParam(name = "npk") String npk,
                                     @RequestParam(name = "nama") String nama,
                                     @RequestParam(name = "email") String email,
                                     @RequestParam(name = "password") String password,
                                     @RequestParam("role") UUID id_role) {
        Karyawan karyawan = new Karyawan(npk, nama, email, password, id_role);
        karyawanService.save(karyawan);

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/admin/karyawan.html")).build();
    }

    @GetMapping("/getKaryawan")
    public Karyawan getKaryawan(HttpServletResponse response, @RequestParam("npk") String npk) {
        Karyawan karyawan = karyawanService.getKaryawan(npk);
        return karyawan;
    }

    @GetMapping("/getKaryawans")
    public List<Karyawan> getKaryawans() { return karyawanService.getKaryawans(); }

    @GetMapping("/getKaryawansAktif")
    public List<Karyawan> getKaryawanAktif() {
        List<Karyawan> karyawans = karyawanService.getKaryawans();

        // Filter Karyawan yang hanya memiliki status aktif
        List<Karyawan> activeKaryawans = karyawans.stream()
                .filter(karyawan -> karyawan.getStatus().equals("Aktif"))
                .collect(Collectors.toList());

        return activeKaryawans;
    }

    @GetMapping("/getKaryawanLogin")
    public boolean getKaryawanLogin(HttpServletResponse response, @RequestParam("npk") String npk,
                                                                    @RequestParam("password") String password) throws NoSuchAlgorithmException {
        List<Karyawan> karyawans = karyawanService.getKaryawans();
        for (Karyawan karyawan : karyawans) {
            if (karyawan.getNpk().equals(npk) && karyawan.getPassword().equals(encryptSHA256(password))) {
                return true; // Mengembalikan objek Karyawan yang cocok dengan email dan password
            }
        }

        return false; // Jika tidak ada karyawan yang cocok, mengembalikan null atau bisa diganti dengan penanganan kesalahan yang sesuai
    }

    @GetMapping("/getDataKaryawanLogin")
    public Karyawan getDataKaryawanLogin(HttpServletResponse response, @RequestParam("npk") String npk,
                                    @RequestParam("password") String password) throws NoSuchAlgorithmException {
        List<Karyawan> karyawans = karyawanService.getKaryawans();
        for (Karyawan karyawan : karyawans) {
            if (karyawan.getNpk().equals(npk) && karyawan.getPassword().equals(encryptSHA256(password))) {
                return karyawan; // Mengembalikan objek Karyawan yang cocok dengan email dan password
            }
        }

        return null; // Jika tidak ada karyawan yang cocok, mengembalikan null atau bisa diganti dengan penanganan kesalahan yang sesuai
    }

    @GetMapping("/updateKaryawan")
    public ResponseEntity<Void> updateKaryawan(HttpServletResponse response,
                                               @RequestParam(name = "npk") String npk,
                                               @RequestParam(name = "nama") String nama,
                                               @RequestParam(name = "email") String email,
                                               @RequestParam(name = "password") String password,
                                               @RequestParam("role") UUID id_role) throws NoSuchAlgorithmException {
        karyawanService.updateRoleKaryawan(npk, nama, email, password, id_role);

        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/admin/karyawan.html")).build();
    }

    @DeleteMapping("/deleteKaryawan")
    public ResponseEntity<String> deleteById(@RequestParam("npk") String npk) {
        karyawanService.deleteKaryawan(npk);
        return ResponseEntity.ok("Karyawan with NPK: " + npk + ". Deleted Successfully");
    }
}
