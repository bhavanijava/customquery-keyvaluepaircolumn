package com.web;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class College {

	@Id
	private int id;
	private String name;
	@Lob
	@Column(name = "properties")
	@Convert(converter = HashMapConverter.class)
	public Map<String, Object> properties  = new HashMap<>();
}
