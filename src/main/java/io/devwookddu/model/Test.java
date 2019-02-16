package io.devwookddu.model;

import java.sql.Timestamp;

public class Test {
	private Integer id;
	private String name;
	private Timestamp created_at;
	private Timestamp updated_at;
	
	public Integer getId() {
		return id;
	}
	public Test setId(Integer id) {
		this.id = id;
		return this;
	}
	public String getName() {
		return name;
	}
	public Test setName(String name) {
		this.name = name;
		return this;
	}
	public Timestamp getCreated_at() {
		return created_at;
	}
	public Test setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
		return this;
	}
	public Timestamp getUpdated_at() {
		return updated_at;
	}
	public Test setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
		return this;
	}
	@Override
	public String toString() {
		return "Test [id=" + id + ", name=" + name + ", created_at=" + created_at + ", updated_at=" + updated_at + "]";
	}
	
}
