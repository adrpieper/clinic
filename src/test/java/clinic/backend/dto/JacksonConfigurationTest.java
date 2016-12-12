package clinic.backend.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.IOException;
import java.time.LocalTime;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class JacksonConfigurationTest {

    @InjectMocks
    private JacksonConfiguration underTest;

    @Test
    public void testSerialization() throws IOException {
        String string = underTest.objectMapper().writeValueAsString(new ClassWithLocalTime());
        assertThat(string).isEqualTo("{\"time\":\"12:32\"}");
    }

    @Test
    public void testDeserialization() throws IOException {
        ClassWithLocalTime result = underTest.objectMapper().readValue("{\"time\":\"12:32\"}",ClassWithLocalTime.class);
        assertThat(result).isEqualToComparingFieldByField(new ClassWithLocalTime());
    }

    private static class ClassWithLocalTime {
        private LocalTime time = LocalTime.of(12,32);

        public void setTime(LocalTime time) {
            this.time = time;
        }

        public LocalTime getTime() {
            return time;
        }
    }
}