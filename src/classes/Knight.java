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
public class Knight extends ChessPiece{

public Knight(Field field, boolean isBlack) {
        super(field, isBlack);
    }

    public boolean isMoveOk(Field field) {
        int diffX = field.getColumn() - getField().getColumn();
        int diffY = field.getRow() - getField().getRow();

        int dX1;
        int dY1;

        if (diffX < 0) {
            dX1 = diffX * (-1);
        } else {
            dX1 = diffX;
        }

        if (diffY < 0) {
            dY1 = diffY * (-1);
        } else {
            dY1 = diffY;
        }

        if ((dX1 == 2) && (dY1 == 1)) {
            return true;
        } else if ((dY1 == 2) && (dX1 == 1)) {
            return true;
        } else if (Math.abs(diffX) == 0) {
            return false;
        } else {
            return false;
        }
        
    }
}
