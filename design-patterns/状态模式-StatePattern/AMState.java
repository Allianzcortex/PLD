package Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzcortex on 16-12-29.
 */
public class AMState implements State {
    Radio radio;
    String status;
    List<Integer> itemList;
    int position;

    public AMState(Radio radio) {
        this.radio = radio;
        this.status = "AM";
        this.itemList = new ArrayList<Integer>();
        this.itemList.add(1);
        this.itemList.add(2);
        this.position = 0;
    }

    public void toggle() {
        System.out.println("切换电台");
        /*radio.currentState.toggle();*/
        radio.currentState = radio.pmState;
    }

    public void scan() {
        System.out.println("当前是 AM 电台为" + itemList.get(position));
        position += 1;
        if (position == itemList.size())
            position = 0;

    }
}

