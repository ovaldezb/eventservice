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
	private String placeEvent;
	private String nameEvent;
	@JsonFormat
    (shape = JsonFormat.Shape.STRING, pattern = "MM-dd-yyyy HH:mm:ss")
	private Date dateEvent;
	@DBRef
	private List<Artist> artistas;
	private String typeEvent;
}
