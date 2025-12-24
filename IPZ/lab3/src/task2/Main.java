package task2;


/**
* Demo for Variant 4 (Adapter):
* 1) Коло з центром у наявній декартовій точці (адаптація без зміни інтерфейсу Point)
* 2) Зміна тільки phi (кут) через PolarPoint API
* 3) Зміна і ro, і phi, комбіновано (демо гнучкості адаптера)
*/
public class Main {
public static void main(String[] args) {
Point cart = new CartesianPoint(3, 4);


PolarPoint polar = new PolarPointAdapter(cart);
CircleDrawer drawer = new CircleDrawer();


System.out.println("Example 1: draw with initial center");
drawer.drawCircle(polar, 10.0);
System.out.println();


System.out.println("Example 2: rotate center by +90° (phi += π/2)");
polar.setPhi(polar.getPhi() + Math.PI/2);
drawer.drawCircle(polar, 10.0);
System.out.println();


System.out.println("Example 3: move center outward (ro = 12) and rotate to 45°");
polar.setRo(12.0);
polar.setPhi(Math.PI/4);
drawer.drawCircle(polar, 12.0);
}
}