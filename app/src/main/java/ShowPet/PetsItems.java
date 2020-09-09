package ShowPet;

public class PetsItems {
    public PetsItems(String date, String title, String description, int imageResource) {
        Date = date;
        Title = title;
        Description = description;
        ImageResource = imageResource;
    }

    public PetsItems() {
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setImageResource(int imageResource) {
        ImageResource = imageResource;
    }

    public String getDate() {
        return Date;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public int getImageResource() {
        return ImageResource;
    }

    String Date,Title,Description;
    int ImageResource;
}
