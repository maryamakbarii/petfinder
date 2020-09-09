
package remote.animals;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Environment {

    @SerializedName("children")
    @Expose
    private Boolean children;
    @SerializedName("dogs")
    @Expose
    private Boolean dogs;
    @SerializedName("cats")
    @Expose
    private Boolean cats;

    public Boolean getChildren() {
        return children;
    }

    public void setChildren(Boolean children) {
        this.children = children;
    }

    public Boolean getDogs() {
        return dogs;
    }

    public void setDogs(Boolean dogs) {
        this.dogs = dogs;
    }

    public Boolean getCats() {
        return cats;
    }

    public void setCats(Boolean cats) {
        this.cats = cats;
    }

}
