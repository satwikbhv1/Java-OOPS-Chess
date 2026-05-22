import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class GUI extends JFrame 
{

	private static final long serialVersionUID=-2;


	private Game game = new Game();

	private final PieceRegistry pieceRegistry = new PieceRegistry();

	private Container contents;
	
	private JButton[][] square = new JButton[8][8];

	Knight k1 = new Knight(7,1,PieceColor.WHITE);
	Knight k2 = new Knight(7,6,PieceColor.WHITE);
	
	Bishop b1 = new Bishop(7,2,PieceColor.WHITE);
	Bishop b2 = new Bishop(7,5,PieceColor.WHITE);
	
	Rook r1 = new Rook(7,0,PieceColor.WHITE);
	Rook r2 = new Rook(7,7,PieceColor.WHITE);
	
	King k = new King(7,4,PieceColor.WHITE);
	
	Queen q = new Queen(7,3,PieceColor.WHITE);
	
	Pawn p1 = new Pawn(6,0,PieceColor.WHITE);
	Pawn p2 = new Pawn(6,1,PieceColor.WHITE);
	Pawn p3 = new Pawn(6,2,PieceColor.WHITE);
	Pawn p4 = new Pawn(6,3,PieceColor.WHITE);
	Pawn p5 = new Pawn(6,4,PieceColor.WHITE);
	Pawn p6 = new Pawn(6,5,PieceColor.WHITE);
	Pawn p7 = new Pawn(6,6,PieceColor.WHITE);
	Pawn p8 = new Pawn(6,7,PieceColor.WHITE);
	
	Knight bk1 = new Knight(0,1,PieceColor.BLACK);
	Knight bk2 = new Knight(0,6,PieceColor.BLACK);
	
	Bishop bb1 = new Bishop(0,2,PieceColor.BLACK);
	Bishop bb2 = new Bishop(0,5,PieceColor.BLACK);
	
	Rook br1 = new Rook(0,0,PieceColor.BLACK);
	Rook br2 = new Rook(0,7,PieceColor.BLACK);
	
	King bk = new King(0,4,PieceColor.BLACK);
	
	Queen bq = new Queen(0,3,PieceColor.BLACK);
	
	Pawn bp1 = new Pawn(1,0,PieceColor.BLACK);
	Pawn bp2 = new Pawn(1,1,PieceColor.BLACK);
	Pawn bp3 = new Pawn(1,2,PieceColor.BLACK);
	Pawn bp4 = new Pawn(1,3,PieceColor.BLACK);
	Pawn bp5 = new Pawn(1,4,PieceColor.BLACK);
	Pawn bp6 = new Pawn(1,5,PieceColor.BLACK);
	Pawn bp7 = new Pawn(1,6,PieceColor.BLACK);
	Pawn bp8 = new Pawn(1,7,PieceColor.BLACK);
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GUI frame = new GUI();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	public GUI() 
	{
		super("SChess");
		getContentPane().setForeground(Color.BLACK);
		contents = getContentPane();
		ButtonHandler b = new ButtonHandler();
		contents.setLayout(new GridLayout(8,8)); 
		
		for(int i =0;i<8;i++)
		{
			for(int j =0;j<8;j++)
			{
				square[i][j]= new JButton();
				square[i][j].setOpaque(true);
				square[i][j].setBorderPainted(false);
				if((i+j)%2==0)
				{
					square[i][j].setBackground(Color.WHITE);
				}
				else
				{
					square[i][j].setBackground(new Color(0x81b64c));
				}
				contents.add(square[i][j]);
				square[i][j].addMouseListener(b);
			}                                                                  
		}

		// populate Board — authoritative position source
		game.getBoard().set(new Position(7, 4), k);
		game.getBoard().set(new Position(7, 3), q);
		game.getBoard().set(new Position(7, 1), k1);
		game.getBoard().set(new Position(7, 6), k2);
		game.getBoard().set(new Position(7, 2), b1);
		game.getBoard().set(new Position(7, 5), b2);
		game.getBoard().set(new Position(7, 0), r1);
		game.getBoard().set(new Position(7, 7), r2);
		game.getBoard().set(new Position(6, 0), p1);
		game.getBoard().set(new Position(6, 1), p2);
		game.getBoard().set(new Position(6, 2), p3);
		game.getBoard().set(new Position(6, 3), p4);
		game.getBoard().set(new Position(6, 4), p5);
		game.getBoard().set(new Position(6, 5), p6);
		game.getBoard().set(new Position(6, 6), p7);
		game.getBoard().set(new Position(6, 7), p8);
		game.getBoard().set(new Position(0, 4), bk);
		game.getBoard().set(new Position(0, 3), bq);
		game.getBoard().set(new Position(0, 1), bk1);
		game.getBoard().set(new Position(0, 6), bk2);
		game.getBoard().set(new Position(0, 2), bb1);
		game.getBoard().set(new Position(0, 5), bb2);
		game.getBoard().set(new Position(0, 0), br1);
		game.getBoard().set(new Position(0, 7), br2);
		game.getBoard().set(new Position(1, 0), bp1);
		game.getBoard().set(new Position(1, 1), bp2);
		game.getBoard().set(new Position(1, 2), bp3);
		game.getBoard().set(new Position(1, 3), bp4);
		game.getBoard().set(new Position(1, 4), bp5);
		game.getBoard().set(new Position(1, 5), bp6);
		game.getBoard().set(new Position(1, 6), bp7);
		game.getBoard().set(new Position(1, 7), bp8);

		registerPieces();
		syncUiFromBoard();

		super.setSize(600,600);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		super.setVisible(true);
	}

	private void registerPieces() {
		registerPiece(k, "King");
		registerPiece(q, "Queen");
		registerPiece(k1, "Knight1");
		registerPiece(k2, "Knight2");
		registerPiece(b1, "Bishop1");
		registerPiece(b2, "Bishop2");
		registerPiece(r1, "Rook1");
		registerPiece(r2, "Rook2");
		registerPiece(p1, "Pawn1");
		registerPiece(p2, "Pawn2");
		registerPiece(p3, "Pawn3");
		registerPiece(p4, "Pawn4");
		registerPiece(p5, "Pawn5");
		registerPiece(p6, "Pawn6");
		registerPiece(p7, "Pawn7");
		registerPiece(p8, "Pawn8");
		registerPiece(bk, "B.King");
		registerPiece(bq, "B.Queen");
		registerPiece(bk1, "B.Knight1");
		registerPiece(bk2, "B.Knight2");
		registerPiece(bb1, "B.Bishop1");
		registerPiece(bb2, "B.Bishop2");
		registerPiece(br1, "B.Rook1");
		registerPiece(br2, "B.Rook2");
		registerPiece(bp1, "B.Pawn1");
		registerPiece(bp2, "B.Pawn2");
		registerPiece(bp3, "B.Pawn3");
		registerPiece(bp4, "B.Pawn4");
		registerPiece(bp5, "B.Pawn5");
		registerPiece(bp6, "B.Pawn6");
		registerPiece(bp7, "B.Pawn7");
		registerPiece(bp8, "B.Pawn8");
	}

	private void registerPiece(Piece piece, String tooltip) {
		pieceRegistry.register(
				piece,
				PieceIconFactory.get(piece.getType(), piece.getColor()),
				tooltip);
	}

	private void syncUiFromBoard() {
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				Piece piece = game.getBoard().get(new Position(i, j));
				if (piece == null) {
					square[i][j].setIcon(null);
					square[i][j].setToolTipText(null);
				} else {
					PieceDisplay display = pieceRegistry.get(piece);
					if (display != null) {
						square[i][j].setIcon(display.icon());
						square[i][j].setToolTipText(display.tooltip());
					}
				}
			}
		}
	}

	public int processClick(int init_i, int init_j, int fin_i, int fin_j) {
		Move move = new Move(new Position(init_i, init_j), new Position(fin_i, fin_j));
		PromotionHandler promotionHandler = (pawn, to) ->
				pieceRegistry.promote(pawn, to, game.getBoard());
		if (game.tryPlayMove(move, promotionHandler)) {
			syncUiFromBoard();
		}
		return game.getSideFlag();
	}


	private class ButtonHandler implements MouseListener,MouseMotionListener
	{
		int initx,inity,desx,desy,flag=0;
		
		@Override
		public void mouseDragged(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseMoved(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			Object source = e.getSource();
			if(flag==0)
			{
				for(int i=0;i<8;i++)
				{
					for(int j=0;j<8;j++)
					{
						if(source==square[i][j])
						{
							initx=i;
							inity=j;
						}
					}
				}
				flag=1;
			}
			else
			{
				for(int i=0;i<8;i++)
				{
					for(int j=0;j<8;j++)
					{
						if(source==square[i][j])
						{
							desx=i;
							desy=j;
						}
					}
				}
				flag=0;
				processClick(initx,inity,desx,desy);
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}
