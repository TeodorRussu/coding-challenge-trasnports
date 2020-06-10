package task.transports.transports.output;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class FileSystemOutputService implements OutputService {
    @Override
    public void processOutput(List<File> files) {

    }
}
