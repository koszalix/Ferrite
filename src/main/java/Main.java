import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;

import java.awt.*;
import java.awt.event.*;

public class Main extends JFrame {

    private JTabbedPane tabbedPane_Main;
    private JPanel panel1;
    private JPanel panelModel;
    private JPanel panelDamping;
    private JTextField textFieldModelReactancesXL;
    private JComboBox comboBoxModelReactancesXL;
    private JTextField textFieldModelReactancesFXL;
    private JTextField textFieldModelReactancesXC;
    private JComboBox comboBoxModelReactancesFXL;
    private JComboBox comboBoxModelReactancesXC;
    private JTextField textFieldModelReactancesFXC;
    private JComboBox comboBoxModelReactancesFXC;
    private JPanel panelModelReactances;
    private JPanel panelImages;
    private JTextField textFieldModelResistanceRDC;
    private JTextField textFieldModelResistanceRAC;
    private JComboBox comboBoxModelResistanceRAC;
    private JComboBox comboBoxModelResistanceRDC;
    private JTextField textFieldModelValuesCPAR;
    private JTextField textFieldModelValuesLBEAD;
    private JComboBox comboBoxModelValuesLBEAD;
    private JComboBox comboBoxModelValuesCPAR;
    private JPanel panelModelResistance;
    private JPanel panelModelValues;
    private JPanel panelDampingLCValues;
    private JTextField textFieldDampingLCValuesLBEAD;
    private JTextField textFieldDampingLCValuesCDECOUP;
    private JComboBox comboBoxDampingLCValuesLBEAD;
    private JComboBox comboBoxDampingLCValuesCDECOUP;
    private JTextField textFieldDampingLCValuesCDAMP;
    private JComboBox comboBoxDampingLCValuesCDAMP;
    private JTextField textFieldDampingResistorsRMax;
    private JComboBox comboBoxDampingResistorsRMax;
    private JLabel labelModelResistanceRAC;
    private JLabel ModelResistanceRDC;
    private JLabel labelModelValuesLBEAD;
    private JLabel labelModelValuesCPAR;
    private JLabel labelModelReactancesFXC;
    private JLabel labelModelReactancesXC;
    private JLabel labelModelReactancesFXL;
    private JLabel labelModelReactancesXL;
    private JLabel labelDampingLCValuesLBEAD;
    private JLabel labelDampingLCValuesCDECOUP;
    private JLabel labelDampingLCValuesCDAMP;
    private JLabel lablel;
    private JPanel panelDampingResistors;
    private JLabel labelDampingResistorsRMin;
    private JTextField textFieldDampingResistorsRmin;
    private JComboBox comboBoxDampingResistorsRMin;

    private Backend backend;
    private Units units = new Units();

    private String sanitize(String word) {
        if (word.length() <= 0) {
            word = "0";
        }
        return word;
    }

    private void updateBackend() {
        double xl, fxl, xc, fxc, rac, rdc, cdamp, cdecoup;
        xl = Double.parseDouble(sanitize(textFieldModelReactancesXL.getText())) *
                Math.pow(10, units.getResistanceUnitPowerAtIndex(comboBoxModelReactancesXL.getSelectedIndex()));

        fxl = Double.parseDouble(sanitize(textFieldModelReactancesFXL.getText())) *
                Math.pow(10, units.getFrequencyPowerAtIndex(comboBoxModelReactancesFXL.getSelectedIndex()));

        xc = Double.parseDouble(sanitize(textFieldModelReactancesXC.getText())) *
                Math.pow(10, units.getResistanceUnitPowerAtIndex(comboBoxModelReactancesXC.getSelectedIndex()));

        fxc = Double.parseDouble(sanitize(textFieldModelReactancesFXC.getText())) *
                Math.pow(10, units.getFrequencyPowerAtIndex(comboBoxModelReactancesFXC.getSelectedIndex()));

        rac = Double.parseDouble(sanitize(textFieldModelResistanceRAC.getText())) *
                Math.pow(10, units.getResistanceUnitPowerAtIndex(comboBoxModelResistanceRAC.getSelectedIndex()));

        rdc = Double.parseDouble(sanitize(textFieldModelResistanceRAC.getText())) *
                Math.pow(10, units.getResistanceUnitPowerAtIndex(comboBoxModelResistanceRDC.getSelectedIndex()));

        cdamp = Double.parseDouble(sanitize(textFieldDampingLCValuesCDAMP.getText())) *
                Math.pow(10, units.getCapacitanceUnitPowerAtIndex(comboBoxDampingLCValuesCDAMP.getSelectedIndex()));

        cdecoup = Double.parseDouble(sanitize(textFieldDampingLCValuesCDECOUP.getText())) *
                Math.pow(10, units.getCapacitanceUnitPowerAtIndex(comboBoxDampingLCValuesCDECOUP.getSelectedIndex()));

        backend.setXl(xl);
        backend.setFxl(fxl);
        backend.setXc(xc);
        backend.setFxc(fxc);
        backend.setRa(rac);
        backend.setRdc(rdc);
        backend.setCdamp(cdamp);
        backend.setCdecoup(cdecoup);

        backend.calculate();
    }

    private void setUnits() {
        for (int idx = 0; idx < units.getResistanceUnitCount(); idx++) {
            comboBoxDampingResistorsRMin.addItem(units.getResistanceUnitNameAtIndex(idx));
            comboBoxDampingResistorsRMax.addItem(units.getResistanceUnitNameAtIndex(idx));
            comboBoxModelResistanceRAC.addItem(units.getResistanceUnitNameAtIndex(idx));
            comboBoxModelResistanceRDC.addItem(units.getResistanceUnitNameAtIndex(idx));
            comboBoxModelReactancesXC.addItem(units.getResistanceUnitNameAtIndex(idx));
            comboBoxModelReactancesXL.addItem(units.getResistanceUnitNameAtIndex(idx));
        }
        for (int idx = 0; idx < units.getFrequencyUnitCount(); idx++) {
            comboBoxModelReactancesFXC.addItem(units.getFrequencyUnitNameAtIndex(idx));
            comboBoxModelReactancesFXL.addItem(units.getFrequencyUnitNameAtIndex(idx));
        }
        for (int idx = 0; idx < units.getCapacitanceUnitCount(); idx++) {
            comboBoxDampingLCValuesCDAMP.addItem(units.getCapacitanceUnitNameAtIndex(idx));
            comboBoxDampingLCValuesCDECOUP.addItem(units.getCapacitanceUnitNameAtIndex(idx));
            comboBoxModelValuesCPAR.addItem(units.getCapacitanceUnitNameAtIndex(idx));
        }

        for (int idx = 0; idx < units.getInductanceUnitCount(); idx++) {
            comboBoxDampingLCValuesLBEAD.addItem(units.getInductanceUnitNameAtIndex(idx));
            comboBoxModelValuesLBEAD.addItem(units.getInductanceUnitNameAtIndex(idx));
        }
    }


    public Main() {

        backend = new Backend();

        setContentPane(panel1);
        setTitle("Ferrite");
        setSize(500, 300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        setUnits();

        setVisible(true);

        System.out.println("kk");
        textFieldModelReactancesXL.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateBackend();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateBackend();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateBackend();
            }
        });

        textFieldModelReactancesFXL.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateBackend();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                updateBackend();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateBackend();
            }

        });

        textFieldModelReactancesXC.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateBackend();
            }


            @Override
            public void removeUpdate(DocumentEvent e) {
                updateBackend();
            }


            @Override
            public void changedUpdate(DocumentEvent e) {
                updateBackend();
            }

        });

        textFieldModelReactancesFXC.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateBackend();
            }


            @Override
            public void removeUpdate(DocumentEvent e) {
                updateBackend();
            }


            @Override
            public void changedUpdate(DocumentEvent e) {
                updateBackend();
            }

        });

        textFieldModelResistanceRAC.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateBackend();
            }


            @Override
            public void removeUpdate(DocumentEvent e) {
                updateBackend();
            }


            @Override
            public void changedUpdate(DocumentEvent e) {
                updateBackend();
            }

        });

        textFieldModelResistanceRAC.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                updateBackend();
            }


            @Override
            public void removeUpdate(DocumentEvent e) {
                updateBackend();
            }


            @Override
            public void changedUpdate(DocumentEvent e) {
                updateBackend();
            }

        });

        textFieldDampingLCValuesCDAMP.getDocument().addDocumentListener(new DocumentListener() {


            @Override
            public void insertUpdate(DocumentEvent e) {
                updateBackend();
            }


            @Override
            public void removeUpdate(DocumentEvent e) {
                updateBackend();
            }


            @Override
            public void changedUpdate(DocumentEvent e) {
                updateBackend();
            }

        });

        textFieldDampingLCValuesCDECOUP.getDocument().addDocumentListener(new DocumentListener() {


            @Override
            public void insertUpdate(DocumentEvent e) {
                updateBackend();
            }


            @Override
            public void removeUpdate(DocumentEvent e) {
                updateBackend();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                updateBackend();
            }

        });

        comboBoxModelReactancesXL.addActionListener(e -> {
            updateBackend();
        });

        comboBoxModelReactancesFXL.addActionListener(e -> {
            updateBackend();
        });

        comboBoxModelReactancesXC.addActionListener(e -> {
            updateBackend();
        });

        comboBoxModelReactancesFXC.addActionListener(e -> {
            updateBackend();
        });

        comboBoxModelResistanceRDC.addActionListener(e -> {
            updateBackend();
        });

        comboBoxModelResistanceRAC.addActionListener(e -> {
            updateBackend();
        });

        comboBoxDampingLCValuesCDECOUP.addActionListener(e -> {
            updateBackend();
        });

        comboBoxDampingLCValuesCDAMP.addActionListener(e -> {
            updateBackend();
        });

        backend.addActionListener(e -> {
            double lbead, cpar, rdamp_max, rdamp_min;

            lbead = backend.getLbead();
            cpar = backend.getCpar();
            rdamp_max = backend.getRdamp_max();
            rdamp_min = backend.getRdamp_min();

            textFieldModelValuesLBEAD.setText(Double.toString(lbead));
            textFieldDampingLCValuesLBEAD.setText(Double.toString(lbead));

            textFieldModelValuesCPAR.setText(Double.toString(cpar));

            textFieldDampingResistorsRMax.setText(Double.toString(rdamp_max));
            textFieldDampingResistorsRmin.setText(Double.toString(rdamp_min));

        });
    }

    public static void main(String[] args) {
        Main main = new Main();
    }

    {
// GUI initializer generated by IntelliJ IDEA GUI Designer
// >>> IMPORTANT!! <<<
// DO NOT EDIT OR ADD ANY CODE HERE!
        $$$setupUI$$$();
    }

    /**
     * Method generated by IntelliJ IDEA GUI Designer
     * >>> IMPORTANT!! <<<
     * DO NOT edit this method OR call it in your code!
     *
     * @noinspection ALL
     */
    private void $$$setupUI$$$() {
        panel1 = new JPanel();
        panel1.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane_Main = new JTabbedPane();
        panel1.add(tabbedPane_Main, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(200, 200), null, 0, false));
        panelModel = new JPanel();
        panelModel.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane_Main.addTab("Model", panelModel);
        panelImages = new JPanel();
        panelImages.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 2, new Insets(0, 0, 0, 0), -1, -1));
        panelModel.add(panelImages, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 3, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer1 = new com.intellij.uiDesigner.core.Spacer();
        panelImages.add(spacer1, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, 1, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer2 = new com.intellij.uiDesigner.core.Spacer();
        panelImages.add(spacer2, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        final JLabel label1 = new JLabel();
        label1.setText("Label");
        panelImages.add(label1, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        panelModelResistance = new JPanel();
        panelModelResistance.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 5, new Insets(0, 0, 0, 0), 0, 0));
        panelModel.add(panelModelResistance, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        labelModelResistanceRAC = new JLabel();
        labelModelResistanceRAC.setText(" RAC ");
        panelModelResistance.add(labelModelResistanceRAC, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        ModelResistanceRDC = new JLabel();
        ModelResistanceRDC.setText(" RDC ");
        panelModelResistance.add(ModelResistanceRDC, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textFieldModelResistanceRDC = new JTextField();
        panelModelResistance.add(textFieldModelResistanceRDC, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
        textFieldModelResistanceRAC = new JTextField();
        panelModelResistance.add(textFieldModelResistanceRAC, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
        comboBoxModelResistanceRAC = new JComboBox();
        panelModelResistance.add(comboBoxModelResistanceRAC, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        comboBoxModelResistanceRDC = new JComboBox();
        panelModelResistance.add(comboBoxModelResistanceRDC, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer3 = new com.intellij.uiDesigner.core.Spacer();
        panelModelResistance.add(spacer3, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, new Dimension(28, 11), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer4 = new com.intellij.uiDesigner.core.Spacer();
        panelModelResistance.add(spacer4, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, new Dimension(10, -1), null, 0, false));
        panelModelValues = new JPanel();
        panelModelValues.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 5, new Insets(0, 0, 0, 0), 0, 0));
        panelModel.add(panelModelValues, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        labelModelValuesLBEAD = new JLabel();
        labelModelValuesLBEAD.setText("L_BEAD");
        panelModelValues.add(labelModelValuesLBEAD, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        labelModelValuesCPAR = new JLabel();
        labelModelValuesCPAR.setText("C_PAR");
        panelModelValues.add(labelModelValuesCPAR, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textFieldModelValuesCPAR = new JTextField();
        panelModelValues.add(textFieldModelValuesCPAR, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
        textFieldModelValuesLBEAD = new JTextField();
        panelModelValues.add(textFieldModelValuesLBEAD, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
        comboBoxModelValuesLBEAD = new JComboBox();
        panelModelValues.add(comboBoxModelValuesLBEAD, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        comboBoxModelValuesCPAR = new JComboBox();
        panelModelValues.add(comboBoxModelValuesCPAR, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer5 = new com.intellij.uiDesigner.core.Spacer();
        panelModelValues.add(spacer5, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, new Dimension(15, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer6 = new com.intellij.uiDesigner.core.Spacer();
        panelModelValues.add(spacer6, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, new Dimension(10, -1), null, 0, false));
        panelModelReactances = new JPanel();
        panelModelReactances.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(4, 5, new Insets(0, 0, 0, 0), 0, 0));
        panelModel.add(panelModelReactances, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        comboBoxModelReactancesFXC = new JComboBox();
        panelModelReactances.add(comboBoxModelReactancesFXC, new com.intellij.uiDesigner.core.GridConstraints(3, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        labelModelReactancesFXC = new JLabel();
        labelModelReactancesFXC.setText("f @ XC");
        panelModelReactances.add(labelModelReactancesFXC, new com.intellij.uiDesigner.core.GridConstraints(3, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textFieldModelReactancesFXC = new JTextField();
        panelModelReactances.add(textFieldModelReactancesFXC, new com.intellij.uiDesigner.core.GridConstraints(3, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
        labelModelReactancesXC = new JLabel();
        labelModelReactancesXC.setText("XC");
        panelModelReactances.add(labelModelReactancesXC, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textFieldModelReactancesXC = new JTextField();
        panelModelReactances.add(textFieldModelReactancesXC, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
        comboBoxModelReactancesXC = new JComboBox();
        panelModelReactances.add(comboBoxModelReactancesXC, new com.intellij.uiDesigner.core.GridConstraints(2, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        labelModelReactancesFXL = new JLabel();
        labelModelReactancesFXL.setText("f @ XL");
        panelModelReactances.add(labelModelReactancesFXL, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textFieldModelReactancesFXL = new JTextField();
        panelModelReactances.add(textFieldModelReactancesFXL, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
        comboBoxModelReactancesFXL = new JComboBox();
        panelModelReactances.add(comboBoxModelReactancesFXL, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        labelModelReactancesXL = new JLabel();
        labelModelReactancesXL.setText("XL");
        panelModelReactances.add(labelModelReactancesXL, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        comboBoxModelReactancesXL = new JComboBox();
        panelModelReactances.add(comboBoxModelReactancesXL, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textFieldModelReactancesXL = new JTextField();
        panelModelReactances.add(textFieldModelReactancesXL, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(150, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer7 = new com.intellij.uiDesigner.core.Spacer();
        panelModelReactances.add(spacer7, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, 1, new Dimension(1, -1), new Dimension(21, -1), new Dimension(20, -1), 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer8 = new com.intellij.uiDesigner.core.Spacer();
        panelModelReactances.add(spacer8, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, new Dimension(10, -1), null, 0, false));
        panelDamping = new JPanel();
        panelDamping.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 2, new Insets(0, 0, 0, 0), -1, -1));
        tabbedPane_Main.addTab("Damping", panelDamping);
        panelDampingLCValues = new JPanel();
        panelDampingLCValues.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(3, 5, new Insets(0, 0, 0, 0), -1, -1));
        panelDamping.add(panelDampingLCValues, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        labelDampingLCValuesLBEAD = new JLabel();
        labelDampingLCValuesLBEAD.setText("L_BEAD");
        panelDampingLCValues.add(labelDampingLCValuesLBEAD, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        labelDampingLCValuesCDECOUP = new JLabel();
        labelDampingLCValuesCDECOUP.setText("C_DECOUP");
        panelDampingLCValues.add(labelDampingLCValuesCDECOUP, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        textFieldDampingLCValuesLBEAD = new JTextField();
        panelDampingLCValues.add(textFieldDampingLCValuesLBEAD, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        textFieldDampingLCValuesCDECOUP = new JTextField();
        panelDampingLCValues.add(textFieldDampingLCValuesCDECOUP, new com.intellij.uiDesigner.core.GridConstraints(1, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        comboBoxDampingLCValuesLBEAD = new JComboBox();
        panelDampingLCValues.add(comboBoxDampingLCValuesLBEAD, new com.intellij.uiDesigner.core.GridConstraints(0, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        comboBoxDampingLCValuesCDECOUP = new JComboBox();
        panelDampingLCValues.add(comboBoxDampingLCValuesCDECOUP, new com.intellij.uiDesigner.core.GridConstraints(1, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        labelDampingLCValuesCDAMP = new JLabel();
        labelDampingLCValuesCDAMP.setText("C_DAMP");
        panelDampingLCValues.add(labelDampingLCValuesCDAMP, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldDampingLCValuesCDAMP = new JTextField();
        panelDampingLCValues.add(textFieldDampingLCValuesCDAMP, new com.intellij.uiDesigner.core.GridConstraints(2, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        comboBoxDampingLCValuesCDAMP = new JComboBox();
        panelDampingLCValues.add(comboBoxDampingLCValuesCDAMP, new com.intellij.uiDesigner.core.GridConstraints(2, 4, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer9 = new com.intellij.uiDesigner.core.Spacer();
        panelDampingLCValues.add(spacer9, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, new Dimension(17, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer10 = new com.intellij.uiDesigner.core.Spacer();
        panelDampingLCValues.add(spacer10, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, new Dimension(10, -1), null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer11 = new com.intellij.uiDesigner.core.Spacer();
        panelDamping.add(spacer11, new com.intellij.uiDesigner.core.GridConstraints(2, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_VERTICAL, 1, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
        panelDampingResistors = new JPanel();
        panelDampingResistors.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(2, 4, new Insets(0, 0, 0, 0), -1, -1));
        panelDamping.add(panelDampingResistors, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 2, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
        lablel = new JLabel();
        lablel.setText("R_DAMP_MAX");
        panelDampingResistors.add(lablel, new com.intellij.uiDesigner.core.GridConstraints(0, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldDampingResistorsRMax = new JTextField();
        panelDampingResistors.add(textFieldDampingResistorsRMax, new com.intellij.uiDesigner.core.GridConstraints(0, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        comboBoxDampingResistorsRMax = new JComboBox();
        panelDampingResistors.add(comboBoxDampingResistorsRMax, new com.intellij.uiDesigner.core.GridConstraints(0, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        labelDampingResistorsRMin = new JLabel();
        labelDampingResistorsRMin.setText("R_DAMP_MIN");
        panelDampingResistors.add(labelDampingResistorsRMin, new com.intellij.uiDesigner.core.GridConstraints(1, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_NONE, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        textFieldDampingResistorsRmin = new JTextField();
        panelDampingResistors.add(textFieldDampingResistorsRmin, new com.intellij.uiDesigner.core.GridConstraints(1, 1, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_WANT_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, new Dimension(150, -1), null, 0, false));
        comboBoxDampingResistorsRMin = new JComboBox();
        panelDampingResistors.add(comboBoxDampingResistorsRMin, new com.intellij.uiDesigner.core.GridConstraints(1, 3, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_WEST, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_FIXED, null, null, null, 0, false));
        final com.intellij.uiDesigner.core.Spacer spacer12 = new com.intellij.uiDesigner.core.Spacer();
        panelDampingResistors.add(spacer12, new com.intellij.uiDesigner.core.GridConstraints(0, 2, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_HORIZONTAL, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, 1, null, new Dimension(10, -1), null, 0, false));
        final JPanel panel2 = new JPanel();
        panel2.setLayout(new com.intellij.uiDesigner.core.GridLayoutManager(1, 1, new Insets(0, 0, 0, 0), -1, -1));
        panelDamping.add(panel2, new com.intellij.uiDesigner.core.GridConstraints(2, 0, 1, 1, com.intellij.uiDesigner.core.GridConstraints.ANCHOR_CENTER, com.intellij.uiDesigner.core.GridConstraints.FILL_BOTH, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_SHRINK | com.intellij.uiDesigner.core.GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));
    }

    /**
     * @noinspection ALL
     */
    public JComponent $$$getRootComponent$$$() {
        return panel1;
    }

}
