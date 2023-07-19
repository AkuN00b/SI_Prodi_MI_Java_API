package com.project.kelompok3.th2023.si_prodi_mi_api_web.service;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Informasi;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.KalenderEvent;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.repository.KalenderEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class KalenderEventService {
    @Autowired
    KalenderEventRepository kalenderEventRepository;

    public boolean save (KalenderEvent kalenderEvent) {
        kalenderEvent.setStatusKalenderEvent("Aktif");
        kalenderEvent.setCreateddateKalenderEvent(LocalDateTime.now());
        kalenderEvent.setModifieddateKalenderEvent(LocalDateTime.now());

        KalenderEvent result = kalenderEventRepository.save(kalenderEvent);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public KalenderEvent getKalenderEvent(UUID id) {
        KalenderEvent kalenderEvent = kalenderEventRepository.getKalenderEventByIdKalendarEvent(id);
        return kalenderEvent;
    }

    public List<KalenderEvent> getKalenderEvents() {
        List<KalenderEvent> kalenderEvents = kalenderEventRepository.findAll();

        // Menggunakan Comparator untuk membandingkan tanggalKalenderEvent
        Comparator<KalenderEvent> comparator = Comparator.comparing(KalenderEvent::getTanggalKalenderEvent).reversed();

        // Menyortir list berdasarkan tanggalKalenderEvent
        kalenderEvents.sort(comparator);

        return kalenderEvents;
    }

    public boolean updateKalenderEvent(KalenderEvent kalenderEvent) {
        KalenderEvent kalenderEvent1 = kalenderEventRepository.getKalenderEventByIdKalendarEvent(kalenderEvent.getIdKalendarEvent());
        kalenderEvent1.setNamaKalenderEvent(kalenderEvent.getNamaKalenderEvent());
        kalenderEvent1.setTanggalKalenderEvent(kalenderEvent.getTanggalKalenderEvent());
        kalenderEvent1.setModifieddateKalenderEvent(LocalDateTime.now());
        kalenderEvent1.setModifiedbyKalenderEvent(kalenderEvent.getModifiedbyKalenderEvent());

        KalenderEvent result = kalenderEventRepository.save(kalenderEvent1);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public void deleteKalenderEvent(UUID id, String byUser) {
        KalenderEvent kalenderEvent = kalenderEventRepository.getKalenderEventByIdKalendarEvent(id);
        kalenderEvent.setStatusKalenderEvent("Tidak Aktif");
        kalenderEvent.setModifiedbyKalenderEvent(byUser);

        kalenderEventRepository.save(kalenderEvent);
    }
}
