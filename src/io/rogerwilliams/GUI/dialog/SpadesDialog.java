package io.rogerwilliams.GUI.dialog;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * A default spades dialog GUI.
 *
 * @author Roger Williams
 */
@SuppressWarnings("serial")
public abstract class SpadesDialog extends JDialog {
    /**
     * Yes option.
     */
//    public static final char CONFIRM_YES_OPTION = 'y';

    /**
     * No option.
     */
//    public static final char CONFIRM_NO_OPTION = 'n';

    /**
     * The message.
     */
//    private final String dialogMessage;

    /**
     * The title of the dialog.
     */
//    private final String dialogTitle;

    /**
     * The entire gui of the dialog window.
     */
//    protected final SpadesPanel dialogGUI;

    /**
     * Just the content/message section of the dialog window.
     */
//    protected final JPanel contentPanel;

    /**
     *  Just the button section of the dialog window.
     */
//    protected final JPanel buttonPanel;
    /**
     * Supported dialog message types.
     */
    public enum MessageType {
        /**
         * Important information.
         */
        INFORMATION(JOptionPane.INFORMATION_MESSAGE),

        /**
         * An error occurred.
         */
        ERROR(JOptionPane.ERROR_MESSAGE),

        /**
         * Ask a question.
         */
        QUESTION(JOptionPane.QUESTION_MESSAGE),

        /**
         * A plain message.
         */
        PLAIN(JOptionPane.PLAIN_MESSAGE);

        /**
         * The type of message.
         */
        private final int messageType;

        /**
         * Constructor. Inits enum with the relevant JOption dialog types.
         * @param messageType the message type
         */
        MessageType(final int messageType) {
            this.messageType = messageType;
        }

        /**
         * Returns the the message type of the dialog.
         * @return message type.
         */
        int getMessageType() {
            return this.messageType;
        }
    }

    /**
     * Class constructor.
     */
    public SpadesDialog() {
//        super(owner);
//        this.dialogTitle = dialogTitle;
//        this.dialogMessage = dialogTitle;

//        Initialize window and panel layouts
//        this.dialogGUI = new SpadesPanel();
//        this.contentPanel = new JPanel(new FlowLayout());
//        this.buttonPanel = new JPanel(new FlowLayout());
//
//        //Add panels to the window.
//        this.dialogGUI.add(this.contentPanel);
//        this.dialogGUI.addToNthRow(this.buttonPanel, 5);

        UIManager.put("Button.background", Color.white);
        UIManager.put("Button.setFocusPainted", false);
        UIManager.put("Button.setCursor", new Cursor(Cursor.HAND_CURSOR));
    }

    /**
     * Returns the dialog message.
     * @return message
     */
//    public String getDialogMessage() {
//        return dialogMessage;
//    }

    /**
     * Returns the dialog title.
     * @return title
     */
//    public String getDialogTitle() {
//        return dialogTitle;
//    }

    /**
     * The content panel.
     * @return panel
     */
//    public JPanel contentPanel() {
//        return contentPanel;
//    }

    /**
     * The button panel
     * @return panel
     */
//    public JPanel buttonPanel() {
//        return buttonPanel;
//    }
}
