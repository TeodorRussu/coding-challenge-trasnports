package task.cloud.transports.output;

import org.springframework.stereotype.Component;
import task.cloud.transports.model.dataobject.TransportSummary;


@Component
public interface OutputService {

    void processOutput(String filename, TransportSummary filesSummary);

}
