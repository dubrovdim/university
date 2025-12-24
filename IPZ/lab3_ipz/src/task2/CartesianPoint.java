package task2;


/** Existing concrete point in Cartesian coordinates. */
public class CartesianPoint implements Point {
    private int x;
    private int y;


    public CartesianPoint(int x, int y) {
        this.x = x;
        this.y = y;
        System.out.println("[TRACE] CartesianPoint created x=" + x + ", y=" + y);
    }


    @Override public void setX(int x) { this.x = x; System.out.println("[TRACE] setX("+x+")"); }
    @Override public void setY(int y) { this.y = y; System.out.println("[TRACE] setY("+y+")"); }
    @Override public int getX() { return x; }
    @Override public int getY() { return y; }


    @Override public String toString() { return "Point[x="+x+", y="+y+"]"; }
}