package guess.pojo;

public class Computer extends User{

    public Computer(String name) {
        super(name);
    }

    public int punches() {
        return (int) ((Math.random()*10)%3+1);
    }
}
