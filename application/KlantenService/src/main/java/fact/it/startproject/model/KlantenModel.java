package fact.it.startproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "KlantModel")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KlantenModel {
    @Id
    private long id;
    private String name;
    private String phoneNumber;
    private String currentLocation;
}
