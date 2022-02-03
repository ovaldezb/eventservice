package mx.com.grupoarpa.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class FairGround {

	@Id
	private String id;
	private String fairgroundName;
	private String sequence;
	private int fairgroundZipCode;
	private double fairgroundLatitude;
	private double fairgroundLongitud;
	private String fairgroundStreet;
	private String fairgroundExternalNumber;
	private String fairgroundInternalNumber;
}
