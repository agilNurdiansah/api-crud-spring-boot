package belajar_springboot_restfull_api.Dto;

import belajar_springboot_restfull_api.Entity.Ranking;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class RankingDTO extends Ranking {

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class RequestCreateRanking{

        private int id;
        private String ranking;
        private String semester;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseDeleteRanking{

        private String message;
        private int status;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseCreateRanking{

        private Ranking data;
        private String message;
        private int status;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseUpdateRanking{

        private Ranking data;
        private String message;
        private int status;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ResponseRanking{

        private List<Ranking> data;
        private String message;
        private int status;
    }
}
