/*
 * Copyright (C) ExBin Project
 *
 * This application or library is free software: you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the License,
 * or (at your option) any later version.
 *
 * This application or library is distributed in the hope that it will be
 * useful, but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along this application.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.exbin.framework.deltahex.panel;

import org.exbin.framework.gui.utils.LanguageUtils;
import org.exbin.framework.gui.utils.WindowUtils;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.text.ParseException;
import java.util.ResourceBundle;

/**
 * Go-to position panel for hexadecimal editor.
 *
 * @version 0.2.0 2016/12/30
 * @author ExBin Project (http://exbin.org)
 */
public class GoToHexPanel extends javax.swing.JPanel {

    private final java.util.ResourceBundle resourceBundle = LanguageUtils.getResourceBundleByClass(GoToHexPanel.class);

    private long cursorPosition;
    private long maxPosition;
    private GoToMode goToMode = GoToMode.ABSOLUTE;

    public GoToHexPanel() {
        initComponents();

        // Spinner selection workaround from http://forums.sun.com/thread.jspa?threadID=409748&forumID=57
        ((JSpinner.DefaultEditor) positionSpinner.getEditor()).getTextField().addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (e.getSource() instanceof JTextComponent) {
                    final JTextComponent textComponent = ((JTextComponent) e.getSource());
                    SwingUtilities.invokeLater(new Runnable() {
                        @Override
                        public void run() {
                            textComponent.selectAll();
                        }
                    });
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        positionTypeButtonGroup = new javax.swing.ButtonGroup();
        currentPositionLabel = new javax.swing.JLabel();
        currentPositionTextField = new javax.swing.JTextField();
        targetPositionLabel = new javax.swing.JLabel();
        targetPositionTextField = new javax.swing.JTextField();
        goToPanel = new javax.swing.JPanel();
        absoluteRadioButton = new javax.swing.JRadioButton();
        relativeRadioButton = new javax.swing.JRadioButton();
        decimalPositionLabel = new javax.swing.JLabel();
        positionSpinner = new javax.swing.JSpinner();

        currentPositionLabel.setText(resourceBundle.getString("GoToHexDialog.currentPositionLabel.text")); // NOI18N

        currentPositionTextField.setEditable(false);

        targetPositionLabel.setText(resourceBundle.getString("GoToHexDialog.targetPositionLabel.text")); // NOI18N

        targetPositionTextField.setEditable(false);
        targetPositionTextField.setText("0");

        goToPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(resourceBundle.getString("GoToHexDialog.goToPanel.border.title"))); // NOI18N

        positionTypeButtonGroup.add(absoluteRadioButton);
        absoluteRadioButton.setSelected(true);
        absoluteRadioButton.setText(resourceBundle.getString("GoToHexDialog.absoluteRadioButton.text")); // NOI18N
        absoluteRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                absoluteRadioButtonActionPerformed(evt);
            }
        });

        positionTypeButtonGroup.add(relativeRadioButton);
        relativeRadioButton.setText(resourceBundle.getString("GoToHexDialog.relativeRadioButton.text")); // NOI18N
        relativeRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                relativeRadioButtonActionPerformed(evt);
            }
        });

        decimalPositionLabel.setText(resourceBundle.getString("jumpLineLabel.text")); // NOI18N

        positionSpinner.setModel(new javax.swing.SpinnerNumberModel(Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(1L)));
        positionSpinner.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                positionSpinnerStateChanged(evt);
            }
        });

        javax.swing.GroupLayout goToPanelLayout = new javax.swing.GroupLayout(goToPanel);
        goToPanel.setLayout(goToPanelLayout);
        goToPanelLayout.setHorizontalGroup(
            goToPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(goToPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(goToPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(positionSpinner)
                    .addGroup(goToPanelLayout.createSequentialGroup()
                        .addComponent(decimalPositionLabel)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addComponent(absoluteRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
            .addComponent(relativeRadioButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        goToPanelLayout.setVerticalGroup(
            goToPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(goToPanelLayout.createSequentialGroup()
                .addComponent(absoluteRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(relativeRadioButton, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(decimalPositionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(positionSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(currentPositionTextField)
                    .addComponent(goToPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(targetPositionTextField)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(currentPositionLabel)
                            .addComponent(targetPositionLabel))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(currentPositionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(currentPositionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(goToPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(targetPositionLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(targetPositionTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void absoluteRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_absoluteRadioButtonActionPerformed
        if (goToMode == GoToMode.RELATIVE && absoluteRadioButton.isSelected()) {
            goToMode = GoToMode.ABSOLUTE;
            long currentValue = ((Long) positionSpinner.getValue());
            positionSpinner.setValue(0l);
            ((SpinnerNumberModel) positionSpinner.getModel()).setMinimum(0l);
            ((SpinnerNumberModel) positionSpinner.getModel()).setMaximum(maxPosition);
            positionSpinner.setValue(cursorPosition + currentValue);
            positionSpinner.revalidate();
            updateTargetPosition();
        }
    }//GEN-LAST:event_absoluteRadioButtonActionPerformed

    private void relativeRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_relativeRadioButtonActionPerformed
        if (goToMode == GoToMode.ABSOLUTE && relativeRadioButton.isSelected()) {
            goToMode = GoToMode.RELATIVE;
            long currentValue = ((Long) positionSpinner.getValue());
            positionSpinner.setValue(0l);
            ((SpinnerNumberModel) positionSpinner.getModel()).setMinimum(-cursorPosition);
            ((SpinnerNumberModel) positionSpinner.getModel()).setMaximum(maxPosition - cursorPosition);
            positionSpinner.setValue(currentValue - cursorPosition);
            positionSpinner.revalidate();
            updateTargetPosition();
        }
    }//GEN-LAST:event_relativeRadioButtonActionPerformed

    private void positionSpinnerStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_positionSpinnerStateChanged
        updateTargetPosition();
    }//GEN-LAST:event_positionSpinnerStateChanged

    private void updateTargetPosition() {
        targetPositionTextField.setText(String.valueOf(getGoToPosition()));
    }

    public void initFocus() {
        ((JSpinner.DefaultEditor) positionSpinner.getEditor()).getTextField().requestFocusInWindow();
    }

    public JComponent getInitFocusComponent() {
        return ((JSpinner.DefaultEditor) positionSpinner.getEditor()).getTextField();
    }

    public long getGoToPosition() {
        long value = (Long) positionSpinner.getValue();
        if (goToMode == GoToMode.ABSOLUTE) {
            return value;
        } else {
            return cursorPosition + value;
        }
    }

    public long getCursorPosition() {
        return cursorPosition;
    }

    public void setCursorPosition(long cursorPosition) {
        this.cursorPosition = cursorPosition;
        positionSpinner.setValue(cursorPosition);
        currentPositionTextField.setText(String.valueOf(cursorPosition));
    }

    public void setMaxPosition(long maxPosition) {
        this.maxPosition = maxPosition;
        ((SpinnerNumberModel) positionSpinner.getModel()).setMaximum(maxPosition);
        positionSpinner.revalidate();
        updateTargetPosition();
    }

    public void setSelected() {
        positionSpinner.requestFocusInWindow();
    }

    public ResourceBundle getResourceBundle() {
        return resourceBundle;
    }

    /**
     * Test method for this panel.
     *
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        WindowUtils.invokeDialog(new GoToHexPanel());
    }

    public void acceptInput() {
        try {
            positionSpinner.commitEdit();
        } catch (ParseException ex) {
            // Ignore parse exception
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton absoluteRadioButton;
    private javax.swing.JLabel currentPositionLabel;
    private javax.swing.JTextField currentPositionTextField;
    private javax.swing.JLabel decimalPositionLabel;
    private javax.swing.JPanel goToPanel;
    private javax.swing.JSpinner positionSpinner;
    private javax.swing.ButtonGroup positionTypeButtonGroup;
    private javax.swing.JRadioButton relativeRadioButton;
    private javax.swing.JLabel targetPositionLabel;
    private javax.swing.JTextField targetPositionTextField;
    // End of variables declaration//GEN-END:variables

    public enum GoToMode {
        ABSOLUTE, RELATIVE
    }
}
