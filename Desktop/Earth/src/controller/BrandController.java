/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import view.DlgSearch;

/**
 *
 * @author José Acuña
 */
public class BrandController implements ActionListener, KeyListener {

    private final DlgSearch theView;

    public BrandController(DlgSearch theView) {
        this.theView = theView;
        addListener();
    }

    private void addListener() {
        // ActionListener.
        theView.getSearchButton().addActionListener(this);
        theView.getResetButton().addActionListener(this);
        theView.getAddButton().addActionListener(this);
        theView.getModifyButton().addActionListener(this);
        theView.getRemoveButton().addActionListener(this);
        theView.getViewButton().addActionListener(this);
        theView.getCloseButton().addActionListener(this);
        // KeyListener.
        theView.getIdTextField().addKeyListener(this);
        theView.getNameTextField().addKeyListener(this);
        theView.getSearchButton().addKeyListener(this);
        theView.getResetButton().addKeyListener(this);
        theView.getAddButton().addKeyListener(this);
        theView.getModifyButton().addKeyListener(this);
        theView.getRemoveButton().addKeyListener(this);
        theView.getViewButton().addKeyListener(this);
        theView.getCloseButton().addKeyListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == theView.getResetButton()) {
            theView.setIdTextField("");
            theView.setNameTextField("");
            theView.setQuantityLabel("0");
            theView.getIdTextField().requestFocus();
        }

        if (e.getSource() == theView.getCloseButton()) {
            theView.dispose();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F2) {
            theView.getAddButton().doClick();
            System.out.println("F2");
        }

        if (e.getKeyCode() == KeyEvent.VK_F3) {
            theView.getModifyButton().doClick();
            System.out.println("F3");
        }

        if (e.getKeyCode() == KeyEvent.VK_F8) {
            theView.getRemoveButton().doClick();
            System.out.println("F8");
        }

        if (e.getModifiers() == KeyEvent.CTRL_MASK && e.getKeyCode() == KeyEvent.VK_ENTER) {
            theView.getViewButton().doClick();
            System.out.println("CTRL+ENTER");
        }

        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            theView.getCloseButton().doClick();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

}
