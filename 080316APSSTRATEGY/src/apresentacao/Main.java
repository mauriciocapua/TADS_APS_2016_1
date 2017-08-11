/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apresentacao;

import negocio.FlyNoWay;
import negocio.FlyRocket;
import negocio.FlyWithWings;
import negocio.MallardDuck;
import negocio.Quack;
import negocio.RubberDuck;

/**
 *
 * @author iapereira
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        /*
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.setFlyBehavior(new FlyWithWings());
        mallardDuck.setQuackBehavior(new Quack());
        
        mallardDuck.display();
        mallardDuck.performFly();
        mallardDuck.performQuack();
        
        System.out.println("------------------");
        System.out.println("Tomou um tiro. Perdeu as asas");
        mallardDuck.setFlyBehavior(new FlyNoWay());        
        mallardDuck.performFly();
          */
        
       /* RubberDuck rubberDuck =  new RubberDuck();
        rubberDuck.display();
        rubberDuck.setFlyBehavior(new FlyRocket());
        rubberDuck.performFly();
        rubberDuck.performQuack();*/
        
        MallardDuck mallardDuck = new MallardDuck();
        mallardDuck.display();
        mallardDuck.performFly();
        mallardDuck.performQuack();
    }
    
}
