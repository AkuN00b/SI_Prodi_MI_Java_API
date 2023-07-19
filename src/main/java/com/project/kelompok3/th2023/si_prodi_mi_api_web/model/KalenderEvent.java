package com.project.kelompok3.th2023.si_prodi_mi_api_web.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "KalenderEvent")
public class KalenderEvent {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID idKalendarEvent;

    @Column(name = "nama")
    private String namaKalenderEvent;

    @Column(name = "tanggalEvent")
    private Date tanggalKalenderEvent;

    @Column(name = "created_by")
    private String createdbyKalenderEvent;

    @Column(name = "created_date")
    private LocalDateTime createddateKalenderEvent;

    @Column(name = "modified_by")
    private String modifiedbyKalenderEvent;

    @Column(name = "modified_date")
    private LocalDateTime modifieddateKalenderEvent;

    @Column(name = "status")
    private String statusKalenderEvent;

    public KalenderEvent() {

    }

    public KalenderEvent(UUID idKalendarEvent, String namaKalenderEvent, Date tanggalKalenderEvent, String createdbyKalenderEvent, LocalDateTime createddateKalenderEvent, String modifiedbyKalenderEvent, LocalDateTime modifieddateKalenderEvent, String statusKalenderEvent) {
        this.idKalendarEvent = idKalendarEvent;
        this.namaKalenderEvent = namaKalenderEvent;
        this.tanggalKalenderEvent = tanggalKalenderEvent;
        this.createdbyKalenderEvent = createdbyKalenderEvent;
        this.createddateKalenderEvent = createddateKalenderEvent;
        this.modifiedbyKalenderEvent = modifiedbyKalenderEvent;
        this.modifieddateKalenderEvent = modifieddateKalenderEvent;
        this.statusKalenderEvent = statusKalenderEvent;
    }

    public KalenderEvent(UUID idKalendarEvent, String namaKalenderEvent, Date tanggalKalenderEvent) {
        this.idKalendarEvent = idKalendarEvent;
        this.namaKalenderEvent = namaKalenderEvent;
        this.tanggalKalenderEvent = tanggalKalenderEvent;
    }

    public KalenderEvent(String namaKalenderEvent, Date tanggalKalenderEvent, String s) {
        this.namaKalenderEvent = namaKalenderEvent;
        this.tanggalKalenderEvent = tanggalKalenderEvent;
        this.statusKalenderEvent = s;
    }

    public UUID getIdKalendarEvent() {
        return idKalendarEvent;
    }

    public void setIdKalendarEvent(UUID idKalendarEvent) {
        this.idKalendarEvent = idKalendarEvent;
    }

    public String getNamaKalenderEvent() {
        return namaKalenderEvent;
    }

    public void setNamaKalenderEvent(String namaKalenderEvent) {
        this.namaKalenderEvent = namaKalenderEvent;
    }

    public Date getTanggalKalenderEvent() {
        return tanggalKalenderEvent;
    }

    public void setTanggalKalenderEvent(Date tanggalKalenderEvent) {
        this.tanggalKalenderEvent = tanggalKalenderEvent;
    }

    public String getCreatedbyKalenderEvent() {
        return createdbyKalenderEvent;
    }

    public void setCreatedbyKalenderEvent(String createdbyKalenderEvent) {
        this.createdbyKalenderEvent = createdbyKalenderEvent;
    }

    public LocalDateTime getCreateddateKalenderEvent() {
        return createddateKalenderEvent;
    }

    public void setCreateddateKalenderEvent(LocalDateTime createddateKalenderEvent) {
        this.createddateKalenderEvent = createddateKalenderEvent;
    }

    public String getModifiedbyKalenderEvent() {
        return modifiedbyKalenderEvent;
    }

    public void setModifiedbyKalenderEvent(String modifiedbyKalenderEvent) {
        this.modifiedbyKalenderEvent = modifiedbyKalenderEvent;
    }

    public LocalDateTime getModifieddateKalenderEvent() {
        return modifieddateKalenderEvent;
    }

    public void setModifieddateKalenderEvent(LocalDateTime modifieddateKalenderEvent) {
        this.modifieddateKalenderEvent = modifieddateKalenderEvent;
    }

    public String getStatusKalenderEvent() {
        return statusKalenderEvent;
    }

    public void setStatusKalenderEvent(String statusKalenderEvent) {
        this.statusKalenderEvent = statusKalenderEvent;
    }
}
