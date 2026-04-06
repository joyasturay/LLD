import java.util.*;

interface Talkable {
    void talk();
}

interface Walkable {
    void walk();
}

interface Flyable {
    void fly();
}

class NormalTalk implements Talkable {
    @Override
    public void talk() {
        System.out.println("Robot can talk");
    }
}

class NoTalk implements Talkable {
    @Override
    public void talk() {
        System.out.println("Robot cannot talk");
    }
}

class NormalFly implements Flyable {
    @Override
    public void fly() {
        System.out.println("Robot can fly");
    }
}

class NoFly implements Flyable {
    @Override
    public void fly() {
        System.out.println("Robot cannot fly");
    }
}

class FlyWithJet implements Flyable {
    @Override
    public void fly() {
        System.out.println("Robot can fly with jet");
    }
}

class NormalWalk implements Walkable {
    @Override
    public void walk() {
        System.out.println("Robot can walk");
    }
}

class NoWalk implements Walkable {
    @Override
    public void walk() {
        System.out.println("Robot cannot walk");
    }
}

abstract class Robot {
    Talkable t;
    Walkable w;
    Flyable f;

    public Robot(Talkable t, Walkable w,Flyable f) {
        this.t = t;
        this.w = w;
        this.f = f;
    }

    public void performFly() {
        f.fly();
    }

    public void performTalk() {
        t.talk();
    }

    public void performWalk() {
        w.walk();
    }

    public void setFlyBehaviour(Flyable f) {
        this.f = f;
    }

    abstract public void projection();
}

class CompanionRobot extends Robot {
    public CompanionRobot(Talkable t, Walkable w,Flyable f) {
        super(t, w,f);
    }
    @Override
    public void projection() {
        System.out.println("I am a companion Robot");
    }
}
public class StrategyDesignPattern {
    public static void main(String[] args) {
        Robot myRobot = new CompanionRobot(new NormalTalk(), new NormalWalk(), new NoFly());
        myRobot.projection();
        myRobot.performTalk();
        myRobot.performWalk();
        myRobot.performFly();
        System.out.println("\n--- Upgrading Robot ---");
        myRobot.setFlyBehaviour(new NormalFly());
        myRobot.performFly();
    }
}
