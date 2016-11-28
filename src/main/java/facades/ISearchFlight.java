
package facades;


public interface ISearchFlight {
    public String getWithOriginDate(String origin, String date, int tickets);
    public String getWithAllParam(String origin, String dest, String date, int tickets);
    public String getFlightInfo(String flightId);
}
