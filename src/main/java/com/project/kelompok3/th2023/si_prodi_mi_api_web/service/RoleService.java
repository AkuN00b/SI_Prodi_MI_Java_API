package com.project.kelompok3.th2023.si_prodi_mi_api_web.service;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Role;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.repository.RoleRepository;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.UUID;

@Service
public class RoleService {
    @Autowired
    RoleRepository roleRepository;

    public boolean save (Role role) {
        role.setStatusRole("Aktif");
        Role result = roleRepository.save(role);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public Role getRole(UUID idRole) {
        Role role = roleRepository.getRoleByIdRole(idRole);
        return role;
    }

    public List<Role> getRoles() {
        List<Role> roles = roleRepository.findAll();

        // Menggunakan Comparator untuk membandingkan namaRole
        Comparator<Role> comparator = Comparator.comparing(Role::getNamaRole);

        // Menyortir list berdasarkan namaRole
        roles.sort(comparator);

        return roles;
    }

    public boolean updateRole(Role role) {
        role.setStatusRole("Aktif");
        Role result = roleRepository.save(role);
        boolean isSuccess = true;

        if (result == null) {
            isSuccess = false;
        }

        return isSuccess;
    }

    public void deleteRole(UUID id) {
        Role role = roleRepository.getRoleByIdRole(id);
        role.setStatusRole("Tidak Aktif");

        roleRepository.save(role);
    }
}
