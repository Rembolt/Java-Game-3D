package Main;

import org.lwjgl.glfw.GLFW;

import RenderEngine.io.Input;
import RenderEngine.maths.Vector3f;

public class PlayerActions {
	Main main;
	
	public PlayerActions(Main main) {
		super();
		this.main = main;
	}


	public static void main(String[] args) {
		 try
	      {
	        // Delay for 7
	        Thread.sleep(3000);   
	      }
	      catch(InterruptedException ex)
	      {
	          ex.printStackTrace();
	      }

	}

	
	public void blocky() {
		if (Input.isButtonDown(GLFW.GLFW_MOUSE_BUTTON_LEFT)) {
			Vector3f point = main.ray.getPointOnRay(main.ray.getCurrentRay(), 2);
						
			if(point.getX() < 100 && point.getX() > 0) 
				if(point.getY() < 100&& point.getY() > 0)
					if(point.getZ() < 100&& point.getZ() > 0) {	
						if(main.chunk[Math.round(point.getX())][Math.round(point.getY())][Math.round(point.getZ())].getMesh() != main.air) {
							main.chunk[Math.round(point.getX())][Math.round(point.getY())][Math.round(point.getZ())].setMesh(main.air);
					
						}else {
							main.chunk[Math.round(point.getX())][Math.round(point.getY())][Math.round(point.getZ())].setMesh(main.dirt);
										
						}
		
		
					}
		 }
	}
	

}
