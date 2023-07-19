package com.project.kelompok3.th2023.si_prodi_mi_api_web.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "DokumenInformasi")
public class DokumenInformasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_informasi")
    private UUID id_informasi;

    @Column(name = "nama_file")
    private String nama_file;

    @Column(name = "created_by")
    private String created_by;

    @Column(name = "created_date")
    private LocalDateTime created_date;

    public DokumenInformasi() {

    }

    public DokumenInformasi(Integer id, UUID id_informasi, String nama_file, String created_by, LocalDateTime created_date) {
        this.id = id;
        this.id_informasi = id_informasi;
        this.nama_file = nama_file;
        this.created_by = created_by;
        this.created_date = created_date;
    }

    public DokumenInformasi(UUID id_informasi, String nama_file, String created_by) {
        this.id_informasi = id_informasi;
        this.nama_file = nama_file;
        this.created_by = created_by;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public UUID getId_informasi() {
        return id_informasi;
    }

    public void setId_informasi(UUID id_informasi) {
        this.id_informasi = id_informasi;
    }

    public String getNama_file() {
        return nama_file;
    }

    public void setNama_file(String nama_file) {
        this.nama_file = nama_file;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    public LocalDateTime getCreated_date() {
        return created_date;
    }

    public void setCreated_date(LocalDateTime created_date) {
        this.created_date = created_date;
    }
}
