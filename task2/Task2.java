package task2;

public class Task2 {
    public static void main(String[] msi) {
        float x_cen = 0;
        float y_cen = 0;
        int rad = 5;
        float x = 5;
        float y = 0;
        circle(x_cen, y_cen, rad, x, y);
    }

    public static void circle(float x_cen, float y_cen, int rad, float x, float y) {
        if (Math.pow((x - x_cen), 2) + Math.pow((y - y_cen), 2) == Math.pow(rad, 2))
            System.out.println("0 - точка лежит на окружности");
        else if (Math.pow((x - x_cen), 2) + Math.pow((y - y_cen), 2) < Math.pow(rad, 2))
            System.out.println("1 - точка внутри");
        else if (Math.pow((x - x_cen), 2) + Math.pow((y - y_cen), 2) > Math.pow(rad, 2))
            System.out.println("2 - точка снаружи");
    }
}
