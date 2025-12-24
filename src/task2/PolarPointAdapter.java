package task2;


/**
* Adapter: makes a Cartesian Point look like a PolarPoint.
* It wraps an existing Point (adaptee) and converts setRo/setPhi to setX/setY.
*/
public class PolarPointAdapter implements PolarPoint {
    private final Point adaptee;
    private double ro;
    private double phi; 


    public PolarPointAdapter(Point adaptee) {
        this.adaptee = adaptee;
        this.ro = Math.hypot(adaptee.getX(), adaptee.getY());
        this.phi = Math.atan2(adaptee.getY(), adaptee.getX());
        System.out.println("[TRACE] Adapter init ro="+ro+", phi="+phi);
    }


    @Override public void setRo(double ro) {
        this.ro = ro;
        syncCartesian();
        System.out.println("[TRACE] setRo("+ro+") -> Cartesian " + adaptee);
    }


    @Override public void setPhi(double phi) {
        this.phi = phi;
        syncCartesian();
        System.out.println("[TRACE] setPhi("+phi+") -> Cartesian " + adaptee);
    }


    @Override public double getRo() { return ro; }
    @Override public double getPhi() { return phi; }


    private void syncCartesian() {
        int x = (int)Math.round(ro * Math.cos(phi));
        int y = (int)Math.round(ro * Math.sin(phi));
        adaptee.setX(x);
        adaptee.setY(y);
    }
}