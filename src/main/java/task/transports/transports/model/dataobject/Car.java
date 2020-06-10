package task.transports.transports.model.dataobject;

import lombok.Data;

@Data
public class Car extends Transport{
    private String manufacturer;
    private String passengerCapacity;
}
