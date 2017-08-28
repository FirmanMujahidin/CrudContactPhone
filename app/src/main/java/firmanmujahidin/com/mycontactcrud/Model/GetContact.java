package firmanmujahidin.com.mycontactcrud.Model;


import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by firma on 17-Aug-17.
 */

public class GetContact {   @SerializedName("status")
String status;
    @SerializedName("result")
    List<Contact> listDataContact;
    @SerializedName("message")
    String message;
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public List<Contact> getListDataContact() {
        return listDataContact;
    }
    public void setListDataKontak(List<Contact> listDataKontak) {
        this.listDataContact = listDataKontak;
    }
}
