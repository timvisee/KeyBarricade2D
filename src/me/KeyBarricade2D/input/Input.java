package me.KeyBarricade2D.input;

import me.KeyBarricade2D.input.key.KeyEventType;

import java.util.ArrayList;
import java.util.List;

public class Input {

    /**
     * List of pressed keys.
     */
    public static List<Integer> pressedKeys = new ArrayList<>();

    /**
     * Check whether a key is currently pressed.
     *
     * @param keyCode Code of the key.
     *
     * @return True if pressed, false if not.
     */
    public static boolean isPressed(int keyCode) {
        return pressedKeys.contains(keyCode);
    }

    /**
     * Process a key event.
     * Key events from AWT/Swing can be routed to this method.
     *
     * @param keyCode Code of the key that was pressed.
     * @param eventType Key press event.
     */
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

    /**
     * Flush all registered keys.
     * This will reset the state of each tracked key, until it's pressed again.
     */
    public static void flush() {
        // Flush the pressed keys
        pressedKeys.clear();
    }
}
