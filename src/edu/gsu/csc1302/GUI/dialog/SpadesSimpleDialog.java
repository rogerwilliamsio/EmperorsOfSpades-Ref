package edu.gsu.csc1302.GUI.dialog;

import java.awt.Frame;

import javax.swing.JOptionPane;

/**
 * the simple dialog box class.
 * @author Roger Williams
 */
@SuppressWarnings("serial")
public class SpadesSimpleDialog extends SpadesDialog {
     /**
     * Class constructor.
     * @param owner the frame.
     * @param messageType the message to be displayed.
     * @param dialogTitle the title of the dialog box.
     * @param dialogMessage the dialog message.
     */
    public SpadesSimpleDialog(final Frame owner,
    		final SpadesDialog.MessageType messageType,
            final String dialogTitle, final String dialogMessage) {
//        super(owner, dialogTitle, dialogMessage);

        JOptionPane pane = new JOptionPane(dialogMessage,
        		messageType.getMessageType());
        pane.createDialog(owner, dialogTitle).setVisible(true);
    }

}
