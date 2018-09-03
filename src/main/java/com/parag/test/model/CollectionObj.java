package com.parag.test.model;

import java.awt.List;
import java.util.Map;
import java.util.Properties;

import org.springframework.stereotype.Component;

@Component("collection" )
public class CollectionObj {

	Map<String, Object> map;
	Properties prop;
	List list;
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	public Properties getProp() {
		return prop;
	}
	public void setProp(Properties prop) {
		this.prop = prop;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	@Override
	public String toString() {
		return "CollectionObj [map=" + map + ", prop=" + prop + ", list=" + list + "]";
	}
	
	
}
