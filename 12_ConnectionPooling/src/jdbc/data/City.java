package jdbc.data;

public class City {
	private String name;
	private int population;
	
	public String getName(){
		return name;
	}
	public void SetName(String name){
		this.name = name;
	}
	public int getPopulation(){
		return population;
	}
	public void setPopulation(int pop){
		this.population = pop;
	}
	public City(){
		
	}
	public City(String n, int p){
		this.name=n;
		this.population=p;
	}

}
