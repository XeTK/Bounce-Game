package player;

public class PlayerObject
{
	private String name = "";
	private int score = 0;
	private int ballsLost = 0;
	private int playLevel = 10;
	public PlayerObject(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getScore()
	{
		return score;
	}
	public void setScore(int score)
	{
		this.score = score;
	}
	public int getBallsLost()
	{
		return ballsLost;
	}
	public void setBallsLost(int ballsLost)
	{
		this.ballsLost = ballsLost;
	}
	public int getPlayLevel()
	{
		return playLevel;
	}
	public void setPlayLevel(int playLevel)
	{
		this.playLevel = playLevel;
	}
	
}
