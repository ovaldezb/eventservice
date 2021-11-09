package mx.com.grupoarpa.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Artist {

	@Id
	private String id;
	private String name;
	private String description;
	private String category;
}
