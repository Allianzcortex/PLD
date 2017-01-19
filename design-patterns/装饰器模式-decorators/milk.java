package Test;

/**
 * Created by hzcortex on 16-12-1.
 */

import Test.CondimentDecorator;
import Test.Beverage;
// 继承 condimentDecorator 修饰器，当咖啡里要加牛奶时用到

public class Milk extends CondimentDecorator {
    Beverage beverate;

    public Milk(Beverage beverage) {
        this.beverate = beverage;
    }

    public String getDescription() {
        return beverate.getDesription() + "add milk";
    }

    public double cost() {
        return beverate.cost() + 0.10;
    }

}

