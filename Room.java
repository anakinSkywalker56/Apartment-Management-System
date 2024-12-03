import javax.swing.*;
// import javax.swing.BorderFactory;
import java.awt.*;
import java.util.Date;

public class Room {
    private JButton button;
    private int roomNum;
    private String tenantName;
    private String contactNum;
    private String email;
    private String startOccupied;
    private String lastOccupied;
    private double cashBalance;
    private String payPeriod;
    private String paymentStatus;
    private RoomState roomState;
    private boolean yes;
    private boolean breakfast;
    private boolean lunch;
    private boolean dinner;
    private boolean cleaning;

    public Room(int num) {
        this.button = new JButton("" + num);
        this.button.setFont(new Font("Arial", Font.PLAIN, 200));
        this.button.setPreferredSize(new Dimension(300, 300));
        // this.button.setFocusPainted(false);
        // this.button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.roomNum = num;
    }

    public JButton getButton() {
        return this.button;
    }

    public void setColorBack(Color color) {
        // Border empty = BorderFactory.createLineBorder(Color.BLACK);
        // this.button.setBorder(empty);
        this.button.setBackground(color);
    }

    public void setColorFront(Color color) {
        this.button.setForeground(color);
    }

    public int getRoomNum() {
        return this.roomNum;
    }

    public String getTenantName() {
        return this.tenantName;
    }

    public String getContactNum() {
        return this.contactNum;
    }

    public String getEmail() {
        return this.email;
    }

    public String getStartDate() {
        return this.startOccupied;
    }

    public String getLastDate() {
        return this.lastOccupied;
    }

    public double getCashBalance() {
        return this.cashBalance;
    }

    public String getPayPeriod() {
        return this.payPeriod;
    }

    public String getPayStatus() {
        return this.paymentStatus;
    }

    public void setRoomDetails(
            String tenantName,
            String contactNum,
            String email,
            String startOccupied,
            String lastOccupied,
            double cashBalance,
            String payPeriod,
            String paymentStatus,
            boolean yes,
            boolean breakfast,
            boolean lunch,
            boolean dinner,
            boolean cleaning) {

        this.tenantName = tenantName;
        this.contactNum = contactNum;
        this.email = email;
        this.startOccupied = startOccupied;
        this.lastOccupied = lastOccupied;
        this.cashBalance = cashBalance;
        this.payPeriod = payPeriod;
        this.paymentStatus = paymentStatus;

        this.yes = yes;
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.dinner = dinner;
        this.cleaning = cleaning;
    }

    public void setRoomState(RoomState roomState) {
        this.roomState = roomState;
    }

    public RoomState getRoomState() {
        return this.roomState;
    }

    public boolean getYes() {
        return this.yes;
    }

    public boolean getBreakfast() {
        return this.breakfast;
    }

    public boolean getLunch() {
        return this.lunch;
    }

    public boolean getDinner() {
        return this.dinner;
    }

    public boolean getCleaning() {
        return this.cleaning;
    }
}