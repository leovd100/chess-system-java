package application;

import java.util.InputMismatchException;
import java.util.Scanner;

import boardgame.Board;
import chess.ChessException;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.ChessPositon;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Board boarGame = new Board(8, 8);
		ChessMatch chessmatch = new ChessMatch();
		
		
		while(true) {
			try {
				UI.clearScreen();
				UI.printBoard(chessmatch.getPiece());
				System.out.println();
				System.out.print("Source:  ");
				ChessPositon source = UI.readChessPosition(sc);
				
				
				boolean[][] possibleMoves = chessmatch.possibleMoves(source);
				UI.clearScreen();
				UI.printBoard(chessmatch.getPiece(), possibleMoves);
				
				System.out.println();
				System.out.print("Target:  ");
				ChessPositon target = UI.readChessPosition(sc);

				ChessPiece capuredPiece = chessmatch.performanceChessMove(source, target);
			}catch(ChessException e) {
				
				System.out.println(e.getMessage());
				sc.nextLine();
				
			}catch(InputMismatchException e) {
				
				System.out.println(e.getMessage());
				sc.nextLine();
		
			}
		}
		
		
	}

}
