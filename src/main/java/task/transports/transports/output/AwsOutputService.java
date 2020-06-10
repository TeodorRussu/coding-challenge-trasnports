package task.transports.transports.output;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import task.transports.transports.model.dataobject.TransportSummary;

import java.util.Map;

@Component
@Profile("aws")
public class AwsOutputService implements OutputService {

    @Override
    public void processOutput(Map<String, TransportSummary> files) {
        //to do
    }

    @Override
    public void exportOutput(String fileName, TransportSummary summary) {
        //to do
    }
}
