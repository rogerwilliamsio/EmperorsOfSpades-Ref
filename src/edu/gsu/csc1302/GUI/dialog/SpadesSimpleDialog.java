package edu.gsu.csc1302.GUI.dialog;

import javax.swing.*;
import java.awt.*;

/**
 * description
 *
 * @author Roger Williams
 */
public class SpadesSimpleDialog extends SpadesDialog {
    /**
     * Class constructor.
     * @param owner
     * @param messageType
     * @param dialogTitle
     * @param dialogMessage
     */
    public SpadesSimpleDialog (final Frame owner, final SpadesDialog.MessageType messageType,
                              final String dialogTitle, final String dialogMessage) {
//        super(owner, dialogTitle, dialogMessage);

        JOptionPane pane = new JOptionPane(dialogMessage, messageType.getMessageType());
        pane.createDialog(owner, dialogTitle).setVisible(true);
    }

}
