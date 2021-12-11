package mx.com.grupoarpa.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Organizer {

	@Id
	private String id;
	private String organizerName;
	private String organizerPhoneNumber;
	private String organizerFacebook;
	private String organizerTwitter;
	private String organizerAddress;
	private String contactName;
	private String organizerTaxId;
}
