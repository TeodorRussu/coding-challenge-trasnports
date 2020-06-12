package task.cloud.transports.model.dataobject;

import lombok.Builder;
import lombok.Value;

@Value
public class Train extends Transport {

    private Integer numberWagons;
    private Integer wPassengerCapacity;

    @Builder
    public Train(String model, int numberWagons, int wPassengerCapacity) {
        super(model);
        this.numberWagons = numberWagons;
        this.wPassengerCapacity = wPassengerCapacity;
    }

    @Override
    public Integer getPassengerCapacity() {
        return numberWagons * wPassengerCapacity;
    }
}
