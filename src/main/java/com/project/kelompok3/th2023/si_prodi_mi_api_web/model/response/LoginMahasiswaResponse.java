package com.project.kelompok3.th2023.si_prodi_mi_api_web.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.project.kelompok3.th2023.si_prodi_mi_api_web.model.MahasiswaAPI;

public class LoginMahasiswaResponse {
    @JsonProperty("data")
    private MahasiswaAPI mMahasiswa;

    @JsonProperty("message")
    private String message;

    @JsonProperty("status")
    private int status;

    public MahasiswaAPI getmMahasiswa() {
        return mMahasiswa;
    }

    public void setmMahasiswa(MahasiswaAPI mMahasiswa) {
        this.mMahasiswa = mMahasiswa;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "mMahasiswa=" + mMahasiswa +
                ", message='" + message + '\'' +
                ", status=" + status +
                '}';
    }
}
