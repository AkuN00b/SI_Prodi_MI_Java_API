package com.project.kelompok3.th2023.si_prodi_mi_api_web.controller;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.Result;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Role;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class RoleController {
    @Autowired
    RoleService roleService;

    @GetMapping("/saveRole")
    public ResponseEntity<Void> save(HttpServletResponse response,
                                     @RequestParam(name = "namaRole") String namaRole) {

        Role role = new Role (namaRole, "0");
        roleService.save(role);

        return ResponseEntity.status(HttpStatus.FOUND).
        location(URI.create("http://localhost:8080/admin/role.html")).build();
    }

    @GetMapping("/getRole")
    public Role getRole(HttpServletResponse response, @RequestParam("idRole") UUID idRole) {
        Role role = roleService.getRole(idRole);
        return role;
    }

    @GetMapping("/getRoles")
    public List<Role> getRoles(HttpServletResponse response) {
        List<Role> roles = roleService.getRoles();
        return roles;
    }

    @GetMapping("/getRolesAktif")
    public List<Role> getRolesAktif() {
        List<Role> roles = roleService.getRoles();

        // Filter roles yang hanya memiliki statusRole aktif
        List<Role> activeRoles = roles.stream()
                .filter(role -> role.getStatusRole().equals("Aktif"))
                .collect(Collectors.toList());

        return activeRoles;
    }

    @GetMapping("/updateRole")
    public ResponseEntity<Void> update(HttpServletResponse response,
                                       @RequestParam(name = "idRole") UUID idRole,
                                       @RequestParam(name = "namaRole") String namaRole) {

        Role role = new Role (idRole, namaRole, "0");
        roleService.updateRole(role);

        return ResponseEntity.status(HttpStatus.FOUND).
                location(URI.create("http://localhost:8080/admin/role.html")).build();
    }

    @DeleteMapping("/deleteRole")
    public ResponseEntity<String> deleteById(@RequestParam("idRole") UUID idRole) {
        roleService.deleteRole(idRole);
        return ResponseEntity.ok("Role with UUID: " + idRole + ". Deleted Successfully");
    }
}
