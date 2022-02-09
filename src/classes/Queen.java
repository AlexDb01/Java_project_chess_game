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
public class Queen extends ChessPiece{
    
    public Queen(Field field, boolean isBlack){
        super (field, isBlack);
    }
    public boolean isMoveOk(Field field){
        return true;
    }
}
