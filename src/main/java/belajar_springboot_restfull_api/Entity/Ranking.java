package belajar_springboot_restfull_api.Entity;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ranking")
public class Ranking {
    @Id
    @GeneratedValue
    private int id;

    @Column(name = "ranking")
    private String ranking;

    @Column(name = "semester")
    private String semester;


}
