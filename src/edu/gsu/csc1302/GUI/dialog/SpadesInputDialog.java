package edu.gsu.csc1302.GUI.dialog;

import java.awt.Frame;

import javax.swing.JOptionPane;

/**
 * Input dialog box.
 * @author Roger Williams
 */
@SuppressWarnings("serial")
public class SpadesInputDialog extends SpadesDialog {
    /**
     * Class constructor.
     * @Todo: fix button issues.
     * @param owner the frame.
     * @param dialogTitle the title of the dialog box.
     * @param dialogMessage the dialog message.
     * @return value of the response.
     */
    public static String show(final Frame owner,
    		final String dialogTitle, final String dialogMessage) {
        String dialogResponse;

        do {
            dialogResponse = JOptionPane.showInputDialog(
            owner, dialogMessage, dialogTitle, JOptionPane.PLAIN_MESSAGE);
            if (dialogMessage.length() > 0) {
                dialogResponse = dialogResponse.trim();
            }
        } while (dialogResponse == null || dialogResponse.length() <= 0);

        return dialogResponse;
    }
}
