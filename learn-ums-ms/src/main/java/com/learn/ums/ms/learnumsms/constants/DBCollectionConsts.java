package com.learn.ums.ms.learnumsms.constants;

public enum DBCollectionConsts {

	USER("USER");
	
	private String collection;

	DBCollectionConsts(String collection){
		this.collection = collection;
	}
	
	/**
	 * @return the collection
	 */
	public String getCollection() {
		return collection;
	}

}
