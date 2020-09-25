package engine;

//import java.awt.Graphics2D;

import engine.GameObjectSystem.FunctionalInterfaces.TimeRenderCallback;
import engine.GameObjectSystem.FunctionalInterfaces.TimeUpdateCallback;
import engine.GameObjectSystem.FunctionalInterfaces.VoidNoArg;

public class Time {
	public static boolean running = false;
	public static long INIT_TIME;
	
	public static double time = 0;
	public static double timeMilli = 0;
	public static long timeNano = 0;
	
	public static double currentTime = 0;
	public static double currentTimeMilli = 0;
	public static long currentTimeNano = 0;	
	
	public static double delta = 0;
	public static double deltaMilli = 0;
	public static long deltaNano = 0;
	
	public static double rate = 1d/60d;
	public static double fps = 0;
	public static double accumulator = 0;
	public static long tick = 0;
	public static double frameRate = 240d;
	
	public static double timeScale = 1;
	
	private static VoidNoArg			initFunc;
	private static TimeUpdateCallback	updateFunc;
	private static TimeRenderCallback	drawFunc;
	private static VoidNoArg			cleanup;

	private static void init() {
		initFunc.invoke();
	}
	private static void cleanup() {
		cleanup.invoke();
	}
	private static void update(double rate) {
		updateFunc.update(rate);
	}
	private static void draw() {
		drawFunc.draw();
	}

	public static void setInitFunction(VoidNoArg initFunc) {
		Time.initFunc = initFunc;
	}
	public static void setUpdateFunction(TimeUpdateCallback updateFunc) {
		Time.updateFunc = updateFunc;
	}
	public static void setDrawFunction(TimeRenderCallback drawFunc) {
		Time.drawFunc = drawFunc;
	}
	public static void setCleanupFunction(VoidNoArg cleanup) {
		Time.cleanup = cleanup;
	}

	public static double getTimeNano() {
		return System.nanoTime() - INIT_TIME;
	}
	public static double getTimeMilli() {
		return (double) getTimeNano() / 1000000d;
	}
	public static double getTime() {
		return getTimeMilli() / 1000d;
	}
	
	private static double step() {
		double newTime = getTime();
		double dt = newTime - currentTime;
		currentTime = newTime;
		return dt;
	}
	
	public static void run() {
		init();
		
		running = true;
		
		double lastFrame = 0d;

		INIT_TIME = System.nanoTime();
		
		while (running) {
			delta = step();
			deltaMilli = delta*1000d;
			deltaNano = (long) (delta*1000000d*1000d);
//			System.out.printf("--[%f %f\n", accumulator, dt);

			accumulator += delta;
			while (accumulator >= rate) {
				accumulator -= rate;
				tick += 1;
				update(rate);
			}
//			System.out.printf("   %f %f]--\n", accumulator, dt);
			while ((getTime() - lastFrame) < (1d / frameRate)) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			lastFrame =  getTime();
			
			draw();
			
			try {
				Thread.sleep(1, 0);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			fps = 1/delta;
		}
		
		cleanup();
	}
	
	public static void end() {
		running = false;
	}
}
