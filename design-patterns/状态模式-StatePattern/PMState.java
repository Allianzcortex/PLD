package Test;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzcortex on 16-12-29.
 */
public class PMState implements State {
    Radio radio;
    String status;
    List<Integer> itemList;
    int position;

    public PMState(Radio radio) {
        this.radio = radio;
        this.status = "PM";
        this.itemList = new ArrayList<Integer>();
        this.itemList.add(3);
        this.itemList.add(4);
        this.position = 0;
    }

    public void toggle() {
        System.out.println("切换电台");
        /*radio.currentState.toggle();*/
        // 写的时候思路应该更清晰啊
        radio.currentState = radio.amState;
    }

    public void scan() {
        System.out.println("当前是 PM 电台为" + itemList.get(position));
        position += 1;
        if (position == itemList.size())
            position = 0;

    }
}

