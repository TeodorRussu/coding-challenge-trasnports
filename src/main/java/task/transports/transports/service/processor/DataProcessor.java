package task.transports.transports.service.processor;

import org.springframework.stereotype.Component;
import task.transports.transports.model.dataobject.Transport;
import task.transports.transports.model.dataobject.TransportSummary;

import java.util.List;
import java.util.Map;

@Component
public interface DataProcessor {
    public Map<String, TransportSummary> createSummary(Map<String, List<Transport>> dataObjects);


}
