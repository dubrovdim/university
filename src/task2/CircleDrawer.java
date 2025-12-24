package task2;


/**
* Client API that knows ONLY about PolarPoint.
* drawCircle uses polar coordinates (center as PolarPoint, radius ro).
* Business logic is a stub with console trace, per assignment.
*/
public class CircleDrawer {
    public void drawCircle(PolarPoint center, double radius) {
        System.out.println("[TRACE] drawCircle center(ro="+center.getRo()+", phi="+center.getPhi()+") radius="+radius);
    }
}