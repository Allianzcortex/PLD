package Test;

import Test.Beverage;
/**
 * Created by hzcortex on 16-12-1.
 * 这个是装饰器的基本类
 */
public abstract class CondimentDecorator extends Beverage{
    // 也被声明为 abstract 类，否则就要实现 cost() 方法
    public abstract String getDescription();
}

