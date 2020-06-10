package task.transports.transports.output;

import org.springframework.stereotype.Component;
import task.transports.transports.model.dataobject.TransportSummary;

import java.util.Map;

@Component
public interface OutputService {
    public void processOutput(Map<String, TransportSummary> filesSummary);

    void exportOutput(String fileName, TransportSummary summary);
}
