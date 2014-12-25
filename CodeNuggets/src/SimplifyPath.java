import java.util.ArrayList;


public class SimplifyPath {
    public String simplifyPath(String path) {
        
        if (path == null || path.length() == 0) {
            return "";
        }
        
        String[] substrs = path.split("/+"); //Dedup /
        ArrayList<String> simpliedPath = new ArrayList<String>();
        System.out.println(" len : " + simpliedPath.size());

        for (String str : substrs) {
            System.out.println(" str : " + str);
            if (str.equals(".") || str.equals("")) {
                continue; //omit .
            } else if (str.equals("..")) { //Tricky case
                if (!simpliedPath.isEmpty()) {
                    simpliedPath.remove(simpliedPath.size() - 1);
                } else {
                    return "/"; //Would have been wrong in this case.
                }
            } else {
                simpliedPath.add("/" + str);
            }
        }
        
        System.out.println(" len : " + simpliedPath.size());

        String res = "";
        if (simpliedPath.size() > 0) {
            for (String str : simpliedPath) {
                res += str;
            }
        } else {
            res = "/";
        }
        
        return res;
    }
}
