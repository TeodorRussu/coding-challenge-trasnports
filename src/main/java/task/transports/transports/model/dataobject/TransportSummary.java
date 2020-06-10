package task.transports.transports.model.dataobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"planes", "trains", "cars"})
public class TransportSummary {

    @JsonProperty("planes")
    private int planes;

    @JsonProperty("cars")
    private int cars;

    @JsonProperty("trains")
    private int trains;

}
