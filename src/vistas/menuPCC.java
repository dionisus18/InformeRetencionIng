package vistas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import javax.swing.undo.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


public class menuPCC {
    public static void addTo(JTextField txtField) 
    {
        JPopupMenu popup = new JPopupMenu();
        UndoManager undoManager = new UndoManager();
        txtField.getDocument().addUndoableEditListener(undoManager);

        Action undoAction = new AbstractAction("Deshacer") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                if (undoManager.canUndo()) {
                    undoManager.undo();
                }
                else {
                   System.out.println("No Undo Buffer.");
                }
            }
        };

       Action copyAction = new AbstractAction("Copiar") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtField.copy();
            }
        };

        Action cutAction = new AbstractAction("Cortar") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtField.cut();
            }
        };

        Action pasteAction = new AbstractAction("Pegar") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtField.paste();
            }
        };

        Action selectAllAction = new AbstractAction("Seleccionar todo") {
            @Override
            public void actionPerformed(ActionEvent ae) {
                txtField.selectAll();
            }
        };

        cutAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control X"));
        copyAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control C"));
        pasteAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control V"));
        selectAllAction.putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("control A"));

        popup.add (undoAction);
        popup.addSeparator();
        popup.add (cutAction);
        popup.add (copyAction);
        popup.add (pasteAction);
        popup.addSeparator();
        popup.add (selectAllAction);

       txtField.setComponentPopupMenu(popup);
    }
}
