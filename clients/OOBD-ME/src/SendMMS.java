
import com.sun.lwuit.layouts.*;
import com.sun.lwuit.events.*;

import com.sun.lwuit.*;
import java.io.*;
import javax.microedition.io.*;
import javax.wireless.messaging.*;

public class SendMMS extends Form implements ActionListener {

    private Form parent; //Where this form was started from
    private Command backCommand = null;
    private Command okCommand = null;
    Button scriptSelect = null;
    final TextField addressField = new TextField();
    final TextField subjectField = new TextField("OOBD Mobile Message");
    String mmsBody = null;
    MainMidlet mainMidlet = null;
    ButtonGroup group = new ButtonGroup();

    public SendMMS(String mmsBody, Form parent, final MainMidlet mainMidlet) {
        super("Send MMS");
        this.parent = parent;
        this.mainMidlet = mainMidlet;
        this.mmsBody = mmsBody;
        setLayout(new BoxLayout(BoxLayout.Y_AXIS));
        Label mmsLabel = new Label("Send text output to:");
        mmsLabel.setTextPosition(Component.BOTTOM);
        this.addComponent(mmsLabel);
        addressField.setText(mainMidlet.getMmsAddress());
        this.addComponent(addressField);
        Label subjectLabel = new Label("Subject:");
        subjectLabel.setTextPosition(Component.BOTTOM);
        this.addComponent(subjectLabel);
        this.addComponent(subjectField);

        Label typeLabel = new Label("Send text as:");
        typeLabel.setTextPosition(Component.BOTTOM);
        this.addComponent(typeLabel);

        RadioButton rb;

        rb = new RadioButton("Text");
        rb.setSelected(true);
        group.add(rb);
        addComponent(rb);

        rb = new RadioButton("XML");
        group.add(rb);
        addComponent(rb);

        rb = new RadioButton("Binary");
        group.add(rb);
        addComponent(rb);



        addCommand(okCommand = new Command("Send"));
        addCommand(backCommand = new Command("Cancel"));
        addCommandListener(this);
        show();

    }

    public void actionPerformed(ActionEvent ae) {

        Command command = ae.getCommand();
        if (command == backCommand) {
            parent.showBack();
        }
        if (command == okCommand) {
            String address = addressField.getText();
            if (address != null && !address.equals("")) {
                //String appID = getAppProperty("MMS-ApplicationID");
                //String address = "mms://+5550000:" + appID;
                mainMidlet.setMmsAddress(address);
                address = "mms://" + address;
                MessageConnection mmsconn = null;
                try {
                    /** Open the message connection. */
                    mmsconn = (MessageConnection) Connector.open(address);

                    MultipartMessage mmmessage = (MultipartMessage) mmsconn.newMessage(
                            MessageConnection.MULTIPART_MESSAGE);
                    //mmmessage.setAddress(address);
                    int fileFormat = group.getSelectedIndex();
                    byte[] textMsgBytes = "This message was generated by OOBD-ME\n\nOOBD.org - the new diagnostics".getBytes("UTF-8");
                    MessagePart textPart = new MessagePart(textMsgBytes, 0, textMsgBytes.length, "text/plain",
                            "message", "message text", "UTF-8");
                    mmmessage.addMessagePart(textPart);
                    String fileName = null;
                    String mimeType = null;
                    String coding = null;
                    if (fileFormat == 0) {
                        fileName = "OOBD-log.txt";
                        mimeType = "text/plain";
                        coding = "UTF-8";
                        textMsgBytes = mmsBody.getBytes(coding);
                    }
                    if (fileFormat == 1) {
                        fileName = "OOBD-log.xml";
                        mimeType = "text/xml";
                        coding = "UTF-8";
                        textMsgBytes = mmsBody.getBytes(coding);
                    }
                    if (fileFormat == 2) {
                        fileName = "OOBD-log.bin";
                        mimeType = "application/octet-stream";
                        // coding is nil   coding="UTF-8";
                        textMsgBytes = mmsBody.getBytes();
                    }
                    textPart = new MessagePart(textMsgBytes, 0, textMsgBytes.length, mimeType, "file", fileName, coding);
                    mmmessage.addMessagePart(textPart);
                    mmmessage.setSubject(subjectField.getText());
                    mmmessage.setStartContentId("message");
                    mmsconn.send(mmmessage);
                    Dialog.show("Success", "MMS sucessfully send", "ok", "ok");
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                if (mmsconn != null) {
                    try {
                        mmsconn.close();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                parent.showBack();
            } else {
                Dialog.show("No Address", "Please enter a valid receiver", "ok", "ok");
            }
        }
    }
}
