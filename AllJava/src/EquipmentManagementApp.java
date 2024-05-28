import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EquipmentManagementApp extends JFrame {
    private JTextField userIdField;
    private JPasswordField passwordField;
    private JButton loginButton;

    private JPanel welcomePanel;
    private JButton equipmentManagerButton;
    private JButton taskSchedulerButton;

    private DefaultListModel<String> equipmentListModel;
    private JList<String> equipmentList;
    private JTextField equipmentNameField;
    private JButton addEquipmentButton;
    private JButton removeEquipmentButton;
    private JComboBox<String> maintenanceTasksComboBox;
    private JButton scheduleTaskButton;
    private JTextArea taskStatusTextArea;
    private JComboBox<String> userComboBox;
    private JButton addUserButton;
    private JTextField priorityField;

    private Map<String, List<String>> equipmentTasksMap;
    private Map<String, Integer> equipmentPriorityMap;
    private Map<String, String> userAccounts;

    public EquipmentManagementApp() {
        userIdField = new JTextField();
        passwordField = new JPasswordField();
        loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredUserId = userIdField.getText();
                String enteredPassword = new String(passwordField.getPassword());

                if ("EMSO".equals(enteredUserId) && "8810".equals(enteredPassword)) {
                    showWelcomeInterface();
                } else {
                    JOptionPane.showMessageDialog(EquipmentManagementApp.this,
                            "Invalid credentials. Please try again.",
                            "Login Failed", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel loginPanel = new JPanel(new GridLayout(4, 2));
        loginPanel.add(new JLabel("User ID:"));
        loginPanel.add(userIdField);
        loginPanel.add(new JLabel("Password:"));
        loginPanel.add(passwordField);
        loginPanel.add(new JLabel(""));
        loginPanel.add(loginButton);

        setTitle("Equipment Management App - Login");
        setLayout(new BorderLayout());
        add(loginPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(400, 200);
        setVisible(true);
    }

    private void showWelcomeInterface() {
        getContentPane().removeAll();
        repaint();

        welcomePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel welcomeLabel = new JLabel("Welcome to Equipment Management System");
        equipmentManagerButton = new JButton("Equipment Manager");
        taskSchedulerButton = new JButton("Task Scheduler");

        equipmentManagerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEquipmentManagerInterface();
            }
        });

        taskSchedulerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showTaskSchedulerInterface();
            }
        });

        welcomePanel.add(welcomeLabel);
        welcomePanel.add(equipmentManagerButton);
        welcomePanel.add(taskSchedulerButton);

        setTitle("Equipment Management App - Welcome");
        setLayout(new BorderLayout());
        add(welcomePanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(600, 200);
        setVisible(true);
    }

    private void showEquipmentManagerInterface() {
        getContentPane().removeAll();
        repaint();

        equipmentListModel = new DefaultListModel<>();
        equipmentList = new JList<>(equipmentListModel);
        equipmentNameField = new JTextField(15);
        addEquipmentButton = new JButton("Add Equipment");
        removeEquipmentButton = new JButton("Remove Equipment");
        priorityField = new JTextField(5);

        equipmentTasksMap = new HashMap<>();
        equipmentPriorityMap = new HashMap<>();

        setLayout(new BorderLayout());
        add(createEquipmentPanel(), BorderLayout.WEST);

        setTitle("Equipment Management App - Equipment Manager");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void showTaskSchedulerInterface() {
        getContentPane().removeAll();
        repaint();

        maintenanceTasksComboBox = new JComboBox<>(new String[]{"Inspect", "Lubricate", "Calibrate"});
        scheduleTaskButton = new JButton("Schedule Task");
        taskStatusTextArea = new JTextArea(5, 20);
        userComboBox = new JComboBox<>();
        addUserButton = new JButton("Add User");

        setLayout(new BorderLayout());
        add(createTaskPanel(), BorderLayout.CENTER);

        setTitle("Equipment Management App - Task Scheduler");
        setSize(800, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createEquipmentPanel() {
        JPanel equipmentPanel = new JPanel(new BorderLayout());

        equipmentPanel.add(new JScrollPane(equipmentList), BorderLayout.CENTER);

        JPanel managementPanel = new JPanel(new GridLayout(6, 2));
        managementPanel.add(new JLabel("Equipment Name:"));
        managementPanel.add(equipmentNameField);
        managementPanel.add(new JLabel("Task Priority:"));
        managementPanel.add(priorityField);
        managementPanel.add(addEquipmentButton);
        managementPanel.add(removeEquipmentButton);

        addEquipmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String equipmentName = equipmentNameField.getText();
                if (equipmentName != null && !equipmentName.trim().isEmpty()) {
                    equipmentListModel.addElement(equipmentName);
                    equipmentTasksMap.put(equipmentName, new ArrayList<>());
                    equipmentPriorityMap.put(equipmentName, Integer.parseInt(priorityField.getText()));
                    equipmentNameField.setText("");
                    priorityField.setText("");
                }
            }
        });

        removeEquipmentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedIndex = equipmentList.getSelectedIndex();
                if (selectedIndex != -1) {
                    String removedEquipment = equipmentListModel.remove(selectedIndex);
                    equipmentTasksMap.remove(removedEquipment);
                    equipmentPriorityMap.remove(removedEquipment);
                }
            }
        });

        equipmentPanel.add(managementPanel, BorderLayout.SOUTH);

        return equipmentPanel;
    }

    private JPanel createTaskPanel() {
        JPanel taskPanel = new JPanel(new BorderLayout());

        JPanel taskManagementPanel = new JPanel(new GridLayout(4, 1));
        taskManagementPanel.add(new JLabel("Select Task:"));
        taskManagementPanel.add(maintenanceTasksComboBox);
        taskManagementPanel.add(scheduleTaskButton);

        scheduleTaskButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedEquipment = equipmentList.getSelectedValue();
                if (selectedEquipment != null) {
                    String selectedTask = (String) maintenanceTasksComboBox.getSelectedItem();
                    equipmentTasksMap.get(selectedEquipment).add(selectedTask);
                    updateTaskStatus(selectedEquipment);
                } else {
                    JOptionPane.showMessageDialog(null, "Select equipment before scheduling a task.");
                }
            }
        });

        taskPanel.add(taskManagementPanel, BorderLayout.WEST);

        taskPanel.add(new JScrollPane(taskStatusTextArea), BorderLayout.CENTER);

        equipmentList.addListSelectionListener(e -> {
            String selectedEquipment = equipmentList.getSelectedValue();
            if (selectedEquipment != null) {
                updateTaskStatus(selectedEquipment);
            }
        });

        return taskPanel;
    }

    private void updateTaskStatus(String selectedEquipment) {
        List<String> tasks = equipmentTasksMap.get(selectedEquipment);
        StringBuilder status = new StringBuilder("Task Status for " + selectedEquipment + ":\n");
        for (String task : tasks) {
            status.append(task).append("\n");
        }
        taskStatusTextArea.setText(status.toString());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EquipmentManagementApp());
    }
}
