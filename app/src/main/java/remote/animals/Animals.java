
package remote.animals;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Animals {

    @SerializedName("animals")
    @Expose
    private List<Animal> animals = null;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public Pagination getPagination() {
        return pagination;
    }

    public void setPagination(Pagination pagination) {
        this.pagination = pagination;
    }

    public Animals(List<Animal> animals) {
        this.animals = animals;
    }
}
