package task.transports.transports.service.processor;

import org.springframework.stereotype.Component;
import task.transports.transports.model.dataobject.Transport;
import task.transports.transports.model.dataobject.TransportSummary;

import java.util.List;

@Component
public interface DataProcessor {

    TransportSummary createSummary(List<Transport> transports);
}
