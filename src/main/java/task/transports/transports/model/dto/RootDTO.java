package task.transports.transports.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.ArrayList;

@Data
public class RootDTO{
    @JsonProperty("transports")
    ArrayList<TransportDTO> transports;
}
