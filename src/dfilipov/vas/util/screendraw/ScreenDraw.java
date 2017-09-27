package dfilipov.vas.util.screendraw;

import static dfilipov.vas.GameAgent.WINDOW_HEIGHT;
import static dfilipov.vas.GameAgent.WINDOW_WIDTH;
import org.lwjgl.opengl.GL11;

public class ScreenDraw
{
	private ScreenDraw()
	{
	}
	
	public static void drawDarkOverlay()
	{
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glColor4f(0.0f, 0.0f, 0.0f, 0.5f);
		GL11.glVertex2f(-WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2);
		GL11.glVertex2f(WINDOW_WIDTH / 2, WINDOW_HEIGHT / 2);
		GL11.glVertex2f(WINDOW_WIDTH / 2, -WINDOW_HEIGHT / 2);
		GL11.glVertex2f(-WINDOW_WIDTH / 2, -WINDOW_HEIGHT / 2);
		GL11.glEnd();
	}
	
	public static void drawPauseScreen(float xStart)
	{
		drawDarkOverlay();
		GL11.glColor3f(1.0f, 1.0f, 1.0f);
		
		// P
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 0.0f);
		GL11.glVertex2f(xStart, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 0.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2.0f, 23.0f);
		GL11.glVertex2f(xStart + 2.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 23.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 10.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 14.0f);
		GL11.glVertex2f(xStart + 10.0f, 14.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2.0f, 14.0f);
		GL11.glVertex2f(xStart + 12.0f, 14.0f);
		GL11.glVertex2f(xStart + 12.0f, 12.0f);
		GL11.glVertex2f(xStart + 2.0f, 12.0f);
		GL11.glEnd();
		
		xStart += 32.0f;
		
		// A
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 0.0f);
		GL11.glVertex2f(xStart, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 0.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2.0f, 23.0f);
		GL11.glVertex2f(xStart + 2.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 23.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 10.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 0.0f);
		GL11.glVertex2f(xStart + 10.0f, 0.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2.0f, 14.0f);
		GL11.glVertex2f(xStart + 12.0f, 14.0f);
		GL11.glVertex2f(xStart + 12.0f, 12.0f);
		GL11.glVertex2f(xStart + 2.0f, 12.0f);
		GL11.glEnd();
		
		xStart += 32.0f;
		
		// U
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 0.0f);
		GL11.glVertex2f(xStart, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 0.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2.0f, 0.0f);
		GL11.glVertex2f(xStart + 2.0f, 2.0f);
		GL11.glVertex2f(xStart + 10.0f, 2.0f);
		GL11.glVertex2f(xStart + 10.0f, 0.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 10.0f, 0.0f);
		GL11.glVertex2f(xStart + 10.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 0.0f);
		GL11.glEnd();
		
		xStart += 32.0f;
		
		// S
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 0.0f);
		GL11.glVertex2f(xStart, 2.0f);
		GL11.glVertex2f(xStart + 12.0f, 2.0f);
		GL11.glVertex2f(xStart + 12.0f, 0.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 10.0f, 2.0f);
		GL11.glVertex2f(xStart + 10.0f, 11.5f);
		GL11.glVertex2f(xStart + 12.0f, 11.5f);
		GL11.glVertex2f(xStart + 12.0f, 2.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 11.5f);
		GL11.glVertex2f(xStart, 13.5f);
		GL11.glVertex2f(xStart + 12.0f, 13.5f);
		GL11.glVertex2f(xStart + 12.0f, 11.5f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 13.5f);
		GL11.glVertex2f(xStart, 25.0f);
		GL11.glVertex2f(xStart + 2, 25.0f);
		GL11.glVertex2f(xStart + 2, 13.5f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2, 23.0f);
		GL11.glVertex2f(xStart + 2, 25.0f);
		GL11.glVertex2f(xStart + 12, 25.0f);
		GL11.glVertex2f(xStart + 12, 23.0f);
		GL11.glEnd();
		
		xStart += 32.0f;
		
		// E
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 0.0f);
		GL11.glVertex2f(xStart, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 0.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2, 0.0f);
		GL11.glVertex2f(xStart + 2, 2.0f);
		GL11.glVertex2f(xStart + 12.0f, 2.0f);
		GL11.glVertex2f(xStart + 12.0f, 0.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2, 11.5f);
		GL11.glVertex2f(xStart + 2, 13.5f);
		GL11.glVertex2f(xStart + 12.0f, 13.5f);
		GL11.glVertex2f(xStart + 12.0f, 11.5f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2, 23.0f);
		GL11.glVertex2f(xStart + 2, 25.0f);
		GL11.glVertex2f(xStart + 12, 25.0f);
		GL11.glVertex2f(xStart + 12, 23.0f);
		GL11.glEnd();
	}
	
	public static void drawVictoryScreen(float xStart)
	{
		drawDarkOverlay();
		GL11.glColor3f(1.0f, 1.0f, 0.0f);
		
		// V
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 25f);
		GL11.glVertex2f(xStart + 2f, 25f);
		GL11.glVertex2f(xStart + 2f, 18f);
		GL11.glVertex2f(xStart, 18f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 10f, 25f);
		GL11.glVertex2f(xStart + 12f, 25f);
		GL11.glVertex2f(xStart + 12f, 18f);
		GL11.glVertex2f(xStart + 10f, 18f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2f, 18f);
		GL11.glVertex2f(xStart + 4f, 18f);
		GL11.glVertex2f(xStart + 4f, 6f);
		GL11.glVertex2f(xStart + 2f, 6f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 8f, 18f);
		GL11.glVertex2f(xStart + 10f, 18f);
		GL11.glVertex2f(xStart + 10f, 6f);
		GL11.glVertex2f(xStart + 8f, 6f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 4f, 6f);
		GL11.glVertex2f(xStart + 6f, 6f);
		GL11.glVertex2f(xStart + 6f, 0f);
		GL11.glVertex2f(xStart + 4f, 0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 6f, 6f);
		GL11.glVertex2f(xStart + 8f, 6f);
		GL11.glVertex2f(xStart + 8f, 0f);
		GL11.glVertex2f(xStart + 6f, 0f);
		GL11.glEnd();
		
		xStart += 32f;
		
		// I
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 5f, 25f);
		GL11.glVertex2f(xStart + 7f, 25f);
		GL11.glVertex2f(xStart + 7f, 0f);
		GL11.glVertex2f(xStart + 5f, 0f);
		GL11.glEnd();
		
		xStart += 32f;
		
		// C
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 0f);
		GL11.glVertex2f(xStart, 2f);
		GL11.glVertex2f(xStart + 12f, 2f);
		GL11.glVertex2f(xStart + 12f, 0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 23f);
		GL11.glVertex2f(xStart, 25f);
		GL11.glVertex2f(xStart + 12f, 25f);
		GL11.glVertex2f(xStart + 12f, 23f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 0f, 23f);
		GL11.glVertex2f(xStart + 2f, 23f);
		GL11.glVertex2f(xStart + 2f, 2f);
		GL11.glVertex2f(xStart + 0f, 2f);
		GL11.glEnd();
		
		xStart += 32f;
		
		// T
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 23f);
		GL11.glVertex2f(xStart, 25f);
		GL11.glVertex2f(xStart + 12f, 25f);
		GL11.glVertex2f(xStart + 12f, 23f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 5f, 23f);
		GL11.glVertex2f(xStart + 7f, 23f);
		GL11.glVertex2f(xStart + 7f, 0f);
		GL11.glVertex2f(xStart + 5f, 0f);
		GL11.glEnd();
		
		xStart += 32f;
		
		// O
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 0f);
		GL11.glVertex2f(xStart, 2f);
		GL11.glVertex2f(xStart + 12f, 2f);
		GL11.glVertex2f(xStart + 12f, 0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 23f);
		GL11.glVertex2f(xStart, 25f);
		GL11.glVertex2f(xStart + 12f, 25f);
		GL11.glVertex2f(xStart + 12f, 23f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 0f, 23f);
		GL11.glVertex2f(xStart + 2f, 23f);
		GL11.glVertex2f(xStart + 2f, 2f);
		GL11.glVertex2f(xStart + 0f, 2f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 10f, 23f);
		GL11.glVertex2f(xStart + 12f, 23f);
		GL11.glVertex2f(xStart + 12f, 2f);
		GL11.glVertex2f(xStart + 10f, 2f);
		GL11.glEnd();
		
		xStart += 32f;
		
		// R
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 0.0f);
		GL11.glVertex2f(xStart, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 0.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2.0f, 23.0f);
		GL11.glVertex2f(xStart + 2.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 23.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 10.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 14.0f);
		GL11.glVertex2f(xStart + 10.0f, 14.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2.0f, 14.0f);
		GL11.glVertex2f(xStart + 12.0f, 14.0f);
		GL11.glVertex2f(xStart + 12.0f, 12.0f);
		GL11.glVertex2f(xStart + 2.0f, 12.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 6f, 12f);
		GL11.glVertex2f(xStart + 8f, 12f);
		GL11.glVertex2f(xStart + 8f, 6f);
		GL11.glVertex2f(xStart + 6f, 6f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 8f, 6f);
		GL11.glVertex2f(xStart + 10f, 6f);
		GL11.glVertex2f(xStart + 10f, 0f);
		GL11.glVertex2f(xStart + 8f, 0f);
		GL11.glEnd();
		
		xStart += 32f;
		
		// Y
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 10.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 14.0f);
		GL11.glVertex2f(xStart + 10.0f, 14.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 14.0f);
		GL11.glVertex2f(xStart, 14.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 14.0f);
		GL11.glVertex2f(xStart + 12.0f, 14.0f);
		GL11.glVertex2f(xStart + 12.0f, 12.0f);
		GL11.glVertex2f(xStart, 12.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 5f, 12f);
		GL11.glVertex2f(xStart + 7f, 12f);
		GL11.glVertex2f(xStart + 7f, 0f);
		GL11.glVertex2f(xStart + 5f, 0f);
		GL11.glEnd();
	}
	
	public static void drawGameOverScreen(float xStart)
	{
		drawDarkOverlay();
		GL11.glColor3f(1.0f, 0.0f, 0.0f);
		
		// G
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 0f);
		GL11.glVertex2f(xStart, 2f);
		GL11.glVertex2f(xStart + 12f, 2f);
		GL11.glVertex2f(xStart + 12f, 0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 23f);
		GL11.glVertex2f(xStart, 25f);
		GL11.glVertex2f(xStart + 12f, 25f);
		GL11.glVertex2f(xStart + 12f, 23f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 0f, 23f);
		GL11.glVertex2f(xStart + 2f, 23f);
		GL11.glVertex2f(xStart + 2f, 2f);
		GL11.glVertex2f(xStart + 0f, 2f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 10f, 12f);
		GL11.glVertex2f(xStart + 12f, 12f);
		GL11.glVertex2f(xStart + 12f, 2f);
		GL11.glVertex2f(xStart + 10f, 2f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 10f, 12f);
		GL11.glVertex2f(xStart + 10f, 10f);
		GL11.glVertex2f(xStart + 6f, 10f);
		GL11.glVertex2f(xStart + 6f, 12f);
		GL11.glEnd();
		
		xStart += 32f;
		
		// A
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 0.0f);
		GL11.glVertex2f(xStart, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 0.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2.0f, 23.0f);
		GL11.glVertex2f(xStart + 2.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 23.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 10.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 0.0f);
		GL11.glVertex2f(xStart + 10.0f, 0.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2.0f, 14.0f);
		GL11.glVertex2f(xStart + 12.0f, 14.0f);
		GL11.glVertex2f(xStart + 12.0f, 12.0f);
		GL11.glVertex2f(xStart + 2.0f, 12.0f);
		GL11.glEnd();
		
		xStart += 32f;
		
		// M
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 23f);
		GL11.glVertex2f(xStart, 25f);
		GL11.glVertex2f(xStart + 12f, 25f);
		GL11.glVertex2f(xStart + 12f, 23f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 5f, 23f);
		GL11.glVertex2f(xStart + 7f, 23f);
		GL11.glVertex2f(xStart + 7f, 0f);
		GL11.glVertex2f(xStart + 5f, 0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 23f);
		GL11.glVertex2f(xStart + 2f, 23f);
		GL11.glVertex2f(xStart + 2f, 0f);
		GL11.glVertex2f(xStart, 0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 10f, 23f);
		GL11.glVertex2f(xStart + 12f, 23f);
		GL11.glVertex2f(xStart + 12f, 0f);
		GL11.glVertex2f(xStart + 10f, 0f);
		GL11.glEnd();
		
		xStart += 32f;
		
		// E
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 0.0f);
		GL11.glVertex2f(xStart, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 0.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2, 0.0f);
		GL11.glVertex2f(xStart + 2, 2.0f);
		GL11.glVertex2f(xStart + 12.0f, 2.0f);
		GL11.glVertex2f(xStart + 12.0f, 0.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2, 11.5f);
		GL11.glVertex2f(xStart + 2, 13.5f);
		GL11.glVertex2f(xStart + 12.0f, 13.5f);
		GL11.glVertex2f(xStart + 12.0f, 11.5f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2, 23.0f);
		GL11.glVertex2f(xStart + 2, 25.0f);
		GL11.glVertex2f(xStart + 12, 25.0f);
		GL11.glVertex2f(xStart + 12, 23.0f);
		GL11.glEnd();
		
		xStart += 76f;
		
		// O
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 0f);
		GL11.glVertex2f(xStart, 2f);
		GL11.glVertex2f(xStart + 12f, 2f);
		GL11.glVertex2f(xStart + 12f, 0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 23f);
		GL11.glVertex2f(xStart, 25f);
		GL11.glVertex2f(xStart + 12f, 25f);
		GL11.glVertex2f(xStart + 12f, 23f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 0f, 23f);
		GL11.glVertex2f(xStart + 2f, 23f);
		GL11.glVertex2f(xStart + 2f, 2f);
		GL11.glVertex2f(xStart + 0f, 2f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 10f, 23f);
		GL11.glVertex2f(xStart + 12f, 23f);
		GL11.glVertex2f(xStart + 12f, 2f);
		GL11.glVertex2f(xStart + 10f, 2f);
		GL11.glEnd();
		
		xStart += 32f;
		
		// V
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 25f);
		GL11.glVertex2f(xStart + 2f, 25f);
		GL11.glVertex2f(xStart + 2f, 18f);
		GL11.glVertex2f(xStart, 18f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 10f, 25f);
		GL11.glVertex2f(xStart + 12f, 25f);
		GL11.glVertex2f(xStart + 12f, 18f);
		GL11.glVertex2f(xStart + 10f, 18f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2f, 18f);
		GL11.glVertex2f(xStart + 4f, 18f);
		GL11.glVertex2f(xStart + 4f, 6f);
		GL11.glVertex2f(xStart + 2f, 6f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 8f, 18f);
		GL11.glVertex2f(xStart + 10f, 18f);
		GL11.glVertex2f(xStart + 10f, 6f);
		GL11.glVertex2f(xStart + 8f, 6f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 4f, 6f);
		GL11.glVertex2f(xStart + 6f, 6f);
		GL11.glVertex2f(xStart + 6f, 0f);
		GL11.glVertex2f(xStart + 4f, 0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 6f, 6f);
		GL11.glVertex2f(xStart + 8f, 6f);
		GL11.glVertex2f(xStart + 8f, 0f);
		GL11.glVertex2f(xStart + 6f, 0f);
		GL11.glEnd();
		
		xStart += 32f;
		
		// E
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 0.0f);
		GL11.glVertex2f(xStart, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 0.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2, 0.0f);
		GL11.glVertex2f(xStart + 2, 2.0f);
		GL11.glVertex2f(xStart + 12.0f, 2.0f);
		GL11.glVertex2f(xStart + 12.0f, 0.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2, 11.5f);
		GL11.glVertex2f(xStart + 2, 13.5f);
		GL11.glVertex2f(xStart + 12.0f, 13.5f);
		GL11.glVertex2f(xStart + 12.0f, 11.5f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2, 23.0f);
		GL11.glVertex2f(xStart + 2, 25.0f);
		GL11.glVertex2f(xStart + 12, 25.0f);
		GL11.glVertex2f(xStart + 12, 23.0f);
		GL11.glEnd();
		
		xStart += 32f;
		
		// R
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart, 0.0f);
		GL11.glVertex2f(xStart, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 25.0f);
		GL11.glVertex2f(xStart + 2.0f, 0.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2.0f, 23.0f);
		GL11.glVertex2f(xStart + 2.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 23.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 10.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 25.0f);
		GL11.glVertex2f(xStart + 12.0f, 14.0f);
		GL11.glVertex2f(xStart + 10.0f, 14.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 2.0f, 14.0f);
		GL11.glVertex2f(xStart + 12.0f, 14.0f);
		GL11.glVertex2f(xStart + 12.0f, 12.0f);
		GL11.glVertex2f(xStart + 2.0f, 12.0f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 6f, 12f);
		GL11.glVertex2f(xStart + 8f, 12f);
		GL11.glVertex2f(xStart + 8f, 6f);
		GL11.glVertex2f(xStart + 6f, 6f);
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glVertex2f(xStart + 8f, 6f);
		GL11.glVertex2f(xStart + 10f, 6f);
		GL11.glVertex2f(xStart + 10f, 0f);
		GL11.glVertex2f(xStart + 8f, 0f);
		GL11.glEnd();
		
	}
}
