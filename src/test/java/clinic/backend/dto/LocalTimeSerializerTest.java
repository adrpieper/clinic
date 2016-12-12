package clinic.backend.dto;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.junit.Test;

import java.io.IOException;
import java.time.LocalTime;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class LocalTimeSerializerTest {

    @Test
    public void testSerialization() throws IOException {
        String string = new ObjectMapper().writeValueAsString(ClassWithLocalTime.withTime(12,32));
        assertThat(string).isEqualTo("{\"time\":\"12:32\"}");
    }
}