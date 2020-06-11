package task.transports.transports.model.dataobject;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"planes", "trains", "cars"})
public class TransportSummary {

    @JsonProperty("planes")
    private Integer planes;

    @JsonProperty("cars")
    private Integer cars;

    @JsonProperty("trains")
    private Integer trains;

}
