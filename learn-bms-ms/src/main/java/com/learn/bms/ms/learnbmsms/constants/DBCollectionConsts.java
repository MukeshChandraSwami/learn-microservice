package com.learn.bms.ms.learnbmsms.constants;

public enum DBCollectionConsts {

	BOOK("BOOK");
	
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
