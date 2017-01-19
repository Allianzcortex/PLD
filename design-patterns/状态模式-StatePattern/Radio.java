package Test;

/**
 * Created by hzcortex on 16-12-29.
 */
public class Radio {
    PMState pmState;
    AMState amState;
    State currentState;

    public Radio() {
        pmState = new PMState(this);
        amState = new AMState(this);
        this.currentState = amState;
    }

    public void toggleFMAM() {
        currentState.toggle();
    }

    public void scan() {
        currentState.scan();
    }

    public void setSate(State newState) {
        currentState = newState;
    }

    public static void main(String[] args) {
        Radio radio = new Radio();
        for (int i = 0; i <= 4; i++)
            radio.toggleFMAM();
        radio.scan();
        radio.scan();
    }
}

