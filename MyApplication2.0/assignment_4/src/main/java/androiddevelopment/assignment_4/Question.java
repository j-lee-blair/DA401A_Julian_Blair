package androiddevelopment.assignment_4;

/**
 * Created by J on 17/11/2015.
 */
public class Question {

    String[]list;

    public Question(String q1, String q2, String q3) {

        list = new String[3];
        list[0] = q1;
        list[1] = q2;
        list[2] = q3;

    }

    public String[] getList() {return list;}




}
