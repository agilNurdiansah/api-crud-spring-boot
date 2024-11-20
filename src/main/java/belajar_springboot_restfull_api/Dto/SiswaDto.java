package belajar_springboot_restfull_api.Dto;


import belajar_springboot_restfull_api.Entity.Siswa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class SiswaDto extends Siswa {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RequestCreateSiswa{
        private int id;
        private String nis;
        private String namaSiswa;
        private String kelas;
        private String jenisKelamin;


    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseDeleteSiswa{
        private String message;
        private int status;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseCreateSiswa {

        private Siswa data;
        private String message;
        private int status;

    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseUpdateSiswa {

        private Siswa data;
        private String message;
        private int status;

    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseSiswa {

        private List<Siswa> data;
        private String message;
        private int status;

    }
}
