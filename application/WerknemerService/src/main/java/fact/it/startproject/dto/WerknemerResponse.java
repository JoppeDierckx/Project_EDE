package fact.it.startproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WerknemerResponse {
    private String name;
    private String phoneNumber;
    private boolean isAvailable;
}
