package task.cloud.transports.service.processor;

import org.springframework.stereotype.Component;
import task.cloud.transports.model.dataobject.Transport;
import task.cloud.transports.model.dataobject.TransportSummary;

import java.util.List;

@Component
public interface DataProcessor {

    TransportSummary createSummary(List<Transport> transports);
}
