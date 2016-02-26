
public class Dice {
	
	String currentFace="";
	int currentPosition=0;
	String allFaces;
	public Dice(String allFaces,int currentPosition) {
		super();
		this.allFaces = allFaces;
		this.currentPosition=currentPosition;
	}
	public String getCurrentFace() {
		return currentFace;
	}
	public void setCurrentFace(String currentFace) {
		this.currentFace = currentFace;
	}
	public int getCurrentPosition() {
		return currentPosition;
	}
	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}
	public String getAllFaces() {
		return allFaces;
	}
	public void setAllFaces(String allFaces) {
		this.allFaces = allFaces;
	}
	
	public String getFace(){
		String f=getCurrentFace();
		if(f.trim().length()==0){
			f=""+allFaces.charAt(currentPosition);
			setCurrentFace(f);
		}
		return f;
	}
	
	public Dice roll(){
		currentPosition=currentPosition+1;
		if(getAllFaces().length()==currentPosition){
			currentPosition=0;
		}
		String f=""+allFaces.charAt(currentPosition);
		setCurrentFace(f);
		return this;
	}
}
