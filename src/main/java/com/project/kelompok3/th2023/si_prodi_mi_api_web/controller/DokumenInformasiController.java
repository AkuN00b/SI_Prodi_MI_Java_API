package com.project.kelompok3.th2023.si_prodi_mi_api_web.controller;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.DokumenInformasi;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Role;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.service.DokumenInformasiService;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class DokumenInformasiController {
    @Autowired
    DokumenInformasiService dokumenInformasiService;

    @GetMapping("/saveDokumenInformasi")
    public void save(HttpServletResponse response,
                     @RequestParam(name = "id_informasi") UUID id_informasi,
                     @RequestParam(name = "nama_file") String nama_file,
                     @RequestParam(name = "created_by") String created_by) {

        DokumenInformasi dokumenInformasi = new DokumenInformasi(id_informasi, nama_file, created_by);
        dokumenInformasiService.save(dokumenInformasi);
    }

    @GetMapping("/getDokumenInformasi")
    public List<DokumenInformasi> getDokumenInformasi(HttpServletResponse response,
                                                      @RequestParam(name = "id_informasi") UUID id_informasi) {
        List<DokumenInformasi> dokumenInformasis = dokumenInformasiService.getDokumenInformasiById(id_informasi);
        return dokumenInformasis;
    }

    @DeleteMapping("/deleteDokumenInformasi")
    public ResponseEntity<String> deleteById(@RequestParam("id") Integer id) {
        dokumenInformasiService.deleteDokumenInformasi(id);
        return ResponseEntity.ok("Dokumen Informasi with ID: " + id + ". Deleted Successfully");
    }
}
