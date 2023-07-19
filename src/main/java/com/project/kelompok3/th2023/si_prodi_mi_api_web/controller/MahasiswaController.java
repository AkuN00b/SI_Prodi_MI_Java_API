package com.project.kelompok3.th2023.si_prodi_mi_api_web.controller;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.Result;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Mahasiswa;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Role;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.service.MahasiswaService;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class MahasiswaController {
    @Autowired
    MahasiswaService mahasiswaService;

    @PostMapping("/saveMahasiswa")
    public Result save(HttpServletResponse response, @RequestBody Mahasiswa mahasiswaParam) {
        Mahasiswa mahasiswa = new Mahasiswa(mahasiswaParam.getNim(), mahasiswaParam.getNama(), mahasiswaParam.getEmail(),
                                            mahasiswaParam.getKelas(), mahasiswaParam.getPassword(), mahasiswaParam.getRegister_date(),
                                            mahasiswaParam.getStatus());
        boolean isSuccess = mahasiswaService.save(mahasiswa);

        if (isSuccess) {
            return new Result(500, "Success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(200, "Fail");
        }
    }

    @GetMapping("/getMahasiswa")
    public Mahasiswa getMahasiswa(HttpServletResponse response, @RequestParam("nim") String nim) {
        Mahasiswa mahasiswa = mahasiswaService.getMahasiswa(nim);
        return mahasiswa;
    }

    @GetMapping("/getMahasiswas")
    public List<Mahasiswa> getMahasiswas(HttpServletResponse response){
        List<Mahasiswa> mahasiswas = mahasiswaService.getMahasiswas();
        return mahasiswas;
    }

    @GetMapping("/getMahasiswasAktif")
    public List<Mahasiswa> getMahasiswaAktif() {
        List<Mahasiswa> mahasiswas = mahasiswaService.getMahasiswas();

        // Filter mahasiswa yang hanya memiliki status aktif
        List<Mahasiswa> activeMahasiswas = mahasiswas.stream()
                .filter(mahasiswa -> mahasiswa.getStatus().equals("Aktif"))
                .collect(Collectors.toList());

        return activeMahasiswas;
    }

    @DeleteMapping("/deleteMahasiswa")
    public ResponseEntity<String> deleteByNim(@RequestParam("nim") String nim) {
        mahasiswaService.deleteMahasiswa(nim);
        return ResponseEntity.ok("Mahasiswa with NIM: " + nim + ". Deleted Successfully");
    }
}
