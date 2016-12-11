package clinic.backend;

import clinic.backend.data.DoctorsFromFileProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class ServerInitializer implements ApplicationRunner {

    private final DoctorsFromFileProvider doctorsFromFileProvider;

    @Autowired
    public ServerInitializer(DoctorsFromFileProvider doctorsFromFileProvider) {
        this.doctorsFromFileProvider = doctorsFromFileProvider;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        doctorsFromFileProvider.provide();
    }
}