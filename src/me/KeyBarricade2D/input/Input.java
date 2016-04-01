package me.KeyBarricade2D.input;
import me.KeyBarricade2D.input.key.KeyEventType;

import java.util.ArrayList;
import java.util.List;

public class Input {

    public static List<Integer> pressedKeys = new ArrayList<>();

    public static void init() {
        // Flush all inputs
        flush();
    }
    public static boolean isPressed(int keyCode) {
        return pressedKeys.contains(keyCode);
    }

    public static void processKeyEvent(int keyCode, KeyEventType eventType) {
        // Process the key
        switch(eventType) {
            case PRESSED:
                // Add the key to the list if it isn't in the list already
                if(!pressedKeys.contains(keyCode)) {
                    pressedKeys.add(keyCode);
                    break;
                }

            case RELEASED:
                // Remove the key from the list if it's currently in the list
                pressedKeys.remove((Integer) keyCode);
                break;

            default:
        }
    }

    public static void flush() {
        // Flush the pressed keys
        pressedKeys.clear();
    }
}
