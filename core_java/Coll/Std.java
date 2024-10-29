package com.learn.corejava.Coll;

import java.util.Objects;

public class Std {
	private Integer id;
	private String name;
	private String clazz;
	
	public Std() {
		super();
	}
	public Std(Integer id, String name, String clazz) {
		super();
		this.id = id;
		this.name = name;
		this.clazz = clazz;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getClazz() {
		return clazz;
	}
	public void setClazz(String clazz) {
		this.clazz = clazz;
	}
	@Override
	public int hashCode() {
		return Objects.hash(clazz, id, name);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Std other = (Std) obj;
		return Objects.equals(clazz, other.clazz) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}
	@Override
	public String toString() {
		return "Std [id=" + id + ", name=" + name + ", clazz=" + clazz + "]";
	}
	
}
