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
public class King extends ChessPiece{

    public King(Field field, boolean isBlack) {
        super(field, isBlack);
    }
    
    public boolean isMoveOk(Field field){
        int diffX = field.getColumn() - getField().getColumn();
        int diffY = field.getRow() - getField().getRow();
        
        if(Math.abs(diffX)  > 1 ){
            return false;
        } else if(Math.abs(diffY) > 1){
            return false;
        }
        
        return true;
    }
}
