package buynotes;
/**
 * Created by ysl on 18-8-5.
 */

public class notesDao {
    private int id;
    private double caccount;
    private String cdata;
    private String ctype;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getCaccount() {
        return caccount;
    }

    public void setCaccount(double caccount) {
        this.caccount = caccount;
    }

    public String getCdata() {
        return cdata;
    }

    public void setCdata(String cdata) {
        this.cdata = cdata;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public String getCdescribe() {
        return cdescribe;
    }

    public void setCdescribe(String cdescribe) {
        this.cdescribe = cdescribe;
    }

    private String cdescribe;


}
