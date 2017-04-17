package edu.gsu.csc1302.GUI.dialog;

import javax.swing.*;
import java.awt.*;

/**
 * description
 *
 * @author Roger Williams
 */
public class SpadesInputDialog extends SpadesDialog {
    /**
     * @Todo: fix button issues.
     * Class constructor.
     * @param owner
     * @param dialogTitle
     * @param dialogMessage
     */
    public static String show(final Frame owner, final String dialogTitle, final String dialogMessage) {
        String dialogResponse;

        do {
            dialogResponse = JOptionPane.showInputDialog(owner, dialogMessage, dialogTitle, JOptionPane.PLAIN_MESSAGE);
            if (dialogMessage.length() > 0) {
                dialogResponse = dialogResponse.trim();
            }
        } while (dialogResponse == null || dialogResponse.length() <= 0);

        return dialogResponse;
    }
}
