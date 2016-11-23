
package facades;

import java.sql.Date;


public interface ISearch {
    public String getWithAllParam(String origin, String dest, Date date);
    public String getWithTwoParam(String origin, String dest);
    public String getWithDate(Date date);
    public String getWithOrigin(String origin, Date date);
}
