import java.net.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ChatClient extends JFrame implements Runnable {

    protected Socket socket;
    protected DataInputStream inStream;
    protected DataOutputStream outStream;
    protected JTextArea outTextArea;
    protected JTextField inTextField;
    protected JButton buttonSend;
    protected boolean isOn;

    public ChatClient(String title, Socket s, DataInputStream dis, DataOutputStream dos) {
        super(title);
        socket = s;
        inStream = dis;
        outStream = dos;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(BorderLayout.CENTER, outTextArea = new JTextArea());
        outTextArea.setEditable(false);
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(BorderLayout.CENTER,inTextField = new JTextField());
        inputPanel.add(BorderLayout.EAST, buttonSend = new JButton("Send"));
        cp.add(BorderLayout.SOUTH, inputPanel);

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    outStream.writeUTF(inTextField.getText());
                    outStream.flush();
                } catch (IOException ex) {
                    ex.printStackTrace();
                    isOn = false;
                }
                inTextField.setText("");
            }
        };

        inTextField.addActionListener(listener);
        buttonSend.addActionListener(listener);

        addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                isOn = false;
                try {
                    outStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                try {
                    socket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 500);
        setVisible(true);
        inTextField.requestFocus();
        (new Thread(this)).start();
    }

    public void run() {
        isOn = true;
        try {
            while (isOn) {
                String line = inStream.readUTF();
                outTextArea.append(line + "\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            inTextField.setVisible(false);
            validate();
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            throw new RuntimeException("Syntax: ChatClient <host> <port>");
        }
        Socket socket = new Socket(args[0], Integer.parseInt(args[1]));
        DataInputStream dis = null;
        DataOutputStream dos = null;
        System.out.println(socket.isBound());
        try {
            dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            new ChatClient("Chat " + args[0] + ":" + args[1], socket, dis, dos);
        } catch (IOException ex) {
            ex.printStackTrace();
            try {
                if (dos != null) dos.close();
            } catch (IOException ex2) {
                ex2.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException ex3) {
                ex3.printStackTrace();
            }
        }
    }
}