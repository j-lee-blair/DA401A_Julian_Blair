package androiddevelopment.assignment_4;

/**
 * Created by J on 23/10/2015.
 */
public class InZone {
    Zone zone;
    Boolean bool;

    public Boolean getBool() {return bool;}
    public Zone getZone() {return zone;}

    public InZone(Zone zone, Boolean bool) {
        this.bool = bool;
        this.zone = zone;
    }
}
