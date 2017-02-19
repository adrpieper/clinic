package clinic.backend.data;

import clinic.backend.dao.DoctorDAO;
import clinic.backend.dto.DoctorDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
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

    private List<DoctorDTO> givenDoctors = Arrays.asList(new DoctorDTO(1L,"Test User1", "Test Surname1", "Test Title1"),new DoctorDTO(2L,"Test User2", "Test Surname2", "Test Title2"));

    @Test
    public void provide() throws Exception {
        underTest.provide();
        verify(doctorDAO, times(2)).save(doctorDTOArgumentCaptor.capture());
        List<DoctorDTO> loadedDoctos = doctorDTOArgumentCaptor.getAllValues();
        assertThat(loadedDoctos).usingFieldByFieldElementComparator().containsExactlyElementsOf(givenDoctors);
    }
}