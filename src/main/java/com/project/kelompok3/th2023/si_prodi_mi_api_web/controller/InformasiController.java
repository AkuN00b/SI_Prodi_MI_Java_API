package com.project.kelompok3.th2023.si_prodi_mi_api_web.controller;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.Result;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Informasi;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.KalenderEvent;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.service.InformasiService;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.service.KalenderEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class InformasiController {
    @Autowired
    InformasiService informasiService;

    @GetMapping("/saveInformasi")
    public ResponseEntity<Void> save(HttpServletResponse response, @RequestParam(name = "judulInformasi") String judulInformasi, @RequestParam(name = "deskripsiInformasi") String deskripsiInformasi,
                                     @RequestParam(name = "byUser") String byUser) {
        Informasi informasi = new Informasi(judulInformasi,deskripsiInformasi,"0");
        informasi.setCreatedbyInformasi(byUser);
        informasi.setModifiedbyInformasi(byUser);
        informasiService.save(informasi);

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/admin/informasi.html")).build();
    }

    @GetMapping("/saveInformasiPIC")
    public ResponseEntity<Void> savePIC(HttpServletResponse response, @RequestParam(name = "judulInformasi") String judulInformasi, @RequestParam(name = "deskripsiInformasi") String deskripsiInformasi,
                                     @RequestParam(name = "byUser") String byUser) {
        Informasi informasi = new Informasi(judulInformasi,deskripsiInformasi,"0");
        informasi.setCreatedbyInformasi(byUser);
        informasi.setModifiedbyInformasi(byUser);
        informasiService.savePIC(informasi);

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/pic/informasi.html")).build();
    }

    @GetMapping("/getInformasi")
    public Informasi getInformasi(HttpServletResponse response, @RequestParam("idInformasi") UUID idInformasi) {
        Informasi informasi = informasiService.getInformasi(idInformasi);
        return informasi;
    }

    @GetMapping("/getInformasis")
    public List<Informasi> getInformasis() { return informasiService.getInformasis(); }

    @GetMapping("/getInformasisPIC")
    public List<Informasi> getInformasisPIC(HttpServletResponse response, @RequestParam("byUser") String byUser) {
        return informasiService.getInformasisPIC(byUser);
    }

    @GetMapping("/getInformasisAktif")
    public List<Informasi> getInformasiAktif() {
        List<Informasi> informasis = informasiService.getInformasis();

        List<Informasi> activeInformasis = informasis.stream()
                .filter(informasi -> !informasi.getStatusInformasi().equals("Tidak Aktif"))
                .collect(Collectors.toList());

        return activeInformasis;
    }

    @GetMapping("/getInformasisAktifPIC")
    public List<Informasi> getInformasiAktifPIC(HttpServletResponse response, @RequestParam("byUser") String byUser) {
        List<Informasi> informasis = informasiService.getInformasisPIC(byUser);

        List<Informasi> activeInformasis = informasis.stream()
                .filter(informasi -> !informasi.getStatusInformasi().equals("Tidak Aktif"))
                .collect(Collectors.toList());

        return activeInformasis;
    }

    @GetMapping("/updateInformasi")
    public ResponseEntity<Void> update(HttpServletResponse response,
                                       @RequestParam(name = "idInformasi") UUID idInformasi,
                                       @RequestParam(name = "judulInformasi") String judulInformasi,
                                       @RequestParam(name = "deskripsiInformasi") String deskripsiInformasi,
                                       @RequestParam(name = "byUser") String byUser) {

        Informasi informasi = new Informasi (idInformasi, judulInformasi,deskripsiInformasi);
        informasi.setModifiedbyInformasi(byUser);
        informasiService.updateInformasi(informasi);

        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/admin/informasi.html")).build();
    }

    @GetMapping("/updateInformasiPIC")
    public ResponseEntity<Void> updatePIC(HttpServletResponse response,
                                       @RequestParam(name = "idInformasi") UUID idInformasi,
                                       @RequestParam(name = "judulInformasi") String judulInformasi,
                                       @RequestParam(name = "deskripsiInformasi") String deskripsiInformasi,
                                       @RequestParam(name = "byUser") String byUser) {

        Informasi informasi = new Informasi (idInformasi, judulInformasi,deskripsiInformasi);
        informasi.setModifiedbyInformasi(byUser);
        informasiService.updateInformasi(informasi);

        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/pic/informasi.html")).build();
    }

    @DeleteMapping("/deleteInformasi")
    public ResponseEntity<String> deleteById(@RequestParam("idInformasi") UUID idInformasi,
                                             @RequestParam(name = "byUser") String byUser) {
        informasiService.deleteInformasi(idInformasi, byUser);
        return ResponseEntity.ok("Informasi with UUID: " + idInformasi + ". Deleted Successfully");
    }

    @GetMapping("/accInformasi")
    public ResponseEntity<String> accInformasiById(@RequestParam("idInformasi") UUID idInformasi,
                                             @RequestParam(name = "byUser") String byUser) {
        informasiService.accInformasi(idInformasi, byUser);
        return ResponseEntity.ok("Informasi with UUID: " + idInformasi + ". Accepted Successfully");
    }
}
