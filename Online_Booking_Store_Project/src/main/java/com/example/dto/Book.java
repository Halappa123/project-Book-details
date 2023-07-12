package com.example.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@Entity
@Table(name="Books")
public class Book {
	
	@Id
	@GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
	@ApiModelProperty(hidden = true,notes = "unique id",position = 1)
	@Column(name="Book_Id",nullable = true,length = 50)
	private String id;
	
	@Column(name="Book_Title",nullable = false,length = 50)
	@ApiModelProperty(name="Title Of The Book",position = 2)
	private String title;
	
	@Column(name="Book_Author",nullable = false,length = 50)
	@ApiModelProperty(name="Title Of The Book",position = 3)
    private  String author;
	
	@Column(name="Book_Description",nullable = false,length = 100)
	@ApiModelProperty(name="Title Of The Book",position = 4)
    private String description;
	
	@Column(name="Book_Price",nullable = false,length = 50)
	@ApiModelProperty(name="Title Of The Book",position = 5)
    private int price;
	
	@Column(name="Book_Quentity",nullable =false,length = 50)
	@ApiModelProperty(name="Title Of The Book",position = 6)
    private String quentity;
    
	

}
