package androiddevelopment.assignment_2;

import android.graphics.Bitmap;

/**
 * Created by J on 13/09/2015.
 */
public class Movie {

    private String mTitle;
    private String mReleaseYear;
    private String mDescription;

    private int mImage_L;
    private int mImage_S;

    public Movie(String mDescription, int mImage_L, int mImage_S, String mReleaseYear, String mTitle) {
        this.mDescription = mDescription;
        this.mImage_L = mImage_L;
        this.mImage_S = mImage_S;
        this.mReleaseYear = mReleaseYear;
        this.mTitle = mTitle;
    }



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

    public int getmImage_L() {
        return mImage_L;
    }

    public void setmImage_L(int mImage_L) {
        this.mImage_L = mImage_L;
    }

    public int getmImage_S() {
        return mImage_S;
    }

    public void setmImage_S(int mImage_S) {
        this.mImage_S = mImage_S;
    }

    public String getmReleaseYear() {
        return mReleaseYear;
    }

    public void setmReleaseYear(String mReleaseYear) {
        this.mReleaseYear = mReleaseYear;
    }




}
