package clinic.backend.data;

import clinic.backend.dao.DoctorDAO;
import clinic.backend.dto.DoctorDTO;
import clinic.backend.dto.DoctorDTOBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.mockito.Mockito.*;


@RunWith(MockitoJUnitRunner.class)
public class DoctorsFromFileProviderTest {

    @InjectMocks
    private DoctorsFromFileProvider underTest;
    @Mock
    private DoctorDAO doctorDAO;
    @Captor
    private ArgumentCaptor<DoctorDTO> doctorDTOArgumentCaptor;

    private List<DoctorDTO> givenDoctors = Arrays.asList(
            new DoctorDTOBuilder()
                    .withId(1L)
                    .withName("Test User1")
                    .withSurname("Test Surname1")
                    .withTitle("Test Title1")
                    .withScheduleOfDay(DayOfWeek.MONDAY, 12,30, 15,45)
                    .withScheduleOfDay(DayOfWeek.THURSDAY, 10,00, 16,00)
                    .createDoctorDTO(),
            new DoctorDTOBuilder()
                    .withId(2L)
                    .withName("Test User2")
                    .withSurname("Test Surname2")
                    .withTitle("Test Title2")
                    .createDoctorDTO()
    );

    @Test
    public void provide() throws Exception {
        underTest.provide();
        verify(doctorDAO, times(2)).add(doctorDTOArgumentCaptor.capture());
        List<DoctorDTO> loadedDoctos = doctorDTOArgumentCaptor.getAllValues();
        assertThat(loadedDoctos).usingFieldByFieldElementComparator().containsExactlyElementsOf(givenDoctors);
    }
}