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

public class Queen extends Piece{

	public String color;
	
	public Queen(String color){
		this.color = color;
	}

	@Override
	public boolean validateMove(Piece[][] board, int currentRow, int currentCol, int newRow, int newCol) {
		//A Queen's move is the same as a Rook's or a Bishop's
		return new Rook(color).validateMove(board, currentRow, currentCol, newRow, newCol) || new Bishop(color).validateMove(board, currentRow, currentCol, newRow, newCol);
	}
	
	public String getColor(){
		return this.color;
	}
	
	public String toString(){
		return color.charAt(0) + "Q";
		
	}
	
}
