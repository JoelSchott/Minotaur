package minotaur;

import java.util.*;

public class Cell {
	
	public Cell(ArrayList<Integer> loc, int i){
		if (loc.size() == 2){
			location = loc;
		}
		id = i;
	}
	
	final static int HEDGE = 0;
	final static int WALL = 1;
	final static int PLAYER = 2;
	final static int MINOTAR = 3;
	final static int TEMPLE = 4;
	
	private ArrayList<Integer> contents = new ArrayList<Integer>();
	private ArrayList<Integer> location = new ArrayList<Integer>();
	
	private int id;
	
	private String base = null;
	private boolean start = false;
	private boolean end = false;
	
	public boolean isEmpty(){
		if (contents.size() == 0){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int getID(){
		return id;
	}
	public void setAsStart(){
		start = true;
	}
	public void setAsTarget(){
		end = true;
	}
	public boolean isStart(){
		return start;
	}
	public boolean isTarget(){
		return end;
	}	
	public void setBase(String s){
		base = s;
	}
	public String getBase(){
		return base;
	}
	public ArrayList<Integer> getLocation(){
		return location;
	}
	public void add(int i){
		contents.add(i);
	}
	public void remove(int i){
		if (contents.contains(i)){
			contents.remove((Integer)i);
		}
		else{
			System.out.println("was not in cell to remove");
		}
	}
	public boolean contains(int item){
		if (contents.contains(item)){
			return true;
		}
		else{
			return false;
		}
	}

}
