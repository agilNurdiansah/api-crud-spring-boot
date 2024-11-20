package belajar_springboot_restfull_api.Dto;


import belajar_springboot_restfull_api.Entity.Nilai;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class NilaiDTO extends Nilai {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RequestCreateNilai{

        private int id;
        private String semester;
        private String nilai;
        private String kodeNilai;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseDeleteNilai{

        private String message;
        private int status;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseCreateNilai{

        private Nilai data;
        private String message;
        private int status;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseUpdateNilai{

        private Nilai data;
        private String message;
        private int status;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseNilai{

        private List<Nilai> data;
        private String message;
        private int status;
    }
}
