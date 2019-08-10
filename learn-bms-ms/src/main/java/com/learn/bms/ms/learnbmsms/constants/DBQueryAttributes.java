package com.learn.bms.ms.learnbmsms.constants;

public enum DBQueryAttributes {

    ID("id"), CRATED_BY("createdBy"), UPDATED_BY("updatedBy"),USER_NAME("name"),
    USER_CONTACT_NUMBER("mob"), UPDATED_AT("updatedAt");

    private String queryParams;

    DBQueryAttributes(String queryParams){
        this.queryParams = queryParams;
    }

    public String getParam() {
        return queryParams;
    }
}
