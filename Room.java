import java.awt.*;

public class Room extends Cell {
    private int roomNum;
    private String tenantName;
    private String contactNum;
    private String email;
    private String startOccupied;
    private String lastOccupied;
    private String cashBalance;
    private String payPeriod;
    private String paymentStatus;
    private RoomState roomState;
    private boolean yes;
    private boolean breakfast;
    private boolean lunch;
    private boolean dinner;
    private boolean cleaning;
    private long payment;

    public Room(int num) {
        this.setText("" + num);
        this.setFont(new Font("Arial", Font.PLAIN, 200));
        this.setPreferredSize(new Dimension(300, 300));
        this.roomNum = num;
    }

    public void setColorBack(Color color) {
        this.setBackground(color);
    }

    public void setColorFront(Color color) {
        this.setForeground(color);
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

    public void setUpdatedPayments(
            String cashBalance,
            String payPeriod,
            String paymentStatus) {
        this.cashBalance = cashBalance;
        this.payPeriod = payPeriod;
        this.paymentStatus = paymentStatus;
    }

    public String getStartDate() {
        return this.startOccupied;
    }

    public String getLastDate() {
        return this.lastOccupied;
    }

    public String getCashBalance() {
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
            String cashBalance,
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
        if (roomState == RoomState.GREEN) {
            this.setColorFront(Color.GREEN);
        } else if (roomState == RoomState.YELLOW) {
            this.setColorFront(Color.YELLOW);
        } else if (roomState == RoomState.RED) {
            this.setColorFront(Color.RED);
        } else if (roomState == RoomState.UNSELECTED) {
            this.setColorFront(Color.decode("#333333"));
        }
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

    public void setPayment(long payment) {
        this.payment = payment;
    }

    public long getPayment() {
        return this.payment;
    }

    public void setRoomNum(int roomNum) {
        this.roomNum = roomNum;
    }

    public void setContactNum(String contactNum) {
        this.contactNum = contactNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStartDate(String startOccupied) {
        this.startOccupied = startOccupied;
    }

    public void setLastDate(String lastOccupied) {
        this.lastOccupied = lastOccupied;
    }

    public void setCashBalance(String cashBalance) {
        this.cashBalance = cashBalance;
    }

    public void setPayPeriod(String payPeriod) {
        this.payPeriod = payPeriod;
    }

    public void setPayStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }
}