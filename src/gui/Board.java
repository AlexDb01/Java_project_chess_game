/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import classes.*;
import java.awt.Color;

/**
 *
 * @author alexa
 */
public class Board extends javax.swing.JFrame {

    /**
     * Creates new form Board
     */
    
    private boolean isStartOfMove = true;
    
    private boolean isWhiteMove = true;
    
    public Board() {
        initComponents();
        
        getContentPane().removeAll();
        
        boolean black = true;
        for(int row = 0; row < field.length; row++){
            for(int column = 0; column < field[row].length; column++){
                Field f = new Field(this, black, row, column);
                field[row][column] = f;
                f.addActionListener(fl);

                if(black){
                    f.setBackground(Color.darkGray);
                }else{
                    f.setBackground(Color.lightGray);
                }
                
                //Create Pawn--------------------------------------------
                if(row == 1){
                    f.setChessPiece(new Pawn(f, false));
                }else if(row == 6){
                    f.setChessPiece(new Pawn(f, true));
                }
                //Create Queen--------------------------------------------------
                if (row == 0 && column == 3) {
                    f.setChessPiece(new Queen(f, false));
                } else if (row == 7 && column == 3) {
                    f.setChessPiece(new Queen(f, true));
                }
                //Create King-------------------------------------------------
                if (row == 0 && column == 4) {
                    f.setChessPiece(new King(f, false));
                    ;
                } else if (row == 7 && column == 4) {
                    f.setChessPiece(new King(f, true));
                }
                //Create Rook--------------------------------------------------
                if (row == 0 && column == 0) {
                    f.setChessPiece(new Rook(f, false));
                } else if (row == 7 && column == 0) {
                    f.setChessPiece(new Rook(f, true));
                } else if (row == 7 && column == 7) {
                    f.setChessPiece(new Rook(f, true));
                } else if (row == 0 && column == 7) {
                    f.setChessPiece(new Rook(f, false));
                    ;
                }
                //Create Knight---------------------------------------------
                if (row == 0 && column == 1) {
                    f.setChessPiece(new Knight(f, false));
                } else if (row == 7 && column == 1) {
                    f.setChessPiece(new Knight(f, true));
                } else if (row == 7 && column == 6) {
                    f.setChessPiece(new Knight(f, true));
                } else if (row == 0 && column == 6) {
                    f.setChessPiece(new Knight(f, false));
                }
                //Create Bishop---------------------------------------------
                if (row == 0 && column == 2) {
                    f.setChessPiece(new Bishop(f, false));
                } else if (row == 7 && column == 2) {
                    f.setChessPiece(new Bishop(f, true));
                } else if (row == 7 && column == 5) {
                    f.setChessPiece(new Bishop(f, true));
                } else if (row == 0 && column == 5) {
                    f.setChessPiece(new Bishop(f, false));
                }
                
                jPanel1.add(f);
                black = !black;
            }
            black = !black;  
        }
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);
        pack();
    }
    
    public boolean getStartOfMove(){
        return isStartOfMove;
    }
    
    public void memorizeStart(){
        isStartOfMove = false;
    }

    public void endOfMove(ChessPiece chesspiece){
        isStartOfMove = true;
    }
    
    public boolean isPawnHitOk(ChessPiece chessPiece, Field aimedField){
        int x1 = chessPiece.getField().getColumn();
        int y1 = chessPiece.getField().getRow();
        int x2 = aimedField.getColumn();
        int y2 = aimedField.getRow();
        
        int diffX = x2 - x1;
        int diffY = y2 - y1;
        
        if(chessPiece instanceof Pawn && !chessPiece.getIsBlack() && x1 != 7 && y1 !=7){
            Field nextField = field[y1 + 1][x1 +1];
            if (nextField.getChessPiece() != null && Math.abs(diffX) == Math.abs(diffY)){
                return true;
            }
        }
        
        if (chessPiece instanceof Pawn && !chessPiece.getIsBlack() && x1 != 0 && y1 != 7) {
            Field nextField = field[y1 + 1][x1 - 1];
            if (nextField.getChessPiece() != null && Math.abs(diffX) == Math.abs(diffY)) {
                return true;
            }

        }

        if (chessPiece instanceof Pawn && chessPiece.getIsBlack() && x1 != 7 && y1 != 0) {
            Field nextField = field[y1 - 1][x1 + 1];
            if (nextField.getChessPiece() != null && Math.abs(diffX) == Math.abs(diffY)) {
                return true;
            }

        }

        if (chessPiece instanceof Pawn && chessPiece.getIsBlack() && x1 != 0 && y1 != 0) {
            Field nextField = field[y1 - 1][x1 - 1];
            if (nextField.getChessPiece() != null && Math.abs(diffX) == Math.abs(diffY)) {
                return true;
            }

        }
        
        return false;
    }
    
    public boolean isCPMoveOK(ChessPiece chessPiece, Field aimedField){
        int x1 = chessPiece.getField().getColumn();
        int y1 = chessPiece.getField().getRow();
        int x2 = aimedField.getColumn();
        int y2 = aimedField.getRow();
        
        int diffX = x2 - x1;
        int diffY = y2 - y1;
        
        if (field[x2][y2] == field[x1][y1]) {
            return false;
        }

        if (chessPiece instanceof Pawn && !chessPiece.getIsBlack() && y1 != 7) {
            Field nextField = field[y1 + 1][x1];

            if (nextField.getChessPiece() != null) {
                return false;
            }
        }

        if (chessPiece instanceof Pawn && chessPiece.getIsBlack() && y1 != 0) {
            Field nextField = field[y1 - 1][x1];
            if (nextField.getChessPiece() != null) {
                return false;
            }
        }

        if (!chessPiece.getIsBlack() && aimedField.getChessPiece() != null && !aimedField.getChessPiece().getIsBlack()) {
            return false;
        }

        if (chessPiece.getIsBlack() && aimedField.getChessPiece() != null && aimedField.getChessPiece().getIsBlack()) {
            return false;
        }

        if (chessPiece instanceof Queen) {
            final int skippedFields = Math.max(Math.abs(diffX), Math.abs(diffY)) - 1;
            int dX1 = (int) Math.signum(diffX);
            int dY1 = (int) Math.signum(diffY);

            int row = y1 + dY1;
            int column = x1 + dX1;

            for (int move = 0; move < skippedFields; move++) {
                if (field[row][column].getChessPiece() != null) {
                    return false;
                }
                row += dY1;
                column += dX1;
            }
        }

        if (chessPiece instanceof Rook) {
            final int skippedFields = Math.max(Math.abs(diffX), Math.abs(diffY)) - 1;
            int dX1 = (int) Math.signum(diffX);
            int dY1 = (int) Math.signum(diffY);

            int row = y1 + dY1;
            int column = x1 + dX1;

            for (int move = 0; move < skippedFields; move++) {
                if (field[row][column].getChessPiece() != null) {
                    return false;
                }
                row += dY1;
                column += dX1;
            }
        }

        if (chessPiece instanceof Bishop) {
            final int skippedFields = Math.max(Math.abs(diffX), Math.abs(diffY)) - 1;
            int dX1 = (int) Math.signum(diffX);
            int dY1 = (int) Math.signum(diffY);

            int row = y1 + dY1;
            int column = x1 + dX1;

            for (int move = 0; move < skippedFields; move++) {
                if (field[row][column].getChessPiece() != null) {
                    return false;
                }
                row += dY1;
                column += dX1;
            }
        }
        
        return true;
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(500, 500));

        jPanel1.setLayout(new java.awt.GridLayout(8, 8));
        getContentPane().add(jPanel1, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Board.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Board().setVisible(true);
            }
        });
    }
    
    private Field[][] field = new Field[8][8];

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
    
    private class FieldListener implements java.awt.event.ActionListener{
        
        ChessPiece cp = null;
        
        public void actionPerformed(java.awt.event.ActionEvent evt){
            Field f =  null;
            
           for(int row = 0; row < field.length; row++){
            for(int column = 0; column < field[row].length; column++){
                if(evt.getSource() == field[row][column]){
                    f = field[row][column];
                   
                }
            }
        }
           
           boolean moveMemory = !isWhiteMove;
           
           if(getStartOfMove()){
               if((cp = f.getChessPiece()) != null){
                   if(!cp.getIsBlack() && isWhiteMove){
                       f.movePiece();
                       isWhiteMove = false;
                   }else if(cp.getIsBlack() && isWhiteMove == false){
                       f.movePiece();
                       isWhiteMove = true;
                   }
               }
           }else if(cp.isMoveOk(f) && isCPMoveOK(cp, f) || isPawnHitOk(cp, f)){
               f.setChessPiece(cp);
           }else {
               cp.getField().setChessPiece(cp);
               isWhiteMove = moveMemory;
           }
    }

    }
   FieldListener fl = new FieldListener();
}