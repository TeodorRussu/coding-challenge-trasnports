package task.transports.transports.model.dataobject;

import lombok.Builder;
import lombok.Value;

@Value
public class Plane extends Transport {

    private int bPassengerCapacity;
    private int ePassengerCapacity;

    @Builder
    public Plane(String model, int bPassengerCapacity, int ePassengerCapacity) {
        super(model);
        this.bPassengerCapacity = bPassengerCapacity;
        this.ePassengerCapacity = ePassengerCapacity;
    }

    @Override
    public Integer getPassengerCapacity() {
        return bPassengerCapacity + ePassengerCapacity;
    }
}
