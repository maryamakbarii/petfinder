
package remote.animals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Attributes {

    @SerializedName("spayed_neutered")
    @Expose
    private Boolean spayedNeutered;
    @SerializedName("house_trained")
    @Expose
    private Boolean houseTrained;
    @SerializedName("declawed")
    @Expose
    private Object declawed;
    @SerializedName("special_needs")
    @Expose
    private Boolean specialNeeds;
    @SerializedName("shots_current")
    @Expose
    private Boolean shotsCurrent;

    public Boolean getSpayedNeutered() {
        return spayedNeutered;
    }

    public void setSpayedNeutered(Boolean spayedNeutered) {
        this.spayedNeutered = spayedNeutered;
    }

    public Boolean getHouseTrained() {
        return houseTrained;
    }

    public void setHouseTrained(Boolean houseTrained) {
        this.houseTrained = houseTrained;
    }

    public Object getDeclawed() {
        return declawed;
    }

    public void setDeclawed(Object declawed) {
        this.declawed = declawed;
    }

    public Boolean getSpecialNeeds() {
        return specialNeeds;
    }

    public void setSpecialNeeds(Boolean specialNeeds) {
        this.specialNeeds = specialNeeds;
    }

    public Boolean getShotsCurrent() {
        return shotsCurrent;
    }

    public void setShotsCurrent(Boolean shotsCurrent) {
        this.shotsCurrent = shotsCurrent;
    }

}
