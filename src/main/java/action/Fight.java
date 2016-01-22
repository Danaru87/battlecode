package action;

import model.Piece;
import model.TypePiece;

public class Fight implements Action {

	/**
	 * Determines who wins a fight between two pieces
	 * 
	 * @param attacker
	 * @param defender
	 * @return looser
	 */
	public Piece execute(Piece attacker, Piece defender) {

		if (defender.getType() == TypePiece.DRAGON && attacker.getType() == TypePiece.SLAYER)
		{ // if DRAGON vs SLAYER
			return defender;
		}

		if(defender.getType() == TypePiece.ELF && attacker.getType()==TypePiece.DWARF)
		{
			return null;
		}

		if(defender.getType() == TypePiece.DWARF && attacker.getType()==TypePiece.ELF)
		{
			return null;
		}

		if (defender.getType() != TypePiece.TRAP	&& defender.getType() != TypePiece.TREASURE) {
			return getPieceWhoWin(attacker, defender);
			
		}

		if (defender.getType() == TypePiece.TRAP) {// If defender is a TRAP
			return PieceWinVsTrap(attacker, defender);
		}

		return defender; // TREASURE
	}

	private Piece PieceWinVsTrap(Piece attacker, Piece defender) {
		if (attacker.getType() == TypePiece.DWARF) { // If attacker is a DWARF then he wins
            return defender;
        }
		return attacker;
	}


	private Piece getPieceWhoWin(Piece attacker, Piece defender) {
		if (attacker.getType().getAttackPoints() > defender.getType().getAttackPoints()) { // If attacker wins
            return defender;
        }

		if (attacker.getType().getAttackPoints() < defender.getType().getAttackPoints()) { // If defender looses
            return attacker;
        }
		return null;
	}
}
