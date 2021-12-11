package mx.com.grupoarpa.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document
public class Category {
	
	@Id
	private String id;
	private String categoryName;
}
