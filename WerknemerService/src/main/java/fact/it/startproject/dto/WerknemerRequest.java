package fact.it.startproject.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WerknemerRequest {
    private String name;
    private boolean isAvailable;
    // Add other fields if needed
}
