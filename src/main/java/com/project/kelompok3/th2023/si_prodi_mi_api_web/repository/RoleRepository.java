package com.project.kelompok3.th2023.si_prodi_mi_api_web.repository;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface RoleRepository extends CrudRepository<Role, UUID> {
    @Query("SELECT r FROM Role r WHERE r.idRole =:id")
    public Role getRoleByIdRole(@Param("id") UUID id);

    List<Role> findAll();
}
