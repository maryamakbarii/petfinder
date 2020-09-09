
package remote.animals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Links_ {

    @SerializedName("previous")
    @Expose
    private Previous previous;
    @SerializedName("next")
    @Expose
    private Next next;

    public Previous getPrevious() {
        return previous;
    }

    public void setPrevious(Previous previous) {
        this.previous = previous;
    }

    public Next getNext() {
        return next;
    }

    public void setNext(Next next) {
        this.next = next;
    }

}
