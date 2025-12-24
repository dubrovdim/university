package task2;


/** Target interface required by Circle drawing API (polar coordinates). */
public interface PolarPoint {
    void setRo(double ro);
    void setPhi(double phiRadians);
    double getRo();
    double getPhi();
}