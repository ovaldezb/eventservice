package mx.com.grupoarpa;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import mx.com.grupoarpa.entity.Artist;
import mx.com.grupoarpa.repository.ArtistRepository;

@SpringBootTest
public class ArtistUnitTest {

	@MockBean
	ArtistRepository artistRepo;
	
	@Test
	public void getAllArtistTest() throws Exception{
		Artist artisOne = new Artist();
		artisOne.setName("Amanda Miguel");
		artisOne.setDescription("LA Seniora");
		artisOne.setCategory("Bolero");
		Artist artisTwo = new Artist();
		artisTwo.setName("Luis Miguel");
		artisTwo.setDescription("El Senor");
		artisTwo.setCategory("Bolero");
		when(artistRepo.findAll()).thenReturn(Arrays.asList(artisOne,artisTwo));
		assertThat(artistRepo.findAll().size()).isEqualTo(2);
	}
}
