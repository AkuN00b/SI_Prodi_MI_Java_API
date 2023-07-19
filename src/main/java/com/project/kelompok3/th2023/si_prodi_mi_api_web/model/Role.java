package com.project.kelompok3.th2023.si_prodi_mi_api_web.model;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "Role")
public class Role {
    @Id
    @GeneratedValue(generator = "uuid2")
    @Column(name = "id", columnDefinition = "VARCHAR(255)")
                private UUID idRole;

    @Column(name = "nama")
    private String namaRole;

    @Column(name = "status")
    private String statusRole;

    public Role() {

    }

    public Role(UUID idRole, String namaRole, String statusRole) {
        this.idRole = idRole;
        this.namaRole = namaRole;
        this.statusRole = statusRole;
    }

    public Role(String namaRole, String statusRole) {
        this.namaRole = namaRole;
        this.statusRole = statusRole;
    }

    public UUID getIdRole() {
        return idRole;
    }

    public void setIdRole(UUID idRole) {
        this.idRole = idRole;
    }

    public String getNamaRole() {
        return namaRole;
    }

    public void setNamaRole(String namaRole) {
        this.namaRole = namaRole;
    }

    public String getStatusRole() {
        return statusRole;
    }

    public void setStatusRole(String statusRole) {
        this.statusRole = statusRole;
    }
}
