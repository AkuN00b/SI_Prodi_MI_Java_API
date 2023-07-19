package com.project.kelompok3.th2023.si_prodi_mi_api_web.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "DetailKelasInformasi")
public class DetailKelasInformasi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "id_informasi")
    private UUID id_informasi;

    @Column(name = "kelas")
    private String kelas;

    public DetailKelasInformasi() {

    }

    public DetailKelasInformasi(Integer id, UUID id_informasi, String kelas) {
        this.id = id;
        this.id_informasi = id_informasi;
        this.kelas = kelas;
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

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }
}
