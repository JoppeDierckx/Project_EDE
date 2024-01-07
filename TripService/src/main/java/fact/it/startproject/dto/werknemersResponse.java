package fact.it.startproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class werknemersResponse {
    private String id;
    private String name;
    private String phoneNumber;
    private String currentLocation;
}
