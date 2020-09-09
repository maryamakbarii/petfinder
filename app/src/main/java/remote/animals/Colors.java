
package remote.animals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Colors {

    @SerializedName("primary")
    @Expose
    private Object primary;
    @SerializedName("secondary")
    @Expose
    private Object secondary;
    @SerializedName("tertiary")
    @Expose
    private Object tertiary;

    public Object getPrimary() {
        return primary;
    }

    public void setPrimary(Object primary) {
        this.primary = primary;
    }

    public Object getSecondary() {
        return secondary;
    }

    public void setSecondary(Object secondary) {
        this.secondary = secondary;
    }

    public Object getTertiary() {
        return tertiary;
    }

    public void setTertiary(Object tertiary) {
        this.tertiary = tertiary;
    }

}
