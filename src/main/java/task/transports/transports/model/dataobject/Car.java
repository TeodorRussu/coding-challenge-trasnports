package task.transports.transports.model.dataobject;

import lombok.Builder;
import lombok.Value;

@Value
public class Car extends Transport {
    private String manufacturer;
    private int passengerCapacity;

    @Builder
    public Car(String model, String manufacturer, int passengerCapacity) {
        super(model);
        this.manufacturer = manufacturer;
        this.passengerCapacity = passengerCapacity;
    }

    @Override
    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }
}
