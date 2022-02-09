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
public class Bishop extends ChessPiece {
    
    public Bishop(Field field, boolean isBlack) {
        super(field, isBlack);
    }

    public boolean isMoveOk(Field field) {
        int diffX = field.getColumn() - getField().getColumn();
        int diffY = field.getRow() - getField().getRow();
        
        if(Math.abs(diffX) != Math.abs(diffY)){
            return false;
        }
        return true;
    }
}
