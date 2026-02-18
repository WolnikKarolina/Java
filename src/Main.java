import java.util.Objects;

public class Main{
    public static void main(String[] args) {

        Rectangle r1 = new Rectangle(5.0 , 5.0);
        Rectangle r2 = new Rectangle(2.5 , 4.0);
        Rectangle r3 = new Rectangle(7.7 , 1.0);

        System.out.println(r1 + "czy kwadrat?: " + r1.isSquare());
        System.out.println(r1.area());
        System.out.println();

    }

    record Rectangle (double width, double height){
        @Override
        public boolean equals(Object o) {
            if (o == null || getClass() != o.getClass()) return false;
            Rectangle rectangle = (Rectangle) o;
            return Double.compare(width, rectangle.width) == 0 && Double.compare(height, rectangle.height) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(width, height);
        }

        double area(){
            return Math.abs(width * height);
        }

        boolean isSquare(){
            return width == height;
        }
    }


}