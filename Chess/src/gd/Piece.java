/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gd;

/**
 *
 * @author dasg
 */
public abstract class Piece {
	
	public String color;
	public boolean hasMoved;
	public boolean ep_able;
	
	/**
	 * Gets the color
	 * @return color of the piece
	 */
	public abstract String getColor();
	
	/**
	 * Moves the piece 
	 * 
	 * @return true if the move was valid or not.
	 */
	public abstract boolean validateMove(Piece[][] board, int currentRow, int currentCol, int newRow, int newCol);

}
