package task.transports.transports.output;

import org.springframework.stereotype.Component;
import task.transports.transports.model.dataobject.TransportSummary;


@Component
public interface OutputService {

    void processOutput(String filename, TransportSummary filesSummary);

}
