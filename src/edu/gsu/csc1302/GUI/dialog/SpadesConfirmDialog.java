package edu.gsu.csc1302.GUI.dialog;

import java.awt.Frame;

import javax.swing.JOptionPane;

/**
 * the confirmation receiver class.
 *
 * @author Roger Williams
 */
@SuppressWarnings("serial")
public class SpadesConfirmDialog extends SpadesDialog {
    /**
     * Class constructor.
     * @param owner the frame.
     * @param messageType the message to be displayed.
     * @param dialogTitle the title of the dialog box.
     * @param dialogMessage the dialog message.
     * @return boolean value of the response.
     */
    public static boolean show(final Frame owner,
    		final SpadesDialog.MessageType messageType,
                               final String dialogTitle,
                               final String dialogMessage) {
        int dialogResponse;

        do {
            dialogResponse = JOptionPane.showConfirmDialog(
            		owner, dialogMessage, dialogTitle, JOptionPane.YES_NO_OPTION);
        } while (dialogResponse == JOptionPane.CLOSED_OPTION);

        if (dialogResponse == JOptionPane.OK_OPTION
        		|| dialogResponse == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }
}
