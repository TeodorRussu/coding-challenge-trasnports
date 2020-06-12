package task.cloud.transports.service.processor;

import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task.cloud.transports.model.dataobject.Transport;
import task.cloud.transports.model.dataobject.TransportSummary;
import task.cloud.transports.service.mapper.TransportMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DataProcessorImpl implements DataProcessor {

    @Setter(onMethod = @__({@Autowired}))
    TransportMapper transportMapper;

    @Override
    public TransportSummary createSummary(List<Transport> transports) {

        Map<String, Integer> collect = transports.stream()
            .collect(Collectors.toMap(transport -> transport.getClass().getSimpleName(),
                                      Transport::getPassengerCapacity, Integer::sum
            ));
        return transportMapper.mapTransportToTransportSummary(collect);
    }

}
