package guess.service;

import  guess.pojo.Computer;
import guess.pojo.Person;
import java.util.Scanner;

public class Game {
    private Person person=null;
    private Computer computer=null;
    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    Scanner input = null;

    public  Game(){

    }

    public Game(Person person, Computer computer){
        super();
        this.person=person;
        this.computer=computer;
    }

    public int  rule(int perFirst,int comFirst) {
        if((perFirst == comFirst )){
            System.out.println("结果:和局,真衰！嘿嘿,等着瞧吧 !\n");
        }else if((perFirst == 1 && comFirst == 3) ||
                (perFirst == 2  && comFirst == 1) ||
                (perFirst == 3 && comFirst == 2)){
            System.out.println("结果： 恭喜， 你赢了！");
            int score=person.getScore()+1;
            person.setScore(score);
            return 1;
        }else{
            System.out.println("结果说:^_^,你输了，真笨!\n");
           int score=computer.getScore()+1;
           computer.setScore(score);
            return 2;
        }
        count++;
        return 0;
    }

    public int calcResult() {
        if (person.getScore() == computer.getScore()) {
            return 0;
        } else if (person.getScore() > computer.getScore()) {
            return 1;
        } else {
            return 2;
        }
    }

    public String showResult() {
        String str="------------对战结果---------------";
        str+="\n 对战次数：" + this.count;
        int result = calcResult();
        str+="\n" + person.getName() + " VS " + computer.getName();
        if (result == 0) {
           str+="\n 和局";
        } else if (result == 1) {
           str+="\n 玩家["+person.getName()+" ]你赢了";
        } else {
           str+="\n 电脑["+computer.getName()+"]赢了";
        }
        str+="\n-------------------------------------";
        return str;
    }

}
