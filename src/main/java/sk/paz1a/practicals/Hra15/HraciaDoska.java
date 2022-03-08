package sk.paz1a.practicals.Hra15;

import sk.upjs.jpaz2.ImageTurtleShape;
import sk.upjs.jpaz2.Turtle;
import sk.upjs.jpaz2.WinPane;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class HraciaDoska extends WinPane {
	private static final int HEIGHT = 608;
	private static final int WIDTH = 608;
	private static final int CELL_SIZE = 152;
	Turtle znacka = new Turtle();
	private boolean hraBezi = true;
	private int xSource = 0;
	private int ySource = 0;
	private int xTarget = 0;
	private int yTarget = 0;
	private int[][] hraciaDoska = new int[4][4];
	private int casZaciatkuHry = 0;
	private int casKoncaHry = 0;

	public HraciaDoska() {
		casZaciatkuHry = Cas.spocitajCasHry();
		do {
			this.zmenRozmer();
			int value = 1;
			for (int i = 0; i < hraciaDoska.length; i++) {
				for (int j = 0; j < hraciaDoska[i].length; j++) {
					hraciaDoska[i][j] = value;
					value++;
				}
			}
			for (int i = 0; i < 50; i++) {
				this.shuffleArray(hraciaDoska);
			}
			this.rozstavNaMiesta();
			this.kreslic();
		} while (!(isSolvable()));
		hraBezi = true;
	}

	// vypise do konzoly maticu 4 x 4 naplnenú číslami od 1 do 16
	public void printArray() {
		for (int i = 0; i < hraciaDoska.length; i++) {
			for (int j = 0; j < hraciaDoska[i].length; j++) {
				System.out.print(hraciaDoska[i][j] + "\t");
			}
			System.out.print("\n");
		}
	}

	// zamení dve čísla na nahodne pozicie
	public void shuffleArray(int[][] a) {
		int b = (int) ((Math.random()) * 4);
		int c = (int) ((Math.random()) * 4);
		int d = (int) ((Math.random()) * 4);
		int e = (int) ((Math.random()) * 4);
		swap(a, b, c, d, e);
	}

	// zamení dve čísla
	private void swap(int[][] a, int i, int j, int change, int change1) {
		int temp = a[i][j];
		a[i][j] = a[change][change1];
		a[change][change1] = temp;
	}

	// nakresli cervene ciary
	public void kreslic() {
		Turtle rabotyaga = new Turtle();
		this.add(rabotyaga);
		rabotyaga.setPenWidth(3);
		rabotyaga.setPenColor(Color.RED);
		for (int i = 1; i < 5; i++) {
			rabotyaga.setPosition(i * CELL_SIZE, 0);
			rabotyaga.moveTo(i * CELL_SIZE, this.getHeight());
		}
		for (int i = 1; i < 5; i++) {
			rabotyaga.setPosition(0, i * CELL_SIZE);
			rabotyaga.moveTo(this.getWidth(), i * CELL_SIZE);
		}
		this.remove(rabotyaga);
	}

	// zmeni rozmer hracieho polia
	public void zmenRozmer() {
		this.setResizable(false);
		this.setTitle("Hra15 UPJŠ");
		this.setHeight(HEIGHT);
		this.setWidth(WIDTH);
		this.setPosition(650, 150);
	}

	// v každej bunke sa zobrazí obrázok so zodpovedajúcim číslom
	public void rozstavNaMiesta() {
		this.add(znacka);

		for (int i = 0; i < hraciaDoska.length; i++) {
			for (int j = 0; j < hraciaDoska[i].length; j++) {
				if (hraciaDoska[i][j] == 1) {
					c1((j * CELL_SIZE) + 76, (i * CELL_SIZE) + 76);
				}
				if (hraciaDoska[i][j] == 2) {

					c2((j * CELL_SIZE) + 76, (i * CELL_SIZE) + 76);

				}
				if (hraciaDoska[i][j] == 3) {
					c3((j * CELL_SIZE) + 76, (i * CELL_SIZE) + 76);

				}
				if (hraciaDoska[i][j] == 4) {

					c4((j * CELL_SIZE) + 76, (i * CELL_SIZE) + 76);

				}
				if (hraciaDoska[i][j] == 5) {
					c5((j * CELL_SIZE) + 76, (i * CELL_SIZE) + 76);

				}
				if (hraciaDoska[i][j] == 6) {
					c6((j * CELL_SIZE) + 76, (i * CELL_SIZE) + 76);

				}
				if (hraciaDoska[i][j] == 7) {
					c7((j * CELL_SIZE) + 76, (i * CELL_SIZE) + 76);

				}
				if (hraciaDoska[i][j] == 8) {
					c8((j * CELL_SIZE) + 76, (i * CELL_SIZE) + 76);

				}
				if (hraciaDoska[i][j] == 9) {
					c9((j * CELL_SIZE) + 76, (i * CELL_SIZE) + 76);

				}
				if (hraciaDoska[i][j] == 10) {
					c10((j * CELL_SIZE) + 76, (i * CELL_SIZE) + 76);

				}
				if (hraciaDoska[i][j] == 11) {
					c11((j * CELL_SIZE) + 76, (i * CELL_SIZE) + 76);

				}
				if (hraciaDoska[i][j] == 12) {
					c12((j * CELL_SIZE) + 76, (i * CELL_SIZE) + 76);

				}
				if (hraciaDoska[i][j] == 13) {
					c13((j * CELL_SIZE) + 76, (i * CELL_SIZE) + 76);

				}
				if (hraciaDoska[i][j] == 14) {
					c14((j * CELL_SIZE) + 76, (i * CELL_SIZE) + 76);

				}
				if (hraciaDoska[i][j] == 15) {
					c15((j * CELL_SIZE) + 76, (i * CELL_SIZE) + 76);

				}
				if (hraciaDoska[i][j] == 16) {
					c16((j * CELL_SIZE) + 76, (i * CELL_SIZE) + 76);

				}
			}
		}
	}

	public void c1(int x, int y) {
		znacka.setShape(new ImageTurtleShape("1.png"));
		znacka.setPosition(x, y);
		znacka.stamp();
	}

	public void c2(int x, int y) {
		znacka.setShape(new ImageTurtleShape("2.png"));
		znacka.setPosition(x, y);
		znacka.stamp();
	}

	public void c3(int x, int y) {
		znacka.setShape(new ImageTurtleShape("3.png"));
		znacka.setPosition(x, y);
		znacka.stamp();
	}

	public void c4(int x, int y) {
		znacka.setShape(new ImageTurtleShape("4.png"));
		znacka.setPosition(x, y);
		znacka.stamp();
	}

	public void c5(int x, int y) {
		znacka.setShape(new ImageTurtleShape("5.png"));
		znacka.setPosition(x, y);
		znacka.stamp();
	}

	public void c6(int x, int y) {
		znacka.setShape(new ImageTurtleShape("6.png"));
		znacka.setPosition(x, y);
		znacka.stamp();
	}

	public void c7(int x, int y) {
		znacka.setShape(new ImageTurtleShape("7.png"));
		znacka.setPosition(x, y);
		znacka.stamp();
	}

	public void c8(int x, int y) {
		znacka.setShape(new ImageTurtleShape("8.png"));
		znacka.setPosition(x, y);
		znacka.stamp();
	}

	public void c9(int x, int y) {
		znacka.setShape(new ImageTurtleShape("9.png"));
		znacka.setPosition(x, y);
		znacka.stamp();
	}

	public void c10(int x, int y) {
		znacka.setShape(new ImageTurtleShape("10.png"));
		znacka.setPosition(x, y);
		znacka.stamp();
	}

	public void c11(int x, int y) {
		znacka.setShape(new ImageTurtleShape("11.png"));
		znacka.setPosition(x, y);
		znacka.stamp();
	}

	public void c12(int x, int y) {
		znacka.setShape(new ImageTurtleShape("12.png"));
		znacka.setPosition(x, y);
		znacka.stamp();
	}

	public void c13(int x, int y) {
		znacka.setShape(new ImageTurtleShape("13.png"));
		znacka.setPosition(x, y);
		znacka.stamp();
	}

	public void c14(int x, int y) {
		znacka.setShape(new ImageTurtleShape("14.png"));
		znacka.setPosition(x, y);
		znacka.stamp();
	}

	public void c15(int x, int y) {
		znacka.setShape(new ImageTurtleShape("15.png"));
		znacka.setPosition(x, y);
		znacka.stamp();

	}

	public void c16(int x, int y) {
		znacka.setShape(new ImageTurtleShape("16.png"));
		znacka.setPosition(x, y);
		znacka.stamp();

	}

	// metoda poveda ci je povoleny tah
	public boolean tahDoCiele(int x, int y) {
		int[][] posuny = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

		for (int smer = 0; smer < posuny.length; smer++) {
			if (jePrazdny(x + posuny[smer][0], y + posuny[smer][1])) {
				return true;
			}
		}
		return false;
	}
	

	public boolean jePrazdny(int row, int column) {
		return jePolicko(column, row) && hraciaDoska[column][row] == 16;
	}

	public boolean jePolicko(int row, int column) {
		return (row >= 0 && column >= 0 && row <= 3 && column <= 3);
	}

	// tato metoda presunie bunku s сislom na prazdne miesto
	public void presun(int xSource, int ySource, int xTarget, int yTarget) {
		int xP = 0;
		int yP = 0;
		// najde poziciu prazdnej bunky
		for (int i = 0; i < hraciaDoska.length; i++) {
			for (int j = 0; j < hraciaDoska[i].length; j++) {
				if (hraciaDoska[i][j] == 16) {
					xP = j;
					yP = i;
				}
			}
			
		}
		
		System.out.println(tahDoCiele(xSource, ySource));
		if (xTarget == xP && yTarget == yP && tahDoCiele(xSource, ySource)) {
			hraciaDoska[yP][xP] = hraciaDoska[ySource][xSource];
			hraciaDoska[ySource][xSource] = 16;
			this.clear();
			rozstavNaMiesta();
			this.kreslic();
			printArray();
		}
	}

	// ak kliklo sa na bunku s cislom tak zapamata ju poziciu
	@Override
	protected void onMousePressed(int x, int y, MouseEvent detail) {
		// ak hra je vyhrana tak zapamata cas kolko pouzivatel hral a zapise ten cas do
		// suboru
		if (hraVyhrana() == true) {
			casKoncaHry = Cas.spocitajCasHry();
			System.out.println("You win");
			File file = new File("result");
			ArrayList<String> list = new ArrayList<String>();
			try (Scanner sc = new Scanner(file)) {
				while (sc.hasNextLine()) {
					list.add(sc.nextLine());
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			String s = "Hra trvala " + String.valueOf((casKoncaHry - casZaciatkuHry)) + " sekonds";
			list.add(s);
			if ((casKoncaHry - casZaciatkuHry) < 60) {
				System.out.println("You played " + (casKoncaHry - casZaciatkuHry) + " sekonds");
			} else {
				System.out.println("You played " + (casKoncaHry - casZaciatkuHry) / 60 + " minutes");
			}
			try (PrintWriter pw = new PrintWriter(file)) {
				for (int i = 0; i < list.size(); i++) {
					pw.println(list.get(i));
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
			System.out.println("\nDo you want to start new game?");
			Scanner keyboard = new Scanner(System.in);
			System.out.println("Y - Yes, N - No");
			String inputKey = keyboard.next();
			if (inputKey.equals("y") || inputKey.equals("Y")) {
				newGame();
			} else {
				System.exit(0);
			}
		}
		xSource = x / CELL_SIZE;
		ySource = y / CELL_SIZE;
		System.out.println("PRESSED [" + xSource + ", " + ySource + "]");

	}

	// ked sa tlacidlo uvolnilo, zapamata poziciu kde sa uvolnilo tlacidlo a
	// presunie bunku s cislom na prazdne miesto
	@Override
	protected void onMouseReleased(int x, int y, MouseEvent detail) {
		xTarget = x / CELL_SIZE;
		yTarget = y / CELL_SIZE;
		System.out.println("RELEASED [" + xTarget + ", " + yTarget + "]");
		presun(xSource, ySource, xTarget, yTarget);

	}

	// overi ci hra bola vyhrana
	public boolean hraVyhrana() {
		int value = 1;
		for (int i = 0; i < hraciaDoska.length; i++) {
			for (int j = 0; j < hraciaDoska.length; j++) {
				if (hraciaDoska[i][j] == value) {
					value++;
				} else {
					return false;
				}
			}
		}
		return true;
	}

	// zacne novu hru
	public void newGame() {
		do {
			this.zmenRozmer();
			int value = 1;
			for (int i = 0; i < hraciaDoska.length; i++) {
				for (int j = 0; j < hraciaDoska[i].length; j++) {
					hraciaDoska[i][j] = value;
					value++;
				}
			}
			for (int i = 0; i < 50; i++) {
				this.shuffleArray(hraciaDoska);
			}
			this.rozstavNaMiesta();
			this.kreslic();
		} while ((isSolvable()) == false);
		hraBezi = true;

	}

	// tato metoda skontroluje ci je mozne vyhrat
	public boolean isSolvable()
    {
        int spoc = 0;
        ArrayList<Integer> ls = new ArrayList<Integer>();
        for (int i = 0;i< hraciaDoska.length;i++)
        {
            for (int j = 0;j< hraciaDoska[i].length;j++) {
                ls.add(hraciaDoska[i][j]);
            }
        }
        System.out.println(ls.toString());
        for (int i = 0;i<ls.size()-1;i++)
        {
            if(ls.get(i)>ls.get(i+1))
            {
                spoc++;
            }
        }
        Boolean res = false;
        System.out.println("Result = "+spoc);
        if(spoc % 2 == 1)
        {
            res = false;
        }
        else{
            res = true;
        }
        return res;
    }

}