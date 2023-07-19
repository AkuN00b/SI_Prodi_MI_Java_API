package com.project.kelompok3.th2023.si_prodi_mi_api_web.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Mahasiswa")
public class Mahasiswa {
    @Id
    @Column(name = "nim", columnDefinition = "VARCHAR(255)")
    private String nim;

    @Column(name = "nama")
    private String nama;

    @Column(name = "email")
    private String email;

    @Column(name = "kelas")
    private String kelas;

    @Column(name = "password")
    private String password;

    @Column(name = "register_date")
    private Date register_date;

    @Column(name = "status")
    private String status;

    public Mahasiswa() {

    }

    public Mahasiswa(String nim, String nama, String email, String kelas, String password, Date register_date, String status) {
        this.nim = nim;
        this.nama = nama;
        this.email = email;
        this.kelas = kelas;
        this.password = password;
        this.register_date = register_date;
        this.status = status;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegister_date() {
        return register_date;
    }

    public void setRegister_date(Date register_date) {
        this.register_date = register_date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
