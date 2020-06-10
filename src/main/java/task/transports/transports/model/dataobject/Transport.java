package task.transports.transports.model.dataobject;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public abstract class Transport {
    protected String model;

    public abstract Integer getPassengerCapacity();
}
