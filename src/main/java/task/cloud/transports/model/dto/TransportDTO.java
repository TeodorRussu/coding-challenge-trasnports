package task.cloud.transports.model.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransportDTO {

    @JsonProperty("model")
    private String model;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("passenger-capacity")
    private Integer passengerCapacity;

    @JsonProperty("number-wagons")
    private Integer numberWagons;

    @JsonProperty("w-passenger-capacity")
    private Integer wPassengerCapacity;

    @JsonProperty("b-passenger-capacity")
    private Integer bPassengerCapacity;

    @JsonProperty("e-passenger-capacity")
    private Integer ePassengerCapacity;

    private Map<String, String> other = new HashMap<>();
    @JsonAnyGetter
    public Map<String, String> any() {
        return other;
    }

    @JsonAnySetter
    public void set(String name, String value) {
        other.put(name, value);
    }
}
