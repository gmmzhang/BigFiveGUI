import java.util.HashMap;

public class IDandPasswords {
    HashMap<String,String> logininfo = new HashMap<String, String>();

    public IDandPasswords(){
        logininfo.put("Alta","pizza");
        logininfo.put("Lisa","apple");
        logininfo.put("Bruce","lee");

    }

    protected HashMap getLoginInfo (){
        return logininfo;
    }
}
