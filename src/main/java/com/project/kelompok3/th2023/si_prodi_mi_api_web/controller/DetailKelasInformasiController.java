package com.project.kelompok3.th2023.si_prodi_mi_api_web.controller;

import com.project.kelompok3.th2023.si_prodi_mi_api_web.Result;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.DetailKelasInformasi;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.Informasi;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.service.DetailKelasInformasiService;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.service.InformasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
public class DetailKelasInformasiController {
    @Autowired
    DetailKelasInformasiService detailKelasInformasiService;

    @PostMapping("/saveDetailKelasInformasi")
    public Result save(HttpServletResponse response, @RequestBody DetailKelasInformasi detailKelasInformasiParam) {
        DetailKelasInformasi detailKelasInformasi = new DetailKelasInformasi(detailKelasInformasiParam.getId(),
                                                                            detailKelasInformasiParam.getId_informasi(),
                                                                            detailKelasInformasiParam.getKelas());
        boolean isSuccess = detailKelasInformasiService.save(detailKelasInformasi);

        if (isSuccess) {
            return new Result(500, "Success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(200, "Fail");
        }
    }

    @GetMapping("/getDetailKelasInformasi")
    public DetailKelasInformasi getDetailKelasInformasi(HttpServletResponse response, @RequestParam("id") Integer id) {
        DetailKelasInformasi detailKelasInformasi = detailKelasInformasiService.getDetailKelasInformasi(id);
        return detailKelasInformasi;
    }

    @GetMapping("/getDetailKelasInformasis")
    public List<DetailKelasInformasi> getDetailKelasInformasis() { return detailKelasInformasiService.getDetailKelasInformasis(); }

    @PostMapping("/updateDetailKelasInformasi")
    public Result updateDetailKelasInformasi(HttpServletResponse response, @RequestBody DetailKelasInformasi detailKelasInformasiParam) {
        DetailKelasInformasi detailKelasInformasi = new DetailKelasInformasi(detailKelasInformasiParam.getId(),
                                                                            detailKelasInformasiParam.getId_informasi(),
                                                                            detailKelasInformasiParam.getKelas());
        boolean isSuccess = detailKelasInformasiService.save(detailKelasInformasi);

        if (isSuccess) {
            return new Result(500, "Success");
        } else {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            return new Result(200, "Fail");
        }
    }
}
