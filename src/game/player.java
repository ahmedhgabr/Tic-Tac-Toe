package game;

public class player  {
	
	private String Name;
	private int Points;


	public player (String Name) {
		this.Name= Name;
		Points=0;
	}

	public int getPoints() {
		return Points;
	}

	public void setPoints(int points) {
		Points = points;
	}

	public String getName() {
		return Name;
	}
	
	
}

