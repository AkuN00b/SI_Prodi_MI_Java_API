package com.project.kelompok3.th2023.si_prodi_mi_api_web.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RestController
public class FileUploadController {

    @PostMapping("/uploadDocument")
    public String handleFileUploadDocument(@RequestParam("file") MultipartFile file,
                                           @RequestParam("timeStamp") String timeStamp) {
        if (!file.isEmpty()) {
            try {
                // Mendapatkan path absolut dari direktori saat ini
                Path currentDirectory = Paths.get("").toAbsolutePath();
                String dir = currentDirectory.toString() + "/src/main/resources/static/fileApp/document/";

                // Menggabungkan direktori tujuan dengan nama file yang unik
                String uniqueFileName = timeStamp + " - " + file.getOriginalFilename();
                String filePath = dir + uniqueFileName;

                File destination = new File(filePath);
                file.transferTo(destination);

                return "File uploaded document successfully!";
            } catch (IOException e) {
                e.printStackTrace();
                return "Failed to upload document file!";
            }
        } else {
            return "No file selected!";
        }
    }

    @PostMapping("/uploadImage")
    public String handleFileUploadImage(@RequestParam("file") MultipartFile file,
                                        @RequestParam("timeStamp") String timeStamp) {
        if (!file.isEmpty()) {
            try {
                // Mendapatkan path absolut dari direktori saat ini
                Path currentDirectory = Paths.get("").toAbsolutePath();
                String dir = currentDirectory.toString() + "/src/main/resources/static/fileApp/image/";

                // Menggabungkan direktori tujuan dengan nama file yang unik
                String uniqueFileName = timeStamp + " - " + file.getOriginalFilename();
                String filePath = dir + uniqueFileName;

                File destination = new File(filePath);
                file.transferTo(destination);

                return "File uploaded img successfully!";
            } catch (IOException e) {
                e.printStackTrace();
                return "Failed to upload img file!";
            }
        } else {
            return "No file selected!";
        }
    }

    @PostMapping("/deleteDocument")
    public String deleteDocument(@RequestParam("fileName") String fileName) {
        // Mendapatkan path absolut dari direktori saat ini
        Path currentDirectory = Paths.get("").toAbsolutePath();
        String dir = currentDirectory.toString() + "/src/main/resources/static/fileApp/document/";

        File file = new File(dir + File.separator + fileName);
        if (file.exists()) {
            if (file.delete()) {
                return "File dokumen berhasil dihapus.";
            } else {
                return "Gagal menghapus file dokumen.";
            }
        } else {
            return "File dokumen tidak ditemukan.";
        }
    }

    @PostMapping("/deleteImage")
    public String deleteImage(@RequestParam("fileName") String fileName) {
        // Mendapatkan path absolut dari direktori saat ini
        Path currentDirectory = Paths.get("").toAbsolutePath();
        String dir = currentDirectory.toString() + "/src/main/resources/static/fileApp/image/";

        File file = new File(dir + File.separator + fileName);
        if (file.exists()) {
            if (file.delete()) {
                return "File img berhasil dihapus.";
            } else {
                return "Gagal menghapus file img.";
            }
        } else {
            return "File img tidak ditemukan.";
        }
    }
}
