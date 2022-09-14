package game;

public class coin {

	private  player [] arr ;
	private  player current ;
	

	public coin(player player1 , player player2) {
		arr = new player[2];
		arr[0] =player1;
		arr[1]=player2;
	} 

	public player getCurrent() {
		return current;
	}
	public void setCurrent(player current) {
		this.current = current;
	}
	public void Flip() {
		int random = (int) (Math.random()*100) ;
		if (random < 50) {
			current = arr[0];
			
		}

		else {
			current = arr[1];
			
		}
	}

	

	public void turn() {
		if (current == arr[0])
			current = arr[1];
		else 
			current = arr[0];
	}

	

}
