package task.transports.transports.service.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import task.transports.transports.model.dataobject.Transport;
import task.transports.transports.model.dataobject.TransportSummary;
import task.transports.transports.service.mapper.TransportMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DataProcessorImpl implements DataProcessor {

    @Autowired
    TransportMapper transportMapper;

    @Override
    public Map<String, TransportSummary> createSummary(Map<String, List<Transport>> dataObjects) {

        return dataObjects.entrySet()
                .stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> transportsToSummary(entry.getValue())));
    }

    public TransportSummary transportsToSummary(List<Transport> transports) {

        Map<String, Integer> collect = transports.stream()
                .collect(Collectors.toMap(transport -> transport.getClass().getSimpleName(), transport ->
                        transport.getPassengerCapacity(), Integer::sum
                ));
        return transportMapper.mapTransportToTransportSummary(collect);

    }

}
