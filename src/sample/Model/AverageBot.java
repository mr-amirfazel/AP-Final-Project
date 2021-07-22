package sample.Model;

import javafx.geometry.Point2D;
import sample.Model.Bot;

public class AverageBot extends Bot {
    public Point2D getBotCoordinate(Point2D point2D) {
      double dx = point2D.getY()-232;
       double Y = point2D.getY()-(2.5*dx);
        double X = point2D.getX();

        return  new Point2D(X,Y);
    }
}
