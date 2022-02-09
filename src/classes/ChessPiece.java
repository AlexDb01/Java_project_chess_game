/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classes;
import gui.*;

/**
 *
 * @author alexa
 */
public abstract class ChessPiece {

    private Field field;
    private boolean isBlack;
    
    public ChessPiece(Field field, boolean isBlack){
        this.field = field;
        this.isBlack = isBlack;
    }
    
    public Field getField(){
        return field;
    }
    
    public boolean getIsBlack(){
        return isBlack;
    }
    
    public void setField(Field field){
        this.field = field;
        field.getBoard().endOfMove(this);
    }
    
    public abstract boolean isMoveOk(Field field);
}
