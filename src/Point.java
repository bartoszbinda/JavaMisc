import java.util.List;
import java.util.ArrayList;
public class Point {
    private int x, y;
    Point(){
      this(0,0);
    }
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public double getDistance(Point otherPoint) {
        return Math.sqrt(Math.pow(otherPoint.x - x,2) + Math.pow(otherPoint.y-y,2));
    }
    public boolean isWithinDistance(Point otherPoint, double distance){
        if(Math.abs(otherPoint.x - x ) > distance ||Math.abs(otherPoint.y - y) > distance) return false;
        return getDistance(otherPoint) <= distance;
    }
    public static List<Point> getPointsWithinDistance(List<Point> list, Point point, double distance){
        List<Point> withinDistanceList = new ArrayList<Point>();
        for(Point p : list) {
            if (p.isWithinDistance(point, distance)) {
                withinDistanceList.add(p);
            }
        }
            System.out.println(String.format("Points within distance %s of point x=%s , y=%s",
                    distance, point.getX(), point.getY()));
            for(Point p : withinDistanceList){
                System.out.println(String.format("Point: x =%s, y=%s", p.getX(), p.getY()));
            }
        return withinDistanceList;
    }
}
