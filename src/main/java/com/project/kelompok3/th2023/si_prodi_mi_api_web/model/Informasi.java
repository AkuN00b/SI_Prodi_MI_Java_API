package com.project.kelompok3.th2023.si_prodi_mi_api_web.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Informasi")
public class Informasi {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
    private UUID idInformasi;

    @Column(name = "judul")
    private String judulInformasi;

    @Column(name = "deskripsi")
    private String deskripsiInformasi;

    @Column(name = "created_by")
    private String createdbyInformasi;

    @Column(name = "created_date")
    private LocalDateTime createddateInformasi;

    @Column(name = "modified_by")
    private String modifiedbyInformasi;

    @Column(name = "modified_date")
    private LocalDateTime modifieddateInformasi;

    @Column(name = "status")
    private String statusInformasi;

    public Informasi() {

    }

    public Informasi(UUID idInformasi, String judulInformasi, String deskripsiInformasi, String createdbyInformasi, LocalDateTime createddateInformasi, String modifiedbyInformasi, LocalDateTime modifieddateInformasi, String statusInformasi) {
        this.idInformasi = idInformasi;
        this.judulInformasi = judulInformasi;
        this.deskripsiInformasi = deskripsiInformasi;
        this.createdbyInformasi = createdbyInformasi;
        this.createddateInformasi = createddateInformasi;
        this.modifiedbyInformasi = modifiedbyInformasi;
        this.modifieddateInformasi = modifieddateInformasi;
        this.statusInformasi = statusInformasi;
    }

    public Informasi(UUID idInformasi, String judulInformasi, String deskripsiInformasi) {
        this.idInformasi = idInformasi;
        this.judulInformasi = judulInformasi;
        this.deskripsiInformasi = deskripsiInformasi;
    }

    public Informasi(String judulInformasi, String deskripsiInformasi, String s) {
        this.judulInformasi = judulInformasi;
        this.deskripsiInformasi = deskripsiInformasi;
        this.statusInformasi = s;
    }

    public UUID getIdInformasi() {
        return idInformasi;
    }

    public void setIdInformasi(UUID idInformasi) {
        this.idInformasi = idInformasi;
    }

    public String getJudulInformasi() {
        return judulInformasi;
    }

    public void setJudulInformasi(String judulInformasi) {
        this.judulInformasi = judulInformasi;
    }

    public String getDeskripsiInformasi() {
        return deskripsiInformasi;
    }

    public void setDeskripsiInformasi(String deskripsiInformasi) {
        this.deskripsiInformasi = deskripsiInformasi;
    }

    public String getCreatedbyInformasi() {
        return createdbyInformasi;
    }

    public void setCreatedbyInformasi(String createdbyInformasi) {
        this.createdbyInformasi = createdbyInformasi;
    }

    public LocalDateTime getCreateddateInformasi() {
        return createddateInformasi;
    }

    public void setCreateddateInformasi(LocalDateTime createddateInformasi) {
        this.createddateInformasi = createddateInformasi;
    }

    public String getModifiedbyInformasi() {
        return modifiedbyInformasi;
    }

    public void setModifiedbyInformasi(String modifiedbyInformasi) {
        this.modifiedbyInformasi = modifiedbyInformasi;
    }

    public LocalDateTime getModifieddateInformasi() {
        return modifieddateInformasi;
    }

    public void setModifieddateInformasi(LocalDateTime modifieddateInformasi) {
        this.modifieddateInformasi = modifieddateInformasi;
    }

    public String getStatusInformasi() {
        return statusInformasi;
    }

    public void setStatusInformasi(String statusInformasi) {
        this.statusInformasi = statusInformasi;
    }
}