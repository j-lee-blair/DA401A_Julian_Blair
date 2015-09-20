package androiddevelopment.assignment_2;

import android.graphics.Bitmap;

/**
 * Created by J on 13/09/2015.
 */
public class Movie {

    private String mTitle;
    private String mDescription;
    private String mReleaseYear;
    private Bitmap mImage_L;
    private Bitmap mImage_S;

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public Bitmap getmImage_L() {
        return mImage_L;
    }

    public void setmImage_L(Bitmap mImage_L) {
        this.mImage_L = mImage_L;
    }

    public Bitmap getmImage_S() {
        return mImage_S;
    }

    public void setmImage_S(Bitmap mImage_S) {
        this.mImage_S = mImage_S;
    }

    public String getmReleaseYear() {
        return mReleaseYear;
    }

    public void setmReleaseYear(String mReleaseYear) {
        this.mReleaseYear = mReleaseYear;
    }




}
