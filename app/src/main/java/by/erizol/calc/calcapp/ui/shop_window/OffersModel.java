package by.erizol.calc.calcapp.ui.shop_window;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OffersModel {

    @SerializedName("extras")
    @Expose
    private String extras;
    @SerializedName("link")
    @Expose
    private String link;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("pic")
    @Expose
    private String pic;
    @SerializedName("summary")
    @Expose
    private String summary;
    @SerializedName("type")
    @Expose
    private String type;

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
