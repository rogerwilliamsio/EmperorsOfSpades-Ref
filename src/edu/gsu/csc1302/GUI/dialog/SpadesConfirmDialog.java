package edu.gsu.csc1302.GUI.dialog;

import javax.swing.*;
import java.awt.*;

/**
 * description
 *
 * @author Roger Williams
 */
public class SpadesConfirmDialog extends SpadesDialog {
    /**
     * Class constructor.
     * @param owner
     * @param messageType
     * @param dialogTitle
     * @param dialogMessage
     */
    public static boolean show (final Frame owner, final SpadesDialog.MessageType messageType,
                               final String dialogTitle, final String dialogMessage) {
        int dialogResponse;

        do {
            dialogResponse = JOptionPane.showConfirmDialog(owner, dialogMessage, dialogTitle, JOptionPane.YES_NO_OPTION);
        } while (dialogResponse == JOptionPane.CLOSED_OPTION);

        if (dialogResponse == JOptionPane.OK_OPTION || dialogResponse == JOptionPane.YES_OPTION) {
            return true;
        }
        return false;
    }
}
