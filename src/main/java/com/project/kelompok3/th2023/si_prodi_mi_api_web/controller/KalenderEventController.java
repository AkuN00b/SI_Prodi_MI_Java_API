package com.project.kelompok3.th2023.si_prodi_mi_api_web.controller;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.KalenderEvent;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.service.KalenderEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class KalenderEventController {
    @Autowired
    KalenderEventService kalenderEventService;

    @GetMapping("/saveKalenderEvent")
    public ResponseEntity<Void> save(HttpServletResponse response, @RequestParam(name = "namaKalenderEvent") String namaKalenderEvent, @RequestParam(name = "tanggalKalenderEvent") String tanggalKalenderEvent,
                                     @RequestParam(name = "byUser") String byUser) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date tanggalKalenderEventDate = format.parse(tanggalKalenderEvent);
        KalenderEvent kalenderEvent = new KalenderEvent(namaKalenderEvent,tanggalKalenderEventDate,"0");
        kalenderEvent.setCreatedbyKalenderEvent(byUser);
        kalenderEvent.setModifiedbyKalenderEvent(byUser);
        kalenderEventService.save(kalenderEvent);

        return ResponseEntity.status(HttpStatus.FOUND).location(URI.create("http://localhost:8080/admin/kalenderevent.html")).build();
    }

    @GetMapping("/getKalenderEvent")
    public KalenderEvent getKalenderEvent(HttpServletResponse response, @RequestParam("id") UUID id) {
        KalenderEvent kalenderEvent = kalenderEventService.getKalenderEvent(id);
        return kalenderEvent;
    }

    @GetMapping("/getKalenderEvents")
    public List<KalenderEvent> getKalenderEvents() { return kalenderEventService.getKalenderEvents(); }

    @GetMapping("/getKalenderEventsAktif")
    public List<KalenderEvent> getKalenderEventAktif() {
        List<KalenderEvent> kalenderEvents = kalenderEventService.getKalenderEvents();

        // Filter KalenderEvent yang hanya memiliki status aktif
        List<KalenderEvent> activeKalenderEvents = kalenderEvents.stream()
                .filter(kalenderEvent -> kalenderEvent.getStatusKalenderEvent().equals("Aktif"))
                .collect(Collectors.toList());

        return activeKalenderEvents;
    }

    @GetMapping("/updateKalenderEvent")
    public ResponseEntity<Void> update(HttpServletResponse response,
                                       @RequestParam(name = "idKalendarEvent") UUID idKalenderEvent,
                                       @RequestParam(name = "namaKalenderEvent") String namaKalenderEvent,
                                       @RequestParam(name = "tanggalKalenderEvent") String tanggalKalenderEvent,
                                       @RequestParam(name = "byUser") String byUser) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date tanggalKalenderEventDate = format.parse(tanggalKalenderEvent);
        KalenderEvent kalenderEvent = new KalenderEvent (idKalenderEvent, namaKalenderEvent, tanggalKalenderEventDate);
        kalenderEvent.setModifiedbyKalenderEvent(byUser);
        kalenderEventService.updateKalenderEvent(kalenderEvent);

        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/admin/kalenderevent.html")).build();
    }

    @DeleteMapping("/deleteKalenderEvent")
    public ResponseEntity<String> deleteById(@RequestParam("idKalenderEvent") UUID idKalenderEvent,
                                             @RequestParam(name = "byUser") String byUser) {
        kalenderEventService.deleteKalenderEvent(idKalenderEvent, byUser);
        return ResponseEntity.ok("Kalender Event with UUID: " + idKalenderEvent + ". Deleted Successfully");
    }
}
