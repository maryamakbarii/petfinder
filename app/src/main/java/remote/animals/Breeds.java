
package remote.animals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Breeds {

    @SerializedName("primary")
    @Expose
    private String primary;
    @SerializedName("secondary")
    @Expose
    private Object secondary;
    @SerializedName("mixed")
    @Expose
    private Boolean mixed;
    @SerializedName("unknown")
    @Expose
    private Boolean unknown;

    public String getPrimary() {
        return primary;
    }

    public void setPrimary(String primary) {
        this.primary = primary;
    }

    public Object getSecondary() {
        return secondary;
    }

    public void setSecondary(Object secondary) {
        this.secondary = secondary;
    }

    public Boolean getMixed() {
        return mixed;
    }

    public void setMixed(Boolean mixed) {
        this.mixed = mixed;
    }

    public Boolean getUnknown() {
        return unknown;
    }

    public void setUnknown(Boolean unknown) {
        this.unknown = unknown;
    }

}
