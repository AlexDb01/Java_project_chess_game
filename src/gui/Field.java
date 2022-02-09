/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;
import classes.*;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author alexa
 */
public class Field extends javax.swing.JButton{
    private Board board;
    private ChessPiece chesspiece = null;
    private boolean isBlack;
    private int row;
    private int column;
    
    public Field(Board board, boolean isBlack, int row, int column){
        this.board = board;
        this.isBlack = isBlack;
        this.row = row;
        this. column = column;
    }
    
    public int getRow(){
        return row;
    }
    
    public int getColumn(){
        return column;
    }
    
    public void setChessPiece(ChessPiece chessPiece){
        this.chesspiece = chessPiece;
        chesspiece.setField(this);
        
        setForeground(chesspiece.getIsBlack() ? Color.black : Color.white);
        Font font = new Font("", Font.PLAIN, 50);
        setFont(font);
        
        if(chessPiece instanceof Pawn){
            setText("\u2659");
        }else if(chessPiece instanceof Queen){
            setText("\u2655");
        }else if(chessPiece instanceof King){
            setText("\u2654");
        }else if(chessPiece instanceof Rook){
            setText("\u2656");
        }else if(chessPiece instanceof Knight){
           setText("\u2658");
        }else if (chessPiece instanceof Bishop){
            setText("\u2657");
        }
    }
    
    public Board getBoard(){
        return board;
    }
    
    public ChessPiece getChessPiece(){
        return chesspiece;
    }
    
    public void movePiece(){
        chesspiece = null;
        board.memorizeStart();
        setText ("");
    }
    

    
}
