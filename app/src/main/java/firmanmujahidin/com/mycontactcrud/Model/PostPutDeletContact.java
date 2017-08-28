package firmanmujahidin.com.mycontactcrud.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by firma on 17-Aug-17.
 */

public class PostPutDeletContact {

    @SerializedName("status")
    String status;
    @SerializedName("result")
    Contact mContact;
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
    public Contact getKontak() {
        return mContact;
    }
    public void setKontak(Contact contak) {
        mContact = contak;
    }
}
