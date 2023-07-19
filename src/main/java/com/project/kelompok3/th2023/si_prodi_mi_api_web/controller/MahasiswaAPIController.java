package com.project.kelompok3.th2023.si_prodi_mi_api_web.controller;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.MahasiswaAPI;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.response.ListMahasiswaResponse;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.response.LoginMahasiswaResponse;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.service.MahasiswaAPIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MahasiswaAPIController {
    @Autowired
    MahasiswaAPIService mahasiswaService;

    @GetMapping("/getMahasiswaAPIByKelas")
    public ResponseEntity<ListMahasiswaResponse> getMahasiswaByKelas(@RequestParam("kelas") String kelas){
        List<MahasiswaAPI> mahasiswaList = mahasiswaService.getListMahasiswaBykelas(kelas);
        ListMahasiswaResponse listMahasiswaResponse = new ListMahasiswaResponse();
        try{
            listMahasiswaResponse.setmMahasiswa(mahasiswaList);
            listMahasiswaResponse.setMessage("Ambil Data Berhasil");
            listMahasiswaResponse.setStatus(200);
        }catch (Exception e){
            listMahasiswaResponse.setmMahasiswa(null);
            listMahasiswaResponse.setMessage("Data Kosong");
            listMahasiswaResponse.setStatus(404);
        }
        return ResponseEntity.ok(listMahasiswaResponse);
    }

    @GetMapping("/getMahasiswaAPI")
    public MahasiswaAPI[] getMahasiswa(@RequestParam("nim") String nim){
        return mahasiswaService.getMahasiswaByNim(nim);
    }

    @PostMapping("/LoginMahasiswaAPI")
    public ResponseEntity<LoginMahasiswaResponse> doLogin(@RequestParam("nim") String nim){
        MahasiswaAPI[] mahasiswa = mahasiswaService.getMahasiswaByNim(nim);
        LoginMahasiswaResponse loginMahasiswaResponse = new LoginMahasiswaResponse();
        try {
            loginMahasiswaResponse.setmMahasiswa(mahasiswa[0]);
            loginMahasiswaResponse.setMessage("Login Berhasil");
            loginMahasiswaResponse.setStatus(200);
        }catch (Exception e){
            loginMahasiswaResponse.setmMahasiswa(null);
            loginMahasiswaResponse.setMessage("Akun tidak ditemukan");
            loginMahasiswaResponse.setStatus(404);
        }
        return ResponseEntity.ok(loginMahasiswaResponse);
    }
}
