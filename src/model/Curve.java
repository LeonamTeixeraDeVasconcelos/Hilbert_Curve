package model;

/**
 * 
 * @author Leonam Teixeira de Vasconcelos
 * Class Curve: models a Curve generated by 4 squares, as shown in diagram below
 *
 *
 */

public class Curve implements Comparable<Curve>{
	
	//Define the level of the curve
	public int level;
	
	//Define the code of the curve: 1, 2, 3 or 4
	/*
	 * ....................
	 * 1->........-----....
	 * ...............|....
	 * ...........-----....    
	 * ....................
	 * 2->........-----....
	 * ...........|...|....
	 * ...........|...|....
	 * ....................
	 * 3->........-----....
	 * ...........|........
	 * ...........-----....
	 * ....................
	 * 4->........|...|....
	 * ...........|...|....
	 * ...........-----....
	 * ....................
	 */
	// This code is used for generating new curves from a primitive one
	public int code;
	
	// ID of the curve
	public int id;
	
	/*
	 *................................................................
	 *.........*-----------*-----------*..............................
	 *.........|...........|...........|..............................
	 *.........|......-----|------.....|.............................. 
	 *.........|.....|.....|......|....|.............................. 
	 *.........|.....|.....|......|....|.............................. 
	 *.........*-----------*------|----*.............................. 
	 *.........|.....|.....|......|....|..............................
	 *.........|.....|.....|......|....|.............................. 
	 *.........|.....|.....|......|....|.............................. 
	 *.........|...........|...........|.............................. 
	 *.........*-----------*-----------*.............................. 
	 *................................................................ 
	 */
	//Defining the 4 square the produces one curve
	public Square first_square;
	public Square second_square;
	public Square third_square;
	public Square fourth_square;
	
	//An empty constructor
	public Curve () {}
	
	//An four square constructor
	public Curve (Square first_square, Square second_square, Square third_square, Square fourth_square) {
		this.first_square  = first_square;
		this.second_square = second_square;
		this.third_square  = third_square;
		this.fourth_square = fourth_square;
	}
	
	//Four square + level constructor
	public Curve(int level, Square first_square, Square second_square, Square third_square, Square fourth_square) {
		this(first_square, second_square, third_square, fourth_square);
		this.level = level;
	}
	
	//Four square + level constructor + id
	public Curve(int level, int id, Square first_square, Square second_square, Square third_square, Square fourth_square) {
		this(level, first_square, second_square, third_square, fourth_square);
		this.id = id;
	}
	//Four square + level constructor + id + code	
	public Curve (int code, int level, int id, Square first_square, Square second_square, Square third_square, Square fourth_square) {
		this(level, id, first_square, second_square, third_square, fourth_square);
		this.code  = code;
	}
	
	//toString method for printing
	@Override
	public String toString() {
		return new StringBuilder().append("[level:").append(this.level).append(":id:").append(this.id).append(":code:").append(this.code).append("]").toString();
	}
	
	//equals method
	@Override
	public boolean equals(Object obj) {
		Curve cv = (Curve) obj;
		return (this.first_square.equals(cv.first_square) && this.second_square.equals(cv.second_square) && this.third_square.equals(cv.third_square) && this.fourth_square.equals(cv.fourth_square) && this.level == cv.level);
	}
	
	//Main compareTo method: comparison by level
	@Override
	public int compareTo(Curve o) {
		if(this.level > o.level) {
			return 1;
		}else if(this.level < o.level) {
			return -1;
		}else if(this.level == o.level) {
			return second_compareTo(o);
		}else
			return 0;
	}
	
	//Secondary compareTo method: comparison by id
	public int second_compareTo(Curve o) {
		if(this.id > o.id) {
			return 1;
		}else if(this.id < o.id) {
			return -1;
		}else
			return 0;
	}
}
