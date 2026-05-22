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
	
	private ImageIcon King = new ImageIcon(GUI.class.getResource("/images/king.png"));
	
	private ImageIcon Queen = new ImageIcon(GUI.class.getResource("/images/queen.png"));
	
	private ImageIcon Rook1 = new ImageIcon(GUI.class.getResource("/images/Rook.png"));
	
	private ImageIcon Rook2 = new ImageIcon(GUI.class.getResource("/images/Rook2.png"));
 
	private ImageIcon Bishop1 = new ImageIcon(GUI.class.getResource("/images/bishop.png"));
	
	private ImageIcon Bishop2 = new ImageIcon(GUI.class.getResource("/images/bishop2.png"));
	
	private ImageIcon Knight1 = new ImageIcon(GUI.class.getResource("/images/knight.png"));

	private ImageIcon Knight2 = new ImageIcon(GUI.class.getResource("/images/knight2.png"));

	private ImageIcon Pawn1 = new ImageIcon(GUI.class.getResource("/images/pawn.png"));
	
	private ImageIcon Pawn2 = new ImageIcon(GUI.class.getResource("/images/pawn2.png"));
	
	private ImageIcon Pawn3 = new ImageIcon(GUI.class.getResource("/images/pawn3.png"));
	
	private ImageIcon Pawn4 = new ImageIcon(GUI.class.getResource("/images/pawn4.png"));
	
	private ImageIcon Pawn5 = new ImageIcon(GUI.class.getResource("/images/pawn5.png"));
	
	private ImageIcon Pawn6 = new ImageIcon(GUI.class.getResource("/images/pawn6.png"));
	
	private ImageIcon Pawn7 = new ImageIcon(GUI.class.getResource("/images/pawn7.png"));
	
	private ImageIcon Pawn8 = new ImageIcon(GUI.class.getResource("/images/pawn8.png"));
	
	private ImageIcon B_King = new ImageIcon(GUI.class.getResource("/images/blackking.png"));
	
	private ImageIcon B_Queen = new ImageIcon(GUI.class.getResource("/images/blackqueen.png"));

	private ImageIcon B_Rook1 = new ImageIcon(GUI.class.getResource("/images/blackrook1.png"));
	
	private ImageIcon B_Rook2 = new ImageIcon(GUI.class.getResource("/images/blackrook2.png"));

	private ImageIcon B_Bishop1 = new ImageIcon(GUI.class.getResource("/images/blackbishop.png"));
	
	private ImageIcon B_Bishop2 = new ImageIcon(GUI.class.getResource("/images/blackbishop2.png"));

	private ImageIcon B_Knight1 = new ImageIcon(GUI.class.getResource("/images/blackknight1.jpg"));
	
	private ImageIcon B_Knight2 = new ImageIcon(GUI.class.getResource("/images/blackknight2.jpg"));
	
	private ImageIcon B_Pawn1 = new ImageIcon(GUI.class.getResource("/images/blackpawn1.jpg"));
	
	private ImageIcon B_Pawn2 = new ImageIcon(GUI.class.getResource("/images/blackpawn2.jpg"));

	private ImageIcon B_Pawn3 = new ImageIcon(GUI.class.getResource("/images/blackpawn3.jpg"));

	private ImageIcon B_Pawn4 = new ImageIcon(GUI.class.getResource("/images/blackpawn4.jpg"));

	private ImageIcon B_Pawn5 = new ImageIcon(GUI.class.getResource("/images/blackpawn5.jpg"));

	private ImageIcon B_Pawn6 = new ImageIcon(GUI.class.getResource("/images/blackpawn6.jpg"));

	private ImageIcon B_Pawn7 = new ImageIcon(GUI.class.getResource("/images/blackpawn7.jpg"));

	private ImageIcon B_Pawn8 = new ImageIcon(GUI.class.getResource("/images/blackpawn8.jpg"));

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	

	

	
	
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
		pieceRegistry.register(k, King, "King");
		pieceRegistry.register(q, Queen, "Queen");
		pieceRegistry.register(k1, Knight1, "Knight1");
		pieceRegistry.register(k2, Knight2, "Knight2");
		pieceRegistry.register(b1, Bishop1, "Bishop1");
		pieceRegistry.register(b2, Bishop2, "Bishop2");
		pieceRegistry.register(r1, Rook1, "Rook1");
		pieceRegistry.register(r2, Rook2, "Rook2");
		pieceRegistry.register(p1, Pawn1, "Pawn1");
		pieceRegistry.register(p2, Pawn2, "Pawn2");
		pieceRegistry.register(p3, Pawn3, "Pawn3");
		pieceRegistry.register(p4, Pawn4, "Pawn4");
		pieceRegistry.register(p5, Pawn5, "Pawn5");
		pieceRegistry.register(p6, Pawn6, "Pawn6");
		pieceRegistry.register(p7, Pawn7, "Pawn7");
		pieceRegistry.register(p8, Pawn8, "Pawn8");
		pieceRegistry.register(bk, B_King, "B.King");
		pieceRegistry.register(bq, B_Queen, "B.Queen");
		pieceRegistry.register(bk1, B_Knight1, "B.Knight1");
		pieceRegistry.register(bk2, B_Knight2, "B.Knight2");
		pieceRegistry.register(bb1, B_Bishop1, "B.Bishop1");
		pieceRegistry.register(bb2, B_Bishop2, "B.Bishop2");
		pieceRegistry.register(br1, B_Rook1, "B.Rook1");
		pieceRegistry.register(br2, B_Rook2, "B.Rook2");
		pieceRegistry.register(bp1, B_Pawn1, "B.Pawn1");
		pieceRegistry.register(bp2, B_Pawn2, "B.Pawn2");
		pieceRegistry.register(bp3, B_Pawn3, "B.Pawn3");
		pieceRegistry.register(bp4, B_Pawn4, "B.Pawn4");
		pieceRegistry.register(bp5, B_Pawn5, "B.Pawn5");
		pieceRegistry.register(bp6, B_Pawn6, "B.Pawn6");
		pieceRegistry.register(bp7, B_Pawn7, "B.Pawn7");
		pieceRegistry.register(bp8, B_Pawn8, "B.Pawn8");
		pieceRegistry.registerPromotionQueens(
				loadPromotionQueenIcons("queenx", ".png"),
				loadPromotionQueenIcons("blackqueenx", ".png"));
	}

	private static ImageIcon[] loadPromotionQueenIcons(String basename, String extension) {
		ImageIcon[] icons = new ImageIcon[8];
		for (int file = 1; file <= 8; file++) {
			icons[file - 1] = new ImageIcon(
					GUI.class.getResource("/images/" + basename + file + extension));
		}
		return icons;
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