package edu.uark.uarkregisterapp.models.api.fields;

import edu.uark.uarkregisterapp.models.api.interfaces.FieldNameInterface;

public enum EmployeeFieldName implements FieldNameInterface {
    RECORDID("recordID"),
    LOOKUP_CODE("lookupCode"),
    EMPLOYEEID("employeeID"),
    FIRSTNAME("firstName"),
    LASTNAME("lastName"),
    ACTIVESTATUS("activeStatus"),
    RANK("rank"),
    MANAGERID("managerID"),
    PASSWORD("password"),
    API_REQUEST_STATUS("apiRequestStatus"),
    API_REQUEST_MESSAGE("apiRequestMessage"),
    CREATED_ON("createdOn");

    private String fieldName;
    public String getFieldName() {
        return this.fieldName;
    }

    EmployeeFieldName(String fieldName) {
        this.fieldName = fieldName;
    }
}