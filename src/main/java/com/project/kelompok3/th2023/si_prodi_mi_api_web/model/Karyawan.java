package com.project.kelompok3.th2023.si_prodi_mi_api_web.model;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Karyawan")
public class Karyawan {
    @Id
    @Column(name = "npk", columnDefinition = "VARCHAR(255)")
    private String npk;

    @Column(name = "nama")
    private String nama;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "id_role")
    private UUID id_role;

    @Column(name = "register_date")
    private Date register_date;

    @Column(name = "status")
    private String status;

    public Karyawan() {

    }

    public Karyawan(String npk, String nama, String email, String password, UUID id_role, Date register_date, String status) {
        this.npk = npk;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.id_role = id_role;
        this.register_date = register_date;
        this.status = status;
    }

    public Karyawan(String npk, String nama, String email, String password, UUID id_role) {
        this.npk = npk;
        this.nama = nama;
        this.email = email;
        this.password = password;
        this.id_role = id_role;
    }

    public String getNpk() {
        return npk;
    }

    public void setNpk(String npk) {
        this.npk = npk;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UUID getId_role() {
        return id_role;
    }

    public void setId_role(UUID id_role) {
        this.id_role = id_role;
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
