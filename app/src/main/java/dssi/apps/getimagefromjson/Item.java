package dssi.apps.getimagefromjson;

import android.graphics.Bitmap;

/**
 * Created by Utilisateur on 27/12/2016.
 */

public class Item {
    private String tv ;
    private Bitmap ic ;

    public Item(String tv, Bitmap ic ) {
        this.tv = tv;
        this.ic = ic;
    }

    public String getTv() {
        return tv;
    }

    public void setTv(String tv) {
        this.tv = tv;
    }

    public Bitmap getIc() {
        return ic;
    }

    public void setIc(Bitmap ic) {
        this.ic = ic;
    }
}
