package androiddevelopment.assignment_2;

/**
 * Created by J on 13/09/2015.
 */
public class Movie {

    private String mTitle;
    private String mReleaseYear;
    private String mDescription;
    private int mImage_L;
    private int mImage_S;

    public Movie(String mTitle, String mReleaseYear, String mDescription,
                 int mImage_S, int mImage_L) {
        this.mDescription = mDescription;
        this.mImage_L = mImage_L;
        this.mImage_S = mImage_S;
        this.mReleaseYear = mReleaseYear;
        this.mTitle = mTitle;
    }

    public String getTitle() {return mTitle;}
    protected String getDescription() {return mDescription;}
    public int getImage_L() {return mImage_L;}
    public int getImage_S() {return mImage_S;}
    public String getReleaseYear() {
        return mReleaseYear;
    }


    public void setTitle(String mTitle) {this.mTitle = mTitle;}
    public void setDescription(String mDescription) {this.mDescription = mDescription;}
    public void setImage_L(int mImage_L) {
        this.mImage_L = mImage_L;
    }
    public void setImage_S(int mImage_S) {
        this.mImage_S = mImage_S;
    }
    public void setReleaseYear(String mReleaseYear) {this.mReleaseYear = mReleaseYear;}
}
