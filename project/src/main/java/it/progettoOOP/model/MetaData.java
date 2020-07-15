/**
 * @author Mele Alessandro & Verdecchia Matteo
 * OOP project exam, A.A. 2019/2020
 *
 */

package it.progettoOOP.model;

import java.util.ArrayList;

public class MetaData {
	/*
	 * name of the attribute
	 */
	private String name;
	/*
	 * description of the attribute
	 */
	private String description;
	/*
	 * type value of the attribute
	 */
	private String type;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * Basic constructor
	 */
	public MetaData() {
		name = "";
		description = "";
		type = "";
	}

	/**
	 * Constructor using fields
	 */
	public MetaData(String name, String description, String type) {
		this.name = name;
		this.description = description;
		this.type = type;
	}

	/**
	 * @return ArrayList<Metadata> that contain's information about metadata of a
	 *         facebookPost
	 */
	public static ArrayList<MetaData> getMetaData() {
		ArrayList<MetaData> postMetaData = new ArrayList<MetaData>();
		postMetaData.add(new MetaData("id", "Identifier of the post", "String"));
		postMetaData.add(new MetaData("message", "Message(or Description) of the post", "String"));
		postMetaData.add(new MetaData("numShares", "Number of Shares about the post", "Integer"));
		postMetaData.add(new MetaData("numReactions", "Number of Reactions about the post", "Integer"));
		return postMetaData;
	}

}