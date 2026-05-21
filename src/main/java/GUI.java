import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;

public class GUI extends JFrame 
{

	private static final long serialVersionUID=-2;


	private Board board = new Board();

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
	
	private ImageIcon Queenx1 = new ImageIcon(GUI.class.getResource("/images/queenx1.png"));
	
	private ImageIcon Queenx2 = new ImageIcon(GUI.class.getResource("/images/queenx2.png"));
	
	private ImageIcon Queenx3 = new ImageIcon(GUI.class.getResource("/images/queenx3.png"));
	
	private ImageIcon Queenx4 = new ImageIcon(GUI.class.getResource("/images/queenx4.png"));
	
	private ImageIcon Queenx5 = new ImageIcon(GUI.class.getResource("/images/queenx5.png"));
	
	private ImageIcon Queenx6 = new ImageIcon(GUI.class.getResource("/images/queenx6.png"));
	
	private ImageIcon Queenx7 = new ImageIcon(GUI.class.getResource("/images/queenx7.png"));
	
	private ImageIcon Queenx8 = new ImageIcon(GUI.class.getResource("/images/queenx8.png"));
	
	
	
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

    private ImageIcon B_Queenx1 = new ImageIcon(GUI.class.getResource("/images/blackqueenx1.png"));
	
	private ImageIcon B_Queenx2 = new ImageIcon(GUI.class.getResource("/images/blackqueenx2.png"));
	
	private ImageIcon B_Queenx3 = new ImageIcon(GUI.class.getResource("/images/blackqueenx3.png"));
	
	private ImageIcon B_Queenx4 = new ImageIcon(GUI.class.getResource("/images/blackqueenx4.png"));
	
	private ImageIcon B_Queenx5 = new ImageIcon(GUI.class.getResource("/images/blackqueenx5.png"));
	
	private ImageIcon B_Queenx6 = new ImageIcon(GUI.class.getResource("/images/blackqueenx6.png"));
	
	private ImageIcon B_Queenx7 = new ImageIcon(GUI.class.getResource("/images/blackqueenx7.png"));
	
	private ImageIcon B_Queenx8 = new ImageIcon(GUI.class.getResource("/images/blackqueenx8.png"));
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	

	

	
	
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
		
		square[7][4].setToolTipText("King");
		square[7][3].setToolTipText("Queen");
		square[7][1].setToolTipText("Knight1");
		square[7][6].setToolTipText("Knight2");
		square[7][2].setToolTipText("Bishop1");
		square[7][5].setToolTipText("Bishop2");
		square[7][0].setToolTipText("Rook1");
		square[7][7].setToolTipText("Rook2");
		square[6][0].setToolTipText("Pawn1");
		square[6][1].setToolTipText("Pawn2");
		square[6][2].setToolTipText("Pawn3");
		square[6][3].setToolTipText("Pawn4");
		square[6][4].setToolTipText("Pawn5");
		square[6][5].setToolTipText("Pawn6");
		square[6][6].setToolTipText("Pawn7");
		square[6][7].setToolTipText("Pawn8");
		
		square[7][4].setIcon(King);
		square[7][3].setIcon(Queen);
		square[7][1].setIcon(Knight1);
		square[7][6].setIcon(Knight2);
		square[7][2].setIcon(Bishop1);
		square[7][5].setIcon(Bishop2);
		square[7][0].setIcon(Rook1);
		square[7][7].setIcon(Rook2);
		square[6][0].setIcon(Pawn1);
		square[6][1].setIcon(Pawn2);
		square[6][2].setIcon(Pawn3);
		square[6][3].setIcon(Pawn4);
		square[6][4].setIcon(Pawn5);
		square[6][5].setIcon(Pawn6);
		square[6][6].setIcon(Pawn7);
		square[6][7].setIcon(Pawn8);

		square[0][4].setToolTipText("B.King");
		square[0][3].setToolTipText("B.Queen");
		square[0][1].setToolTipText("B.Knight1");
		square[0][6].setToolTipText("B.Knight2");
		square[0][2].setToolTipText("B.Bishop1");
		square[0][5].setToolTipText("B.Bishop2");
		square[0][0].setToolTipText("B.Rook1");
		square[0][7].setToolTipText("B.Rook2");
		square[1][0].setToolTipText("B.Pawn1");
		square[1][1].setToolTipText("B.Pawn2");
		square[1][2].setToolTipText("B.Pawn3");
		square[1][3].setToolTipText("B.Pawn4");
		square[1][4].setToolTipText("B.Pawn5");
		square[1][5].setToolTipText("B.Pawn6");
		square[1][6].setToolTipText("B.Pawn7");
		square[1][7].setToolTipText("B.Pawn8");
		
		square[0][4].setIcon(B_King);
		square[0][3].setIcon(B_Queen);
		square[0][1].setIcon(B_Knight1);
		square[0][6].setIcon(B_Knight2);
		square[0][2].setIcon(B_Bishop1);
		square[0][5].setIcon(B_Bishop2);
		square[0][0].setIcon(B_Rook1);
		square[0][7].setIcon(B_Rook2);
		square[1][0].setIcon(B_Pawn1);
		square[1][1].setIcon(B_Pawn2);
		square[1][2].setIcon(B_Pawn3);
		square[1][3].setIcon(B_Pawn4);
		square[1][4].setIcon(B_Pawn5);
		square[1][5].setIcon(B_Pawn6);
		square[1][6].setIcon(B_Pawn7);
		square[1][7].setIcon(B_Pawn8);

		// populate Board — authoritative position source (tooltips stay for piece identity until T10)
		board.set(new Position(7, 4), k);
		board.set(new Position(7, 3), q);
		board.set(new Position(7, 1), k1);
		board.set(new Position(7, 6), k2);
		board.set(new Position(7, 2), b1);
		board.set(new Position(7, 5), b2);
		board.set(new Position(7, 0), r1);
		board.set(new Position(7, 7), r2);
		board.set(new Position(6, 0), p1);
		board.set(new Position(6, 1), p2);
		board.set(new Position(6, 2), p3);
		board.set(new Position(6, 3), p4);
		board.set(new Position(6, 4), p5);
		board.set(new Position(6, 5), p6);
		board.set(new Position(6, 6), p7);
		board.set(new Position(6, 7), p8);
		board.set(new Position(0, 4), bk);
		board.set(new Position(0, 3), bq);
		board.set(new Position(0, 1), bk1);
		board.set(new Position(0, 6), bk2);
		board.set(new Position(0, 2), bb1);
		board.set(new Position(0, 5), bb2);
		board.set(new Position(0, 0), br1);
		board.set(new Position(0, 7), br2);
		board.set(new Position(1, 0), bp1);
		board.set(new Position(1, 1), bp2);
		board.set(new Position(1, 2), bp3);
		board.set(new Position(1, 3), bp4);
		board.set(new Position(1, 4), bp5);
		board.set(new Position(1, 5), bp6);
		board.set(new Position(1, 6), bp7);
		board.set(new Position(1, 7), bp8);

		super.setSize(600,600);
		super.setResizable(false);
		super.setLocationRelativeTo(null);
		super.setVisible(true);
	}
	Queen qx1;
	Queen qx2;
	Queen qx3;
	Queen qx4;
	Queen qx5;
	Queen qx6;
	Queen qx7;
	Queen qx8;
	Queen bqx1;
	Queen bqx2;
	Queen bqx3;
	Queen bqx4;
	Queen bqx5;
	Queen bqx6;
	Queen bqx7;
	Queen bqx8;
	public void makequeen(int fin_i,int fin_j,Pawn p,String s)
	{
		if("1".equals(s))
		{
			square[fin_i][fin_j].setIcon(Queenx1);
			square[fin_i][fin_j].setToolTipText("Queenx1");
			square[p.getRow()][p.getCol()].setIcon(null);
			square[p.getRow()][p.getCol()].setToolTipText(null);
			board.clear(p.getPosition());
			qx1=new Queen(fin_i, fin_j, p.color);
			board.set(new Position(fin_i, fin_j), qx1);
		}
		if("2".equals(s))
		{
			square[fin_i][fin_j].setIcon(Queenx2);
			square[fin_i][fin_j].setToolTipText("Queenx2");
			square[p.getRow()][p.getCol()].setIcon(null);
			square[p.getRow()][p.getCol()].setToolTipText(null);
			board.clear(p.getPosition());
			qx2=new Queen(fin_i, fin_j, p.color);
			board.set(new Position(fin_i, fin_j), qx2);
		}
		if("3".equals(s))
		{
			square[fin_i][fin_j].setIcon(Queenx3);
			square[fin_i][fin_j].setToolTipText("Queenx3");
			square[p.getRow()][p.getCol()].setIcon(null);
			square[p.getRow()][p.getCol()].setToolTipText(null);
			board.clear(p.getPosition());
			qx3=new Queen(fin_i, fin_j, p.color);
			board.set(new Position(fin_i, fin_j), qx3);
		}
		if("4".equals(s))
		{
			square[fin_i][fin_j].setIcon(Queenx4);
			square[fin_i][fin_j].setToolTipText("Queenx4");
			square[p.getRow()][p.getCol()].setIcon(null);
			square[p.getRow()][p.getCol()].setToolTipText(null);
			board.clear(p.getPosition());
			qx4=new Queen(fin_i, fin_j, p.color);
			board.set(new Position(fin_i, fin_j), qx4);
		}
		if("5".equals(s))
		{
			square[fin_i][fin_j].setIcon(Queenx5);
			square[fin_i][fin_j].setToolTipText("Queenx5");
			square[p.getRow()][p.getCol()].setIcon(null);
			square[p.getRow()][p.getCol()].setToolTipText(null);
			board.clear(p.getPosition());
			qx5=new Queen(fin_i, fin_j, p.color);
			board.set(new Position(fin_i, fin_j), qx5);
		}
		if("6".equals(s))
		{
			square[fin_i][fin_j].setIcon(Queenx6);
			square[fin_i][fin_j].setToolTipText("Queenx6");
			square[p.getRow()][p.getCol()].setIcon(null);
			square[p.getRow()][p.getCol()].setToolTipText(null);
			board.clear(p.getPosition());
			qx6=new Queen(fin_i, fin_j, p.color);
			board.set(new Position(fin_i, fin_j), qx6);
		}
		if("7".equals(s))
		{
			square[fin_i][fin_j].setIcon(Queenx7);
			square[fin_i][fin_j].setToolTipText("Queenx7");
			square[p.getRow()][p.getCol()].setIcon(null);
			square[p.getRow()][p.getCol()].setToolTipText(null);
			board.clear(p.getPosition());
			qx7=new Queen(fin_i, fin_j, p.color);
			board.set(new Position(fin_i, fin_j), qx7);
		}
		if("8".equals(s))
		{
			square[fin_i][fin_j].setIcon(Queenx8);
			square[fin_i][fin_j].setToolTipText("Queenx8");
			square[p.getRow()][p.getCol()].setIcon(null);
			square[p.getRow()][p.getCol()].setToolTipText(null);
			board.clear(p.getPosition());
			qx8=new Queen(fin_i, fin_j, p.color);
			board.set(new Position(fin_i, fin_j), qx8);
		}
		if("b1".equals(s))
		{
			square[fin_i][fin_j].setIcon(B_Queenx1);
			square[fin_i][fin_j].setToolTipText("B.Queenx1");
			square[p.getRow()][p.getCol()].setIcon(null);
			square[p.getRow()][p.getCol()].setToolTipText(null);
			board.clear(p.getPosition());
			bqx1=new Queen(fin_i, fin_j, p.color);
			board.set(new Position(fin_i, fin_j), bqx1);
		}
		if("b2".equals(s))
		{
			square[fin_i][fin_j].setIcon(B_Queenx2);
			square[fin_i][fin_j].setToolTipText("B.Queenx2");
			square[p.getRow()][p.getCol()].setIcon(null);
			square[p.getRow()][p.getCol()].setToolTipText(null);
			board.clear(p.getPosition());
			bqx2=new Queen(fin_i, fin_j, p.color);
			board.set(new Position(fin_i, fin_j), bqx2);
		}
		if("b3".equals(s))
		{
			square[fin_i][fin_j].setIcon(B_Queenx3);
			square[fin_i][fin_j].setToolTipText("B.Queenx3");
			square[p.getRow()][p.getCol()].setIcon(null);
			square[p.getRow()][p.getCol()].setToolTipText(null);
			board.clear(p.getPosition());
			bqx3=new Queen(fin_i, fin_j, p.color);
			board.set(new Position(fin_i, fin_j), bqx3);
		}
		if("b4".equals(s))
		{
			square[fin_i][fin_j].setIcon(B_Queenx4);
			square[fin_i][fin_j].setToolTipText("B.Queenx4");
			square[p.getRow()][p.getCol()].setIcon(null);
			square[p.getRow()][p.getCol()].setToolTipText(null);
			board.clear(p.getPosition());
			bqx4=new Queen(fin_i, fin_j, p.color);
			board.set(new Position(fin_i, fin_j), bqx4);
		}
		if("b5".equals(s))
		{
			square[fin_i][fin_j].setIcon(B_Queenx5);
			square[fin_i][fin_j].setToolTipText("B.Queenx5");
			square[p.getRow()][p.getCol()].setIcon(null);
			square[p.getRow()][p.getCol()].setToolTipText(null);
			board.clear(p.getPosition());
			bqx5=new Queen(fin_i, fin_j, p.color);
			board.set(new Position(fin_i, fin_j), bqx5);
		}
		if("b6".equals(s))
		{
			square[fin_i][fin_j].setIcon(B_Queenx6);
			square[fin_i][fin_j].setToolTipText("B.Queenx6");
			square[p.getRow()][p.getCol()].setIcon(null);
			square[p.getRow()][p.getCol()].setToolTipText(null);
			board.clear(p.getPosition());
			bqx6=new Queen(fin_i, fin_j, p.color);
			board.set(new Position(fin_i, fin_j), bqx6);
		}
		if("b7".equals(s))
		{
			square[fin_i][fin_j].setIcon(B_Queenx7);
			square[fin_i][fin_j].setToolTipText("B.Queenx7");
			square[p.getRow()][p.getCol()].setIcon(null);
			square[p.getRow()][p.getCol()].setToolTipText(null);
			board.clear(p.getPosition());
			bqx7=new Queen(fin_i, fin_j, p.color);
			board.set(new Position(fin_i, fin_j), bqx7);
		}
		if("b8".equals(s))
		{
			square[fin_i][fin_j].setIcon(B_Queenx8);
			square[fin_i][fin_j].setToolTipText("B.Queenx8");
			square[p.getRow()][p.getCol()].setIcon(null);
			square[p.getRow()][p.getCol()].setToolTipText(null);
			board.clear(p.getPosition());
			bqx8=new Queen(fin_i, fin_j, p.color);
			board.set(new Position(fin_i, fin_j), bqx8);
		}
	}

	
	public int processClick(int init_i,int init_j,int fin_i,int fin_j, int flag)
	{
		Position from = new Position(init_i, init_j);
		Position to   = new Position(fin_i, fin_j);
		if(flag==0)
		{
			if(square[fin_i][fin_j].getToolTipText()==null||((square[fin_i][fin_j].getToolTipText().charAt(0)=='B')&&(square[fin_i][fin_j].getToolTipText().charAt(1)=='.')))
			{
				if(square[init_i][init_j].getToolTipText().equals("Knight1"))
				{	
					if(k1.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(Knight1);
						square[fin_i][fin_j].setToolTipText("Knight1");
						return 1;
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Knight2"))
				{
					
					if(k2.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(Knight2);
						square[fin_i][fin_j].setToolTipText("Knight2");
						return 1;
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Bishop1")&&board.isPathClear(from, to))
				{
					
					if(b1.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(Bishop1);
						square[fin_i][fin_j].setToolTipText("Bishop1");
						return 1;
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Bishop2")&&board.isPathClear(from, to))
				{
					if(b2.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(Bishop2);
						square[fin_i][fin_j].setToolTipText("Bishop2");
						return 1;
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Rook1")&&board.isPathClear(from, to))
				{
					
					if(r1.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(Rook1);
						square[fin_i][fin_j].setToolTipText("Rook1");
						return 1;
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Rook2")&&board.isPathClear(from, to))
				{
					
					if(r2.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(Rook2);
						square[fin_i][fin_j].setToolTipText("Rook2");
						return 1;
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Queen")&&board.isPathClear(from, to))
				{
					if(q.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(Queen);
						square[fin_i][fin_j].setToolTipText("Queen");
						return 1;
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Queenx1")&&board.isPathClear(from, to))
				{
					if(qx1.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(Queenx1);
						square[fin_i][fin_j].setToolTipText("Queenx1");
						return 1;
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Queenx2")&&board.isPathClear(from, to))
				{
					if(qx2.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(Queenx2);
						square[fin_i][fin_j].setToolTipText("Queenx2");
						return 1;
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Queenx3")&&board.isPathClear(from, to))
				{
					if(qx3.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(Queenx3);
						square[fin_i][fin_j].setToolTipText("Queenx3");
						return 1;
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Queenx4")&&board.isPathClear(from, to))
				{
					if(qx4.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(Queenx4);
						square[fin_i][fin_j].setToolTipText("Queenx4");
						return 1;
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Queenx5")&&board.isPathClear(from, to))
				{
					if(qx5.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(Queenx5);
						square[fin_i][fin_j].setToolTipText("Queenx5");
						return 1;
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Queenx6")&&board.isPathClear(from, to))
				{
					if(qx6.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(Queenx6);
						square[fin_i][fin_j].setToolTipText("Queenx6");
						return 1;
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Queenx7")&&board.isPathClear(from, to))
				{
					if(qx7.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(Queenx7);
						square[fin_i][fin_j].setToolTipText("Queenx7");
						return 1;
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Queenx8")&&board.isPathClear(from, to))
				{
					if(qx8.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(Queenx8);
						square[fin_i][fin_j].setToolTipText("Queenx8");
						return 1;
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("King"))
				{
					
					if(k.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(King);
						square[fin_i][fin_j].setToolTipText("King");
						return 1;
					}
					if(fin_i==init_i&&fin_j==init_j+2&&r1.b==true&&square[init_i][init_j+1].getToolTipText()==null&&square[init_i][init_j+1].getToolTipText()==null)
					{
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(King);
						square[fin_i][fin_j].setToolTipText("King");
						Position r2From = r2.getPosition();
						Position r2To = new Position(fin_i, fin_j-1);
						square[r2From.row()][r2From.col()].setIcon(null);
						square[r2From.row()][r2From.col()].setToolTipText(null);
						board.move(r2From, r2To);
						square[r2To.row()][r2To.col()].setIcon(Rook2);
						square[r2To.row()][r2To.col()].setToolTipText("Rook2");
						return 1;
					}
					if(fin_i==init_i&&fin_j==init_j-2&&r1.b==true&&square[init_i][init_j-1].getToolTipText()==null&&square[init_i][init_j-2].getToolTipText()==null&&square[init_i][init_j-3].getToolTipText()==null)
					{
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(King);
						square[fin_i][fin_j].setToolTipText("King");
						Position r1From = r1.getPosition();
						Position r1To = new Position(fin_i, fin_j+1);
						square[r1From.row()][r1From.col()].setIcon(null);
						square[r1From.row()][r1From.col()].setToolTipText(null);
						board.move(r1From, r1To);
						square[r1To.row()][r1To.col()].setIcon(Rook1);
						square[r1To.row()][r1To.col()].setToolTipText("Rook1");
						return 1;
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Pawn1"))
				{
					if(init_j==fin_j)
					{
						if(p1.isValidMove1(fin_i,PieceColor.WHITE)&&square[fin_i][fin_j].getToolTipText()==null) {
							if(!p1.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(Pawn1);
								square[fin_i][fin_j].setToolTipText("Pawn1");
								return 1;
							}
							else
							{
								makequeen(fin_i,fin_j,p1,"1");
								return 1;
							}
						}
					}
					else if(square[fin_i][fin_j].getToolTipText() != null)
					{
						if(p1.isValidMove2(fin_i,fin_j,PieceColor.WHITE))
						{
							if(!p1.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(Pawn1);
								square[fin_i][fin_j].setToolTipText("Pawn1");
								return 1;
							}
							else
							{
								makequeen(fin_i,fin_j,p1,"1");
								return 1;
							}
						}
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Pawn2"))
				{
					if(init_j==fin_j)
					{
						if(p2.isValidMove1(fin_i,PieceColor.WHITE)&&square[fin_i][fin_j].getToolTipText()==null) 
						{
							if(!p2.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(Pawn2);
								square[fin_i][fin_j].setToolTipText("Pawn2");
								return 1;
							}
							else
							{
								makequeen(fin_i,fin_j,p2,"2");
								return 1;
							}
						}
					}
					else if(square[fin_i][fin_j].getToolTipText() != null)
					{
						if(p2.isValidMove2(fin_i,fin_j,PieceColor.WHITE)) 
						{
							if(!p2.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(Pawn2);
								square[fin_i][fin_j].setToolTipText("Pawn2");
								return 1;
							}
							else
							{
								makequeen(fin_i,fin_j,p2,"2");
								return 1;
							}
						}
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Pawn3"))
				{
					if(init_j==fin_j)
					{
						if(p3.isValidMove1(fin_i,PieceColor.WHITE)&&square[fin_i][fin_j].getToolTipText()==null)
						{
							if(!p3.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(Pawn3);
								square[fin_i][fin_j].setToolTipText("Pawn3");
								return 1;
							}
							else
							{
								makequeen(fin_i,fin_j,p3,"3");
								return 1;
							}
						}
					}
					else if(square[fin_i][fin_j].getToolTipText() != null)
					{
						if(p3.isValidMove2(fin_i,fin_j,PieceColor.WHITE)) 
						{
							if(!p3.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(Pawn3);
								square[fin_i][fin_j].setToolTipText("Pawn3");
								return 1;
							}
							else
							{
								makequeen(fin_i,fin_j,p3,"3");
								return 1;
							}
						}
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Pawn4"))
				{
					if(init_j==fin_j)
					{
						if(p4.isValidMove1(fin_i,PieceColor.WHITE)&&square[fin_i][fin_j].getToolTipText()==null)
						{
							if(!p4.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(Pawn4);
								square[fin_i][fin_j].setToolTipText("Pawn4");
								return 1;
							}
							else
							{
								makequeen(fin_i,fin_j,p4,"4");
								return 1;
							}
						}
					}
					else if(square[fin_i][fin_j].getToolTipText() != null)
					{
						if(p4.isValidMove2(fin_i,fin_j,PieceColor.WHITE)) 
						{
							if(!p4.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(Pawn4);
								square[fin_i][fin_j].setToolTipText("Pawn4");
								return 1;
							}
							else
							{
								makequeen(fin_i,fin_j,p4,"4");
								return 1;
							}
						}
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Pawn5"))
				{
					if(init_j==fin_j)
					{
						if(p5.isValidMove1(fin_i,PieceColor.WHITE)&&square[fin_i][fin_j].getToolTipText()==null) 
						{
							if(!p5.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(Pawn5);
								square[fin_i][fin_j].setToolTipText("Pawn5");
								return 1;
							}
							else
							{
								makequeen(fin_i,fin_j,p5,"5");
								return 1;
							}
						}
					}
					else if(square[fin_i][fin_j].getToolTipText() != null)
					{
						if(p5.isValidMove2(fin_i,fin_j,PieceColor.WHITE)) 
						{
							if(!p5.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(Pawn5);
								square[fin_i][fin_j].setToolTipText("Pawn5");
								return 1;
							}
							else
							{
								makequeen(fin_i,fin_j,p5,"5");
								return 1;
							}
						}
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Pawn6"))
				{
					if(init_j==fin_j)
					{
						if(p6.isValidMove1(fin_i,PieceColor.WHITE)&&square[fin_i][fin_j].getToolTipText()==null) {
							if(!p6.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(Pawn6);
								square[fin_i][fin_j].setToolTipText("Pawn6");
								return 1;
							}
							else
							{
								makequeen(fin_i,fin_j,p6,"6");
								return 1;
							}
						}
					}
					else if(square[fin_i][fin_j].getToolTipText() != null)
					{
						if(p6.isValidMove2(fin_i,fin_j,PieceColor.WHITE)) 
						{
							if(!p6.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(Pawn6);
								square[fin_i][fin_j].setToolTipText("Pawn6");
								return 1;
							}
							else
							{
								makequeen(fin_i,fin_j,p6,"6");
								return 1;
							}
						}
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Pawn7"))
				{
					if(init_j==fin_j)
					{
						if(p7.isValidMove1(fin_i,PieceColor.WHITE)&&square[fin_i][fin_j].getToolTipText()==null) 
						{
							if(!p7.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(Pawn7);
								square[fin_i][fin_j].setToolTipText("Pawn7");
								return 1;
							}
							else
							{
								makequeen(fin_i,fin_j,p7,"7");
								return 1;
							}
						}
					}
					else if(square[fin_i][fin_j].getToolTipText() != null)
					{
							if(p7.isValidMove2(fin_i,fin_j,PieceColor.WHITE)) 
							{
								if(!p7.isqueen())
								{
									square[init_i][init_j].setIcon(null);
									square[init_i][init_j].setToolTipText(null);
									board.move(from, to);
									square[fin_i][fin_j].setIcon(Pawn7);
									square[fin_i][fin_j].setToolTipText("Pawn7");
									return 1;
								}
								else
								{
									makequeen(fin_i,fin_j,p7,"7");
									return 1;
								}
							}
					}
					return 0;
				}
				if(square[init_i][init_j].getToolTipText().equals("Pawn8"))
				{
					if(init_j==fin_j)
					{
						if(p8.isValidMove1(fin_i,PieceColor.WHITE)&&square[fin_i][fin_j].getToolTipText()==null) 
						{
							if(!p8.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(Pawn8);
								square[fin_i][fin_j].setToolTipText("Pawn8");
								return 1;
							}
							else
							{
								makequeen(fin_i,fin_j,p8,"8");
								return 1;
							}
						}
					}
					else if(square[fin_i][fin_j].getToolTipText() != null)
					{
						if(p8.isValidMove2(fin_i,fin_j,PieceColor.WHITE)) 
						{
							if(!p8.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(Pawn8);
								square[fin_i][fin_j].setToolTipText("Pawn8");
								return 1;
							}
							else
							{
								makequeen(fin_i,fin_j,p8,"8");
								return 1;
							}
						}
					}
					return 0;
				}
			}
			return 0;
		}
		else if(flag==1)
		{
			if(square[fin_i][fin_j].getToolTipText()==null||!((square[fin_i][fin_j].getToolTipText().charAt(0)=='B')&&(square[fin_i][fin_j].getToolTipText().charAt(1)=='.')))
			{	
				if(square[init_i][init_j].getToolTipText().equals("B.Knight1"))
				{
					
					if(bk1.isValidMove(fin_i,fin_j)) 
					{
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(B_Knight1);
						square[fin_i][fin_j].setToolTipText("B.Knight1");
						return 0;
					}
					return 1;
				}
	
				if(square[init_i][init_j].getToolTipText().equals("B.Knight2"))
				{
					
					if(bk2.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(B_Knight2);
						square[fin_i][fin_j].setToolTipText("B.Knight2");
						return 0;
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Rook1")&&board.isPathClear(from, to))
				{
					if(br1.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(B_Rook1);
						square[fin_i][fin_j].setToolTipText("B.Rook1");
						return 0;
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Rook2")&&board.isPathClear(from, to))
				{
					
					if(br2.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(B_Rook2);
						square[fin_i][fin_j].setToolTipText("B.Rook2");
						return 0;
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Bishop1")&&board.isPathClear(from, to))
				{
					
					if(bb1.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(B_Bishop1);
						square[fin_i][fin_j].setToolTipText("B.Bishop1");
						return 0;
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Bishop2")&&board.isPathClear(from, to))
				{
					
					if(bb2.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(B_Bishop2);
						square[fin_i][fin_j].setToolTipText("B.Bishop2");
						return 0;
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.King"))
				{
					
					if(bk.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(B_King);
						square[fin_i][fin_j].setToolTipText("B.King");
						return 0;
					}
					if(bk.b==true)
					{
						if(fin_i==init_i&&fin_j==init_j+2&&br1.b==true&&square[init_i][init_j+1].getToolTipText()==null&&square[init_i][init_j+1].getToolTipText()==null)
						{
							square[init_i][init_j].setIcon(null);
							square[init_i][init_j].setToolTipText(null);
							board.move(from, to);
							square[fin_i][fin_j].setIcon(B_King);
							square[fin_i][fin_j].setToolTipText("B.King");
							Position br2From = br2.getPosition();
							Position br2To = new Position(fin_i, fin_j-1);
							square[br2From.row()][br2From.col()].setIcon(null);
							square[br2From.row()][br2From.col()].setToolTipText(null);
							board.move(br2From, br2To);
							square[br2To.row()][br2To.col()].setIcon(B_Rook2);
							square[br2To.row()][br2To.col()].setToolTipText("B.Rook2");
						}
						if(fin_i==init_i&&fin_j==init_j-2&&br1.b==true&&square[init_i][init_j-1].getToolTipText()==null&&square[init_i][init_j-2].getToolTipText()==null&&square[init_i][init_j-3].getToolTipText()==null)
						{
							square[init_i][init_j].setIcon(null);
							square[init_i][init_j].setToolTipText(null);
							board.move(from, to);
							square[fin_i][fin_j].setIcon(B_King);
							square[fin_i][fin_j].setToolTipText("B.King");
							Position br1From = br1.getPosition();
							Position br1To = new Position(fin_i, fin_j+1);
							square[br1From.row()][br1From.col()].setIcon(null);
							square[br1From.row()][br1From.col()].setToolTipText(null);
							board.move(br1From, br1To);
							square[br1To.row()][br1To.col()].setIcon(B_Rook1);
							square[br1To.row()][br1To.col()].setToolTipText("B.Rook1");
						}
						return 0;
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Queen")&&board.isPathClear(from, to))
				{
					
					if(bq.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(B_Queen);
						square[fin_i][fin_j].setToolTipText("B.Queen");
						return 0;
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Queenx1")&&board.isPathClear(from, to))
				{
					if(bqx1.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(B_Queenx1);
						square[fin_i][fin_j].setToolTipText("B.Queenx1");
						return 0;
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Queenx2")&&board.isPathClear(from, to))
				{
					if(bqx2.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(B_Queenx2);
						square[fin_i][fin_j].setToolTipText("B.Queenx2");
						return 0;
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Queenx3")&&board.isPathClear(from, to))
				{
					if(bqx3.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(B_Queenx3);
						square[fin_i][fin_j].setToolTipText("B.Queenx3");
						return 0;
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Queenx4")&&board.isPathClear(from, to))
				{
					if(bqx4.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(B_Queenx4);
						square[fin_i][fin_j].setToolTipText("B.Queenx4");
						return 0;
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Queenx5")&&board.isPathClear(from, to))
				{
					if(bqx5.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(B_Queenx5);
						square[fin_i][fin_j].setToolTipText("B.Queenx5");
						return 0;
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Queenx6")&&board.isPathClear(from, to))
				{
					if(bqx6.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(B_Queenx6);
						square[fin_i][fin_j].setToolTipText("B.Queenx6");
						return 0;
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Queenx7")&&board.isPathClear(from, to))
				{
					if(bqx7.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(B_Queenx7);
						square[fin_i][fin_j].setToolTipText("B.Queenx7");
						return 0;
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Queenx8")&&board.isPathClear(from, to))
				{
					if(bqx8.isValidMove(fin_i,fin_j)) {
						square[init_i][init_j].setIcon(null);
						square[init_i][init_j].setToolTipText(null);
						board.move(from, to);
						square[fin_i][fin_j].setIcon(B_Queenx8);
						square[fin_i][fin_j].setToolTipText("B.Queenx8");
						return 0;
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Pawn1"))
				{
					if(init_j==fin_j)
					{
						if(bp1.isValidMove1(fin_i,PieceColor.BLACK)&&square[fin_i][fin_j].getToolTipText()==null)
						{
							if(!bp1.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(B_Pawn1);
								square[fin_i][fin_j].setToolTipText("B.Pawn1");
								return 0;
							}
							else
							{
								makequeen(fin_i,fin_j,bp1,"b1");
								return 0;
							}
						}
					}
					else if(square[fin_i][fin_j].getToolTipText() != null)
					{
						if(bp1.isValidMove2(fin_i,fin_j,PieceColor.BLACK)) 
						{
							if(!bp1.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(B_Pawn1);
								square[fin_i][fin_j].setToolTipText("B.Pawn1");
								return 0;
							}
							else
							{
								makequeen(fin_i,fin_j,bp1,"b1");
								return 0;
							}
						}
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Pawn2"))
				{
					if(init_j==fin_j)
					{
						if(bp2.isValidMove1(fin_i,PieceColor.BLACK)&&square[fin_i][fin_j].getToolTipText()==null) 
						{
							if(!bp2.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(B_Pawn2);
								square[fin_i][fin_j].setToolTipText("B.Pawn2");
								return 0;
							}
							else
							{
								makequeen(fin_i,fin_j,bp2,"b2");
								return 0;
							}
						}
					}
					else if(square[fin_i][fin_j].getToolTipText() != null)
					{
						if(bp2.isValidMove2(fin_i,fin_j,PieceColor.BLACK))
						{
							if(!bp2.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(B_Pawn2);
								square[fin_i][fin_j].setToolTipText("B.Pawn2");
								return 0;
							}
							else
							{
								makequeen(fin_i,fin_j,bp2,"b2");
								return 0;
							}
						}	
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Pawn3"))
				{
					if(init_j==fin_j)
					{
						if(bp3.isValidMove1(fin_i,PieceColor.BLACK)&&square[fin_i][fin_j].getToolTipText()==null) 
						{
							if(!bp3.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(B_Pawn3);
								square[fin_i][fin_j].setToolTipText("B.Pawn3");
								return 0;
							}
							else
							{
								makequeen(fin_i,fin_j,bp3,"b3");
								return 0;
							}
						}
					}
					else if(square[fin_i][fin_j].getToolTipText() != null)
					{
						if(bp3.isValidMove2(fin_i,fin_j,PieceColor.BLACK)) 
						{
							if(!bp3.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(B_Pawn3);
								square[fin_i][fin_j].setToolTipText("B.Pawn3");
								return 0;
							}
							else
							{
								makequeen(fin_i,fin_j,bp3,"b3");
								return 0;
							}
						}
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Pawn4"))
				{
					if(init_j==fin_j)
					{
						if(bp4.isValidMove1(fin_i,PieceColor.BLACK)&&square[fin_i][fin_j].getToolTipText()==null) 
						{
							if(!bp4.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(B_Pawn4);
								square[fin_i][fin_j].setToolTipText("B.Pawn4");
								return 0;
							}
							else
							{
								makequeen(fin_i,fin_j,bp4,"b4");
								return 0;
							}
						}
					}
					else if(square[fin_i][fin_j].getToolTipText() != null)
					{
						if(bp4.isValidMove2(fin_i,fin_j,PieceColor.BLACK)) 
						{
							if(!bp4.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(B_Pawn4);
								square[fin_i][fin_j].setToolTipText("B.Pawn4");
								return 0;
							}
							else
							{
								makequeen(fin_i,fin_j,bp4,"b4");
								return 0;
							}
						}
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Pawn5"))
				{
					if(init_j==fin_j)
					{
						if(bp5.isValidMove1(fin_i,PieceColor.BLACK)&&square[fin_i][fin_j].getToolTipText()==null) 
						{
							if(!bp5.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(B_Pawn5);
								square[fin_i][fin_j].setToolTipText("B.Pawn5");
								return 0;
							}
							else
							{
								makequeen(fin_i,fin_j,bp5,"b5");
								return 0;
							}
						}
					}
					else if(square[fin_i][fin_j].getToolTipText() != null)
					{
						if(bp5.isValidMove2(fin_i,fin_j,PieceColor.BLACK)) 
						{
							if(!bp5.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(B_Pawn5);
								square[fin_i][fin_j].setToolTipText("B.Pawn5");
								return 0;
							}
							else
							{
								makequeen(fin_i,fin_j,bp5,"b5");
								return 0;
							}
						}
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Pawn6"))
				{
					if(init_j==fin_j)
					{
						if(bp6.isValidMove1(fin_i,PieceColor.BLACK)&&square[fin_i][fin_j].getToolTipText()==null) 
						{
							if(!bp6.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(B_Pawn6);
								square[fin_i][fin_j].setToolTipText("B.Pawn6");
								return 0;
							}
							else
							{
								makequeen(fin_i,fin_j,bp6,"b6");
								return 0;
							}
						}
					}
					else if(square[fin_i][fin_j].getToolTipText() != null)
					{
						if(bp6.isValidMove2(fin_i,fin_j,PieceColor.BLACK)) {
							if(!bp6.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(B_Pawn6);
								square[fin_i][fin_j].setToolTipText("B.Pawn6");
								return 0;
							}
							else
							{
								makequeen(fin_i,fin_j,bp6,"b6");
								return 0;
							}
						}
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Pawn7"))
				{
					if(init_j==fin_j)
					{
						if(bp7.isValidMove1(fin_i,PieceColor.BLACK)&&square[fin_i][fin_j].getToolTipText()==null)
						{
							if(!bp7.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(B_Pawn7);
								square[fin_i][fin_j].setToolTipText("B.Pawn7");
							return 0;
						}
						else
						{
							makequeen(fin_i,fin_j,bp7,"b7");
								return 0;
							}
					}
					else if(square[fin_i][fin_j].getToolTipText() != null)
					{
						if(bp7.isValidMove2(fin_i,fin_j,PieceColor.BLACK))
						{
							if(!bp7.isqueen())
							{
							square[init_i][init_j].setIcon(null);
							square[init_i][init_j].setToolTipText(null);
							board.move(from, to);
							square[fin_i][fin_j].setIcon(B_Pawn7);
							square[fin_i][fin_j].setToolTipText("B.Pawn7");
								return 0;
							}
							else
							{
								makequeen(fin_i,fin_j,bp7,"b7");
								return 0;
							}
						}	
					}
					return 1;
				}
				if(square[init_i][init_j].getToolTipText().equals("B.Pawn8"))
				{
					if(init_j==fin_j)
					{
						if(bp8.isValidMove1(fin_i,PieceColor.BLACK)&&square[fin_i][fin_j].getToolTipText()==null) 
						{
							if(!bp8.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(B_Pawn8);
								square[fin_i][fin_j].setToolTipText("B.Pawn8");
								return 0;
							}
							else
							{
								makequeen(fin_i,fin_j,bp8,"b8");
								return 0;
							}
						}
					}
					else if(square[fin_i][fin_j].getToolTipText() != null)
					{
						if(bp8.isValidMove2(fin_i,fin_j,PieceColor.BLACK))
						{
							if(!bp8.isqueen())
							{
								square[init_i][init_j].setIcon(null);
								square[init_i][init_j].setToolTipText(null);
								board.move(from, to);
								square[fin_i][fin_j].setIcon(B_Pawn8);
								square[fin_i][fin_j].setToolTipText("B.Pawn8");
								return 0;
							}
							else
							{
								makequeen(fin_i,fin_j,bp8,"b8");
								return 0;
							}
						}
					}
					return 1;
				}
			}
			return 1;
		}
		}
		return 1;
	}
		
	static int flag2=0;
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
				flag2=processClick(initx,inity,desx,desy,flag2);
			}
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	}
}