package com.parag.test.model03;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeSet;

import org.springframework.stereotype.Component;

@Component("myCollection")
public class CollectionClass {
	String[] stringArray;
	ArrayList<String> arrayList;
	List list;
	Properties properties;
	HashMap<String, Object> hashMap;
	Map<String, Object> map;
	Set<?> set;
	TreeSet<String> treeSet;

	public String[] getStringArray() {
		return stringArray;
	}

	public void setStringArray(String[] stringArray) {
		this.stringArray = stringArray;
	}

	public ArrayList<String> getArrayList() {
		return arrayList;
	}

	public void setArrayList(ArrayList<String> arrayList) {
		this.arrayList = arrayList;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	public HashMap<String, Object> getHashMap() {
		return hashMap;
	}

	public void setHashMap(HashMap<String, Object> hashMap) {
		this.hashMap = hashMap;
	}

	public Map<String, Object> getMap() {
		return map;
	}

	public void setMap(Map<String, Object> map) {
		this.map = map;
	}

	public Set<?> getSet() {
		return set;
	}

	public void setSet(Set<?> set) {
		this.set = set;
	}

	public TreeSet<String> getTreeSet() {
		return treeSet;
	}

	public void setTreeSet(TreeSet<String> treeSet) {
		this.treeSet = treeSet;
	}

	@Override
	public String toString() {
		String stringArrayStr = "";
		int idx = 0;

		for (String val : stringArray) {
			stringArrayStr += (idx == 0 ? " " : ", ") + "[" + idx++ + "]: "+val;
		}

		return "CollectionClass [stringArray=" + stringArrayStr + ", arrayList=" + arrayList + ", list=" + list
				+ ", properties=" + properties + ", hashMap=" + hashMap + ", map=" + map + ", set=" + set + ", treeSet="
				+ treeSet + "]";
	}

}
