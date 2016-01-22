package action;

import model.Piece;
import model.TypePiece;

import org.junit.Test;

import action.Action;
import action.Fight;

import java.lang.reflect.Type;

import static org.junit.Assert.*;

public class FightTest {

    Piece p1;
    Piece p2;
    Action f = new Fight();

    @Test
    public void testSorceressVsKnight(){
        p1 = new Piece(TypePiece.SORCERESS);
        p2 = new Piece(TypePiece.KNIGHT);
        Action f = new Fight();
        assertEquals(p1, f.execute(p1,p2));
        assertEquals(p1, f.execute(p2,p1));
    }

    @Test
    public void testDragonVsTrap(){
        p1 = new Piece(TypePiece.DRAGON);
        p2 = new Piece(TypePiece.TRAP);
        assertEquals(p1, f.execute(p1,p2));
    }

    @Test
    public void testDwarfVsTrap()
    {
        p1 = new Piece(TypePiece.DWARF);
        p2 = new Piece(TypePiece.TRAP);
        assertEquals(p2, f.execute(p1,p2));
    }

    @Test
    public void testDwarfVsDwarf()
    {
        p1 = new Piece(TypePiece.DWARF);
        p2 = new Piece(TypePiece.DWARF);
        assertEquals(null, f.execute(p1,p2));
    }

    @Test
    public void testDwarfVsTreasure()
    {
        p1 = new Piece(TypePiece.DWARF);
        p2 = new Piece(TypePiece.TREASURE);
        assertEquals(p2, f.execute(p1,p2));
    }

    @Test
    public void testDragonVsSlayer()
    {
        p1 = new Piece(TypePiece.DRAGON);
        p2 = new Piece(TypePiece.SLAYER);
        assertEquals(p1, f.execute(p2,p1));
    }

    @Test
    public void testELFAttackDwarf()
    {
        p1 = new Piece(TypePiece.ELF);
        p2 = new Piece(TypePiece.DWARF);
        assertEquals(null, f.execute(p2, p1));
    }

    @Test
    public void testDwarfAttackElf()
    {
        p1 = new Piece(TypePiece.DWARF);
        p2 = new Piece(TypePiece.ELF);
        assertEquals(null, f.execute(p2, p1));
    }

    @Test
    public void testElfLooseAtAttack()
    {
        p1 = new Piece(TypePiece.DRAGON);
        p2 = new Piece(TypePiece.ELF);
        assertEquals(p2, f.execute(p2,p1));
    }

    @Test
    public void testElfLooseAtDefense()
    {
        p1 = new Piece(TypePiece.DRAGON);
        p2 = new Piece(TypePiece.ELF);
        assertEquals(p2, f.execute(p1,p2));
    }

    @Test
    public void testElfWinAtAttack()
    {
        p1 = new Piece(TypePiece.SLAYER);
        p2 = new Piece(TypePiece.ELF);
        assertEquals(p1, f.execute(p2, p1));
    }

    @Test
    public void testElfWinAtDefense()
    {
        p1 = new Piece(TypePiece.SLAYER);
        p2 = new Piece(TypePiece.ELF);
        assertEquals(p1, f.execute(p1, p2));
    }


}
