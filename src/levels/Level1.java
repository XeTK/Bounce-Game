package levels;

public enum Level1 implements Level
{
	b1(10, 35), b2(60, 35), b3(110, 35), b4(160, 35), b5(210, 35), b6(260, 35), b7(
			310, 35), b8(360, 35), b9(410, 35), b10(460, 35), b11(510, 35), b12(
			560, 35), b13(610, 35), b14(660, 35), b15(710, 35), b16(760, 35), b17(
			810, 35), b18(860, 35), b19(910, 35), b20(10, 60), b21(60, 60), b22(
			110, 60), b23(160, 60), b24(210, 60), b25(260, 60), b26(310, 60), b27(
			360, 60), b28(410, 60), b29(460, 60), b30(510, 60), b31(560, 60), b32(
			610, 60), b33(660, 60), b34(710, 60), b60(760, 60), b36(810, 60), b37(
			860, 60), b38(910, 60);
	private int posX = 0;
	private int posY = 0;

	private Level1(int posX, int posY)
	{
		this.posX = posX;
		this.posY = posY;
	}

	public int getPosX()
	{
		return posX;
	}

	public int getPosY()
	{
		return posY;
	}
}
