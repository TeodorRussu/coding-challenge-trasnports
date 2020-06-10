package task.transports.transports.model.dataobject;

import lombok.Data;

@Data
public class Plane extends Transport{

    private int bPassengerCapacity;
    private int ePassengerCapacity;

}
