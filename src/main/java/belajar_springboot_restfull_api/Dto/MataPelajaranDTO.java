package belajar_springboot_restfull_api.Dto;

import belajar_springboot_restfull_api.Entity.MataPelajaran;
import belajar_springboot_restfull_api.Entity.Siswa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class MataPelajaranDTO extends MataPelajaran {


    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RequestCreateMataPelajaran{
        private int id;
        private String kodePelajaran;
        private String mataPelajaran;

    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseDeleteMataPelajaran{
        private String message;
        private int status;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseCreateMataPelajaran {

        private MataPelajaran data;
        private String message;
        private int status;

    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseUpdateMataPelajaran {

        private MataPelajaran data;
        private String message;
        private int status;

    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ResponseMataPelajaran {

        private List<MataPelajaran> data;
        private String message;
        private int status;

    }
}

