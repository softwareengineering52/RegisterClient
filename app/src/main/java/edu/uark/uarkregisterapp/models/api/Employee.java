package edu.uark.uarkregisterapp.models.api;

import org.apache.commons.lang3.StringUtils;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import edu.uark.uarkregisterapp.models.api.fields.EmployeeFieldName;
import edu.uark.uarkregisterapp.models.api.interfaces.ConvertToJsonInterface;
import edu.uark.uarkregisterapp.models.api.interfaces.LoadFromJsonInterface;
import edu.uark.uarkregisterapp.models.transition.EmployeeTransition;

public class Employee implements ConvertToJsonInterface, LoadFromJsonInterface<Employee> {

    private UUID id;
    public UUID getId() {
        return this.id;
    }
    public Employee setId(UUID id) {
        this.id = id;
        return this;
    }

    private String lookupCode;
    public String getLookupCode() {
        return this.lookupCode;
    }
    public Employee setLookupCode(String lookupCode) {
        this.lookupCode = lookupCode;
        return this;
    }

    private int count;
    public int getCount() {
        return this.count;
    }
    public Employee setCount(int count) {
        this.count = count;
        return this;
    }

    private String firstName;
    public String getFirstName() {
        return this.firstName;
    }
    public Employee setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    private String lastName;
    public String getLatName() {
        return this.lastName;
    }
    public Employee setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    private boolean activeStatus;
    public boolean activeStatus() {
        return this.activeStatus;
    }
    public Employee setActiveStatus(boolean activeStatus) {
        this.activeStatus = activeStatus;
        return this;
    }

    private String rank;
    public String getRank() {
        return this.rank;
    }
    public Employee setRank(String rank) {
        this.rank = rank;
        return this;
    }

    private int managerID;
    public int getManagerID(){
        return this.managerID;
    }
    public Employee setManagerID(int managerID) {
        this.managerID = managerID;
        return this;
    }

    private String password;
    public String getPassword() {
        return this.password;
    }
    public Employee setPassword(String password){
        this.password = password;
        return this;
    }

    private Date createdOn;
    public Date getCreatedOn() {
        return this.createdOn;
    }
    public Employee setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    @Override
    public Employee loadFromJson(JSONObject rawJsonObject) {
        String value = rawJsonObject.optString(EmployeeFieldName.ID.getFieldName());
        if (!StringUtils.isBlank(value)) {
            this.id = UUID.fromString(value);
        }

        this.lookupCode = rawJsonObject.optString(EmployeeFieldName.LOOKUP_CODE.getFieldName());
        this.count = rawJsonObject.optInt(EmployeeFieldName.COUNT.getFieldName());

        value = rawJsonObject.optString(EmployeeFieldName.CREATED_ON.getFieldName());
        if (!StringUtils.isBlank(value)) {
            try {
                this.createdOn = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US).parse(value);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        return this;
    }

    @Override
    public JSONObject convertToJson() {
        JSONObject jsonObject = new JSONObject();

        try {
            jsonObject.put(EmployeeFieldName.ID.getFieldName(), this.id.toString());
            jsonObject.put(EmployeeFieldName.LOOKUP_CODE.getFieldName(), this.lookupCode);
            jsonObject.put(EmployeeFieldName.COUNT.getFieldName(), this.count);
            jsonObject.put(EmployeeFieldName.CREATED_ON.getFieldName(), (new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS", Locale.US)).format(this.createdOn));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return jsonObject;
    }

    public Employee() {
        this.count = -1;
        this.lookupCode = "";
        this.firstName = "";
        this.lastName = "";
        this.activeStatus = false;
        this.rank = "cashier";
        this.managerID = -1;
        this.password = "";
        this.id = new UUID(0, 0);
        this.createdOn = new Date();
    }

    public Employee(EmployeeTransition employeeTransition) {
        this.id = employeeTransition.getId();
        this.count = employeeTransition.getCount();
        this.firstName = employeeTransition.getFirstName();
        this.lastName = employeeTransition.getLastName();
        this.activeStatus = employeeTransition.getActiveStatus();
        this.rank = employeeTransition.getRank();
        this.managerID = employeeTransition.getManagerID();
        this.password = employeeTransition.getPassword();
        this.createdOn = employeeTransition.getCreatedOn();
        this.lookupCode = employeeTransition.getLookupCode();
    }
}
