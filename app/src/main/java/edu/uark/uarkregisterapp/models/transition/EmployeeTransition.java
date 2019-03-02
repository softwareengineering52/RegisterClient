package edu.uark.uarkregisterapp.models.transition;

import android.os.Parcel;
import android.os.Parcelable;

import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.UUID;

import edu.uark.uarkregisterapp.commands.converters.ByteToUUIDConverterCommand;
import edu.uark.uarkregisterapp.commands.converters.UUIDToByteConverterCommand;
import edu.uark.uarkregisterapp.models.api.Employee;

public class EmployeeTransition implements Parcelable {
    private UUID id;
    public UUID getId() {
        return this.id;
    }
    public EmployeeTransition setId(UUID id) {
        this.id = id;
        return this;
    }

    private String lookupCode;
    public String getLookupCode() {
        return this.lookupCode;
    }
    public EmployeeTransition setLookupCode(String lookupCode) {
        this.lookupCode = lookupCode;
        return this;
    }

    private int count;
    public int getCount() {
        return this.count;
    }
    public EmployeeTransition setCount(int count) {
        this.count = count;
        return this;
    }

    private String firstName;
    public String getFirstName(){ return this.firstName; }
    public EmployeeTransition setFirstName (String firstName) {
        this.firstName = firstName;
        return this;
    }

    private String lastName;
    public String getLastName(){ return this.lastName; }
    public EmployeeTransition setLastName (String lastName) {
        this.lastName = lastName;
        return this;
    }

    private boolean activeStatus;
    public boolean getActiveStatus(){ return this.activeStatus; }
    public EmployeeTransition setActiveStatus (boolean activeStatus) {
        this.activeStatus = activeStatus;
        return this;
    }

    private String rank;
    public String getRank(){ return this.rank; }
    public EmployeeTransition setRank (String rank) {
        this.rank = rank;
        return this;
    }

    private int managerID;
    public int getManagerID(){ return this.managerID; }
    public EmployeeTransition setManagerID (int managerID) {
        this.managerID = managerID;
        return this;
    }

    private String password;
    public String getPassword(){ return this.password; }
    public EmployeeTransition setPassword (String password) {
        this.password = password;
        return this;
    }

    private Date createdOn;
    public Date getCreatedOn() {
        return this.createdOn;
    }
    public EmployeeTransition setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
        return this;
    }

    @Override
    public void writeToParcel(Parcel destination, int flags) {
        destination.writeByteArray((new UUIDToByteConverterCommand()).setValueToConvert(this.id).execute());
        destination.writeString(this.lookupCode);
        destination.writeInt(this.count);
        destination.writeString(this.firstName);
        destination.writeString(this.lastName);
        destination.writeValue(this.activeStatus);
        destination.writeString(this.rank);
        destination.writeInt(this.managerID);
        destination.writeString(this.password);
        destination.writeLong(this.createdOn.getTime());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<EmployeeTransition> CREATOR = new Parcelable.Creator<EmployeeTransition>() {
        public EmployeeTransition createFromParcel(Parcel employeeTransitionParcel) {
            return new EmployeeTransition(employeeTransitionParcel);
        }

        public EmployeeTransition[] newArray(int size) {
            return new EmployeeTransition[size];
        }
    };

    public EmployeeTransition() {
        this.count = -1;
        this.id = new UUID(0, 0);
        this.createdOn = new Date();
        this.lookupCode = StringUtils.EMPTY;
        this.firstName = "";
        this.lastName = "";
        this.activeStatus = false;
        this.rank = "cashier";
        this.managerID = -1;
        this.password = "";
    }

    public EmployeeTransition(Employee employee) {
        this.id = employee.getId();
        this.count = employee.getCount();
        this.createdOn = employee.getCreatedOn();
        this.lookupCode = employee.getLookupCode();
        this.firstName = employee.getFirstName();
        this.lastName = employee.getLatName();
        this.activeStatus = employee.getActiveStatus();
        this.rank = employee.getRank();
        this.managerID = employee.getManagerID();
        this.password = employee.getPassword();
    }

    private EmployeeTransition(Parcel employeeTransitionParcel) {
        this.id = (new ByteToUUIDConverterCommand()).setValueToConvert(employeeTransitionParcel.createByteArray()).execute();
        this.lookupCode = employeeTransitionParcel.readString();
        this.count = employeeTransitionParcel.readInt();
        this.firstName = employeeTransitionParcel.readString();
        this.lastName = employeeTransitionParcel.readString();
        this.activeStatus = (Boolean) employeeTransitionParcel.readValue(Boolean.class.getClassLoader());
        this.rank = employeeTransitionParcel.readString();
        this.managerID = employeeTransitionParcel.readInt();
        this.password = employeeTransitionParcel.readString();
        this.createdOn = new Date();
        this.createdOn.setTime(employeeTransitionParcel.readLong());
    }
}
