package mx.com.grupoarpa;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

import lombok.extern.slf4j.Slf4j;
import mx.com.grupoarpa.entity.Event;

@Slf4j
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EventsApplicationTests {

	@Autowired
	private TestRestTemplate restTemplate;
	
	

	@ParameterizedTest
	@CsvSource({"61831dd572c6cf709af27b2e,200 OK",
				"61831dd572c6cf709af27b2x,404 NOT_FOUND"
	})
	public void testRetrieveEvent(String idEvento, String expected) throws Exception{
		ResponseEntity<Event> response = restTemplate.getForEntity("/api/event/"+idEvento, Event.class);
		
		//assertThat(response.getStatusCode()).isEqualTo(org.springframework.http.HttpStatus.OK);
		assertThat(response.getStatusCode().toString()).isEqualTo(expected);
	}
	
	//@Test
	public void getListEvents() throws Exception{
		@SuppressWarnings("rawtypes")
		ResponseEntity<ArrayList> listEvents = restTemplate.getForEntity("/api/event", ArrayList.class);
		
			log.info(listEvents.getBody().toString());
		assertThat(listEvents.getBody().size()).isGreaterThan(0);
	}
	
//	@Test
//	public void AddNewEvent() throws Exception{
//		HttpHeaders headers = new HttpHeaders();
//		headers.setContentType(MediaType.APPLICATION_JSON);
//		
//		Event event = new Event();
//		event.setDateEvent(new Date());
//		event.setNameEvent("Concurso Ven a Cantar");
//		event.setPlaceEvent("Sendero Toluca");
//		event.setTypeEvent("Infantil");
//		Artist a = new Artist();
//		a.setId("61831015d9059b6246687c0e");
//		List<Artist> listaArtistas = new ArrayList<Artist>();
//		listaArtistas.add(a);
//		event.setArtistas(listaArtistas);
//		HttpEntity<Event> requestEntity = new HttpEntity<>(event,headers);
//		ResponseEntity<Event> response = restTemplate.postForEntity("/api/event", requestEntity, Event.class);
//		
//		assertThat(response.getBody().getId()).isNotEmpty();
//	}
	
	
}
