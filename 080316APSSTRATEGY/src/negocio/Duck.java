/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocio;

/**
 *
 * @author iapereira
 */
public abstract class Duck {
    protected FlyBehavior flyBehavior ;
    protected QuackBehavior quackBehavior;

    public Duck(){
        this.flyBehavior = new FlyNoWay();
        this.quackBehavior =  new MuteQuack();
    }
    
    public abstract void display();

   public void performFly(){
       this.flyBehavior.fly();
   }
   
   public void performQuack(){
       this.quackBehavior.quack();
   }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }

    public void setQuackBehavior(QuackBehavior quackBehavior) {
        this.quackBehavior = quackBehavior;
    }
    
   
    
}
