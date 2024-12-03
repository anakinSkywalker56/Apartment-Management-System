import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicSpinnerUI;

public class FrameClass extends JFrame implements ActionListener {
    JFrame f = new JFrame("Enter Password");
    JPasswordField pass = new JPasswordField(16);

    ////// This area is for the Password Pane
    public void adminAccess() {
        JButton b = new JButton("submit");
        JFrame f = new JFrame("textfield");
        JPanel p = new JPanel();

        p.setFont(new Font("Arial", Font.PLAIN, 30));
        p.add(pass);
        p.add(b);

        // add panel to frame
        f.add(p);

        // set the size of frame
        f.setSize(300, 300);
        b.addActionListener(this);

        f.setVisible(true);
        f.setDefaultCloseOperation(EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        char[] password = pass.getPassword();
        String p = new String(password);
        if (s.equals("submit")) {
            System.out.println(p);
            if (p.equals("@dmin!")) {

                f.setVisible(false);
                displayFrame();
            } else {
                f.setVisible(false);
                JOptionPane.showMessageDialog(f, "Wrong Password!!", "Err",
                        JOptionPane.ERROR_MESSAGE);
                pass.setText("");
                adminAccess();
            }
        }
    }

    ////// This area is for the main page where you can see the cells of each
    ////// apartment
    JTextField roomNumber = new JTextField(16);
    JTextField tenantName = new JTextField(16);
    JTextField contactNumber = new JTextField(16);
    JTextField email = new JTextField(16);
    JSpinner dateOccupied = new JSpinner(new SpinnerDateModel());
    JSpinner lastOccupied = new JSpinner(new SpinnerDateModel());
    JLabel CashBalance = new JLabel("Cash Balance");
    JTextField LCashBalance = new JTextField();
    JTextField tPaymentPeriod = new JTextField();
    JTextField tPaymentStatus = new JTextField();
    JButton submit = new JButton("Submit");

    JPanel p1 = new JPanel();
    JPanel p2 = new JPanel();
    JPanel p3 = new JPanel();

    boolean x = false;
    JLabel unselected = new JLabel("Please Select a Room");

    int roomIndex = -1;
    int i;
    Room[] rooms = new Room[12];
    boolean submitted = false;

    ButtonGroup services = new ButtonGroup();
    JRadioButton y = new JRadioButton("Yes");
    JRadioButton n = new JRadioButton("No");

    JCheckBox breakfast = new JCheckBox("Breakfast");
    JCheckBox lunch = new JCheckBox("Lunch");
    JCheckBox dinner = new JCheckBox("Dinner");
    JCheckBox cleaning = new JCheckBox("Room Cleaning");

    public void displayFrame() {
        JFrame frame = new JFrame("FrameDemo");
        // frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setBackground(Color.decode("#1F1F1F"));

        JSpinner.DateEditor occupiedEditor = new JSpinner.DateEditor(dateOccupied, "yyyy-MM-dd");
        JSpinner.DateEditor lastOcEditor = new JSpinner.DateEditor(lastOccupied, "yyyy-MM-dd");

        ChangeListener changeListener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                updateResult();
            }
        };
        dateOccupied.addChangeListener(changeListener);
        lastOccupied.addChangeListener(changeListener);

        dateOccupied.setEditor(occupiedEditor);
        dateOccupied.setValue(new Date());

        lastOccupied.setEditor(lastOcEditor);
        lastOccupied.setValue(new Date());

        p1.setLayout(null);
        p1.setBackground(Color.decode("#1F1F1F"));
        p2.setBackground(Color.decode("#1F1F1F"));
        p3.setBackground(Color.YELLOW);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel l1 = new JLabel("Room No.");
        JLabel l2 = new JLabel("Tenant Name");
        JLabel l3 = new JLabel("Contact num");
        JLabel l4 = new JLabel("Email");
        JLabel l5 = new JLabel("Date Occupied");
        JLabel l6 = new JLabel("Last Occupied");
        JLabel paymentPeriod = new JLabel("Payment Period");
        JLabel paymentStatus = new JLabel("Payment Status");
        JLabel serve = new JLabel("Services: ");
        JLabel desc = new JLabel("(100 per day each)");

        services.add(y);
        services.add(n);
        n.setSelected(true);
        breakfast.setVisible(false);
        lunch.setVisible(false);
        dinner.setVisible(false);
        cleaning.setVisible(false);

        l1.setBounds(100, 100, 400, 40);
        l2.setBounds(100, 150, 400, 40);
        l3.setBounds(100, 200, 400, 40);
        l4.setBounds(100, 250, 400, 40);
        l5.setBounds(100, 300, 400, 40);
        l6.setBounds(100, 350, 400, 40);
        serve.setBounds(100, 400, 400, 40);
        desc.setBounds(100, 450, 400, 40);
        CashBalance.setBounds(100, 700, 400, 40);
        paymentPeriod.setBounds(100, 750, 400, 40);
        paymentStatus.setBounds(100, 800, 400, 40);

        roomNumber.setBounds(250, 100, 300, 40);
        tenantName.setBounds(250, 150, 300, 40);
        contactNumber.setBounds(250, 200, 300, 40);
        email.setBounds(250, 250, 300, 40);
        dateOccupied.setBounds(250, 300, 300, 40);
        lastOccupied.setBounds(250, 350, 300, 40);

        //////////////////////////////////////////////////////////////////////////////
        y.setBounds(250, 400, 140, 40);
        n.setBounds(410, 400, 140, 40);
        breakfast.setBounds(250, 450, 300, 40);
        lunch.setBounds(250, 500, 300, 40);
        dinner.setBounds(250, 550, 300, 40);
        cleaning.setBounds(250, 600, 300, 40);

        LCashBalance.setBounds(250, 700, 300, 40);
        tPaymentPeriod.setBounds(250, 750, 300, 40);
        tPaymentStatus.setBounds(250, 800, 300, 40);
        submit.setBounds(250, 850, 300, 40);

        l1.setFont(new Font("Arial", Font.PLAIN, 20));
        l2.setFont(new Font("Arial", Font.PLAIN, 20));
        l3.setFont(new Font("Arial", Font.PLAIN, 20));
        l4.setFont(new Font("Arial", Font.PLAIN, 20));
        l5.setFont(new Font("Arial", Font.PLAIN, 20));
        l6.setFont(new Font("Arial", Font.PLAIN, 20));
        serve.setFont(new Font("Arial", Font.PLAIN, 20));
        desc.setFont(new Font("Arial", Font.PLAIN, 18));
        CashBalance.setFont(new Font("Arial", Font.PLAIN, 20));
        paymentPeriod.setFont(new Font("Arial", Font.PLAIN, 20));
        paymentStatus.setFont(new Font("Arial", Font.PLAIN, 20));

        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        l4.setForeground(Color.WHITE);
        l5.setForeground(Color.WHITE);
        l6.setForeground(Color.WHITE);
        serve.setForeground(Color.WHITE);
        desc.setForeground(Color.WHITE);
        CashBalance.setForeground(Color.WHITE);
        paymentPeriod.setForeground(Color.WHITE);
        paymentStatus.setForeground(Color.WHITE);

        roomNumber.setFont(new Font("Arial", Font.PLAIN, 20));
        tenantName.setFont(new Font("Arial", Font.PLAIN, 20));
        contactNumber.setFont(new Font("Arial", Font.PLAIN, 20));
        email.setFont(new Font("Arial", Font.PLAIN, 20));
        dateOccupied.setFont(new Font("Arial", Font.PLAIN, 20));
        lastOccupied.setFont(new Font("Arial", Font.PLAIN, 20));
        LCashBalance.setFont(new Font("Arial", Font.PLAIN, 20));
        tPaymentPeriod.setFont(new Font("Arial", Font.PLAIN, 20));
        tPaymentStatus.setFont(new Font("Arial", Font.PLAIN, 20));
        submit.setFont(new Font("Arial", Font.PLAIN, 20));

        ///////////////////////////////////////////////////////////////////
        y.setFont(new Font("Arial", Font.PLAIN, 20));
        n.setFont(new Font("Arial", Font.PLAIN, 20));
        breakfast.setFont(new Font("Arial", Font.PLAIN, 20));
        lunch.setFont(new Font("Arial", Font.PLAIN, 20));
        dinner.setFont(new Font("Arial", Font.PLAIN, 20));
        cleaning.setFont(new Font("Arial", Font.PLAIN, 20));

        submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String tenantNme = (tenantName.getText());
                String contactNvm = contactNumber.getText();
                String mail = email.getText();
                JSpinner.DefaultEditor startEditor = (JSpinner.DefaultEditor) dateOccupied.getEditor();
                JSpinner.DefaultEditor lastEditor = (JSpinner.DefaultEditor) lastOccupied.getEditor();
                String dateOc = startEditor.getTextField().getText();
                String lastOc = lastEditor.getTextField().getText();
                double cashBal = Double.parseDouble(LCashBalance.getText());
                String payPer = tPaymentPeriod.getText();
                String payStat = tPaymentStatus.getText();

                Room selectedRoom = rooms[roomIndex];

                if (tenantNme == "" || contactNvm == "" || mail == "") {
                    JOptionPane.showMessageDialog(frame, "Please type in all input fields");
                } else if (contactNvm.length() != 11) {
                    JOptionPane.showMessageDialog(frame, "Contact Num must be 11 digits");
                } else {
                    selectedRoom.setRoomDetails(tenantNme, contactNvm, mail, dateOc, lastOc, cashBal, payPer, payStat,
                            y.isSelected(), breakfast.isSelected(), lunch.isSelected(), dinner.isSelected(),
                            cleaning.isSelected());

                    if (payStat.equals("For Evict")) {
                        selectedRoom.setColorFront(Color.RED);
                        selectedRoom.setRoomState(RoomState.RED);
                    } else if (payStat.equals("--")) {
                        selectedRoom.setColorFront(Color.GREEN);
                        selectedRoom.setRoomState(RoomState.GREEN);
                    } else if (payStat.equals("Due")) {
                        selectedRoom.setColorFront(Color.YELLOW);
                        selectedRoom.setRoomState(RoomState.YELLOW);
                    }

                }
            }
        });

        // t1.setOpaque(false);
        // t1.setEditable(false);

        p1.add(l1);
        p1.add(roomNumber);
        roomNumber.setBorder(new EmptyBorder(getInsets()));

        p1.add(l2);
        p1.add(tenantName);

        p1.add(l3);
        p1.add(contactNumber);

        p1.add(l4);
        p1.add(email);

        p1.add(l5);
        p1.add(dateOccupied);

        p1.add(l6);
        p1.add(lastOccupied);

        p1.add(serve);
        p1.add(desc);
        p1.add(y); // radio
        p1.add(n);
        p1.add(breakfast); // check
        p1.add(lunch); // check
        p1.add(dinner); // check
        p1.add(cleaning); // check

        p1.add(CashBalance);
        p1.add(LCashBalance);
        LCashBalance.setBorder(new EmptyBorder(getInsets()));

        p1.add(paymentPeriod);
        p1.add(tPaymentPeriod);
        tPaymentPeriod.setBorder(new EmptyBorder(getInsets()));

        p1.add(paymentStatus);
        p1.add(tPaymentStatus);
        tPaymentStatus.setBorder(new EmptyBorder(getInsets()));

        p1.add(submit);

        p1.setBounds(0, 0, 1000, 20000);

        p3.setLayout(null);
        p3.setPreferredSize(new Dimension(200, 100));

        unselected.setBounds(100, 100, 400, 40);
        unselected.setFont(new Font("Arial", Font.PLAIN, 20));
        unselected.setVisible(true);
        p3.add(unselected);
        p3.add(p1);
        p1.setVisible(false);

        y.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                breakfast.setVisible(true);
                lunch.setVisible(true);
                dinner.setVisible(true);
                cleaning.setVisible(true);
            }
        });
        n.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                breakfast.setVisible(false);
                lunch.setVisible(false);
                dinner.setVisible(false);
                cleaning.setVisible(false);
            }
        });

        /// *************************************************************************************

        for (i = 1; i <= 12; i++) {
            Room room = new Room(i);
            p2.add(room.getButton());
            Color customColor = Color.decode("#181818");
            room.setColorBack(customColor);

            rooms[i - 1] = room;

            room.getButton().addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton sourceButton = (JButton) e.getSource();
                    for (Room i : rooms) {
                        if (i.getButton() == sourceButton) {
                            roomIndex = i.getRoomNum() - 1;
                            break;
                        }

                    }
                    System.out.println(roomIndex);
                    Room room = rooms[roomIndex];
                    RoomState state = room.getRoomState();

                    if (state == RoomState.GREEN) {
                        submit.setVisible(false);
                    } else {
                        submit.setVisible(true);
                    }

                    roomNumber.setText("" + (room.getRoomNum()));
                    roomNumber.setOpaque(false);
                    roomNumber.setForeground(Color.WHITE);
                    roomNumber.setEditable(false);

                    tenantName.setText(room.getTenantName());
                    tenantName.setOpaque(false);
                    tenantName.setForeground(Color.WHITE);

                    contactNumber.setText(room.getContactNum());
                    contactNumber.setOpaque(false);
                    contactNumber.setForeground(Color.WHITE);

                    email.setText(room.getEmail());
                    email.setOpaque(false);
                    email.setForeground(Color.WHITE);

                    JSpinner.DefaultEditor startEditor = (JSpinner.DefaultEditor) dateOccupied.getEditor();
                    startEditor.getTextField().setText(room.getStartDate());
                    dateOccupied.setOpaque(false);
                    dateOccupied.setForeground(Color.WHITE);
                    // editor.getTextField().setEditable(false);

                    JSpinner.DefaultEditor endEditor = (JSpinner.DefaultEditor) lastOccupied.getEditor();
                    JFormattedTextField endField = endEditor.getTextField();
                    endField.setBackground(Color.decode("#1F1F1F"));
                    // endField.paintBorder(Color.decode("#181818"));
                    endField.setForeground(Color.WHITE);
                    // BasicArrowButton upArrowButton = ((BasicSpinnerUI)
                    // lastOccupied.getUI()).getIncrementButton();
                    endEditor.getTextField().setText(room.getLastDate());
                    endEditor.getTextField().setEditable(false);

                    y.setSelected(room.getYes());
                    if (room.getYes() == false) {
                        n.setSelected(true);
                        breakfast.setVisible(false);
                        lunch.setVisible(false);
                        dinner.setVisible(false);
                        cleaning.setVisible(false);
                    } else {
                        breakfast.setVisible(true);
                        lunch.setVisible(true);
                        dinner.setVisible(true);
                        cleaning.setVisible(true);
                    }

                    if (room.getPayStatus() == null) {
                        tenantName.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                        tenantName.setEditable(true);
                        contactNumber.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                        contactNumber.setEditable(true);
                        email.setBorder(BorderFactory.createLineBorder(Color.WHITE));
                        email.setEditable(true);
                        submit.setVisible(true);
                    } else {
                        tenantName.setBorder(new EmptyBorder(getInsets()));
                        tenantName.setEditable(false);
                        contactNumber.setBorder(new EmptyBorder(getInsets()));
                        contactNumber.setEditable(false);
                        email.setBorder(new EmptyBorder(getInsets()));
                        email.setEditable(false);
                        submit.setVisible(false);
                    }

                    breakfast.setSelected(room.getBreakfast());
                    lunch.setSelected(room.getLunch());
                    dinner.setSelected(room.getDinner());
                    cleaning.setSelected(room.getCleaning());

                    LCashBalance.setText("" + room.getCashBalance());
                    LCashBalance.setOpaque(false);
                    LCashBalance.setForeground(Color.WHITE);
                    LCashBalance.setEditable(false);

                    tPaymentPeriod.setText(room.getPayPeriod());
                    tPaymentPeriod.setOpaque(false);
                    tPaymentPeriod.setForeground(Color.WHITE);
                    tPaymentPeriod.setEditable(false);

                    tPaymentStatus.setText(room.getPayStatus());
                    tPaymentStatus.setOpaque(false);
                    tPaymentStatus.setForeground(Color.WHITE);
                    tPaymentStatus.setEditable(false);

                    p1.setSize(1000, 1000);
                    x = !x;
                    unselected.setVisible(!x);
                    p1.setVisible(x);
                }
            });
        }

        p2.setLayout(new GridLayout(4, 3));

        JSplitPane jsp = new JSplitPane(SwingConstants.VERTICAL, p3, p2);
        jsp.setDividerSize(0);
        jsp.setBounds(10, 200, 400, 400);
        jsp.setResizeWeight(2d / 3d);
        jsp.setPreferredSize(new Dimension(1000, 600));

        frame.add(jsp);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        // frame.setUndecorated(true);
        frame.setVisible(true);
    }

    public void updateResult() {
        Date lastDate = (Date) lastOccupied.getValue();
        Date startDate = (Date) dateOccupied.getValue();
        System.out.println(lastDate);
        System.out.println(startDate);
        if (lastDate != null && startDate != null) {
            long diffInMillies = Math.abs(lastDate.getTime() - startDate.getTime());
            long diffInDays = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            long pay = (diffInDays / 30) * 30000;
            LCashBalance.setText("" + pay);
            tPaymentPeriod.setText("" + diffInDays + " days");

            if (diffInDays <= 30) {
                tPaymentStatus.setText("--");
            } else if (diffInDays > 30 && diffInDays < 37) {
                tPaymentStatus.setText("Due");

            } else {
                tPaymentStatus.setText("For Evict");
            }
            System.out.println("inside");
        }
    }
}