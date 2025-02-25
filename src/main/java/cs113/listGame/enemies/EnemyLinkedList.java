package cs113.listGame.enemies;

import cs113.listGame.behaviors.Behavior;
import cs113.listGame.behaviors.MoveToPoint;
import javafx.geometry.Point2D;
import javafx.scene.image.ImageView;

import java.util.LinkedList;

public class EnemyLinkedList extends EnemyObject {
    LinkedList<Behavior> behaviors = new LinkedList<>();

    public EnemyLinkedList(ImageView imageView) { super(imageView); }

    @Override
    public void seedBehaviors() {
        Point2D dest = new Point2D(this.getWorldCenter().getX(), this.getWorldCenter().getY());
        behaviors.addLast(new MoveToPoint(this, 3000, dest));
        dest = new Point2D(this.getWorldCenter().getX()-200, this.getWorldCenter().getY()-200);
        behaviors.addLast(new MoveToPoint(this, 2000, dest)); // Added missing duration parameter
        dest = new Point2D(this.getWorldCenter().getX()-200, this.getWorldCenter().getY()-200);
        behaviors.addLast(new MoveToPoint(this, 2000, dest));
        dest = new Point2D(this.getWorldCenter().getX(), this.getWorldCenter().getY());
        behaviors.addLast(new MoveToPoint(this, 2000, dest)); //
    }

    @Override
    public Behavior getNextBehavior() {
        if ( behaviors.isEmpty()) return null;
        return behaviors.pop();
    }
}
