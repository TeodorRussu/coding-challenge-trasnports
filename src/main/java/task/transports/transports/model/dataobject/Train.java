package task.transports.transports.model.dataobject;

import lombok.Data;

@Data
public class Train extends Transport{

    private int numberWagons;
    private int wPassengerCapacity;

}
