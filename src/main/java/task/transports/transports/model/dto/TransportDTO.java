package task.transports.transports.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TransportDTO {

    @JsonProperty("model")
    private String model;

    @JsonProperty("manufacturer")
    private String manufacturer;

    @JsonProperty("passenger-capacity")
    private String passengerCapacity;

    @JsonProperty("number-wagons")
    private int numberWagons;

    @JsonProperty("w-passenger-capacity")
    private int wPassengerCapacity;

    @JsonProperty("b-passenger-capacity")
    private int bPassengerCapacity;

    @JsonProperty("e-passenger-capacity")
    private int ePassengerCapacity;

}
