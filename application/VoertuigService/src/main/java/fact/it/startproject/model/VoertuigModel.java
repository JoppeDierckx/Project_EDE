package fact.it.startproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "VoertuigModel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VoertuigModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String voertuigCode;
    private boolean isFree;
}
