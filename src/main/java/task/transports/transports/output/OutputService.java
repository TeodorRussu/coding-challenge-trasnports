package task.transports.transports.output;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public interface OutputService {
    public void processOutput(List<File> files);
}
