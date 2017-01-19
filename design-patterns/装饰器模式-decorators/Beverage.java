package Test;


/**
 * Created by hzcortex on 16-12-1.
 * 这个是咖啡的基本类
 */
public abstract class Beverage {
    // 如果下面的声明为 private 的话，那么继承它的类是无法使用 description 这点的
    String description="This is base coffee";

    public String getDesription(){
        return description;
    }

    public abstract double cost();
}

