package mx.com.grupoarpa.entity;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Document
@Data
public class Event {

	@Id
	private String id;
	@DBRef
	private FairGround fairGround;
	private String nameEvent;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateStartEvent;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
	private Date dateEndEvent;
	@DBRef
	private List<Artist> artistas;
	@DBRef
	private Category category;
	//@DBRef
	//private Image eventImage;
	private double availability;
	private int courtesyAmount;
	private Sections[] ticketSections;
	private String briefDescription;
	private double percentageComission;
	private Schedule[] eventSchedule;
	
}
