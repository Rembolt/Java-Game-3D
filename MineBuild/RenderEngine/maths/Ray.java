package RenderEngine.maths;

import RenderEngine.objects.Camera;

public class Ray {
	
	private Matrix4f projectionMatrix;
	private Matrix4f viewMatrix;
	private Vector3f currentRay;
	private Camera camera;

	public Ray(Matrix4f projection, Camera camera) {
		this.camera = camera;
		this.viewMatrix = Matrix4f.view(camera.getPosition(), camera.getRotation());
		this.projectionMatrix = projection;
	}

	public void update() {
		viewMatrix = Matrix4f.view(camera.getPosition(), camera.getRotation());
		currentRay = calculateMouseRay();
	}
	
	private Vector3f calculateMouseRay() {
		Vector4f clipCoords = new Vector4f(0.1f, 0.1f, -1.0f, 1.0f);
		Vector4f eyeCoords = toEyeCoords(clipCoords);
		Vector3f worldRay = toWorldCoords(eyeCoords);
		return worldRay;
	}
	
	private Vector3f toWorldCoords(Vector4f eyeCoords) {
		Matrix4f invertedView = MathsToLibrary.Inverse(viewMatrix);
		Vector4f rayWorld = Matrix4f.transform(invertedView, eyeCoords);
		Vector3f mouseRay = new Vector3f(rayWorld.getX(), rayWorld.getY(), rayWorld.getZ());
		mouseRay = Vector3f.normalize(mouseRay);
		return mouseRay;
	}

	private Vector4f toEyeCoords(Vector4f clipCoords) {
		Matrix4f invertedProjection = MathsToLibrary.Inverse(projectionMatrix);
		Vector4f eyeCoords = Matrix4f.transform(invertedProjection, clipCoords);
		return new Vector4f(eyeCoords.getX(), eyeCoords.getY(), -1f, 0f);
	}
	
	public Vector3f getPointOnRay(Vector3f ray, float distance) {
		Vector3f camPos = camera.getPosition();
		Vector3f start = new Vector3f(camPos.getX(), camPos.getY(), camPos.getZ());
		Vector3f scaledRay = new Vector3f(currentRay.getX() * distance, currentRay.getY() * distance, currentRay.getZ() * distance);
		return Vector3f.add(start, scaledRay);
	}

	
	public Vector3f getCurrentRay() {
		return currentRay ;
	}

	
	/*	double xpos, ypos;
		//getting cursor position
		glfwGetCursorPos(window, &xpos, &ypos);
		std::cout << "Cursor Position at (" << xpos << " : " << ypos << ")" << std::endl;
		std::cout << "Screen Width: " << SCREEN_WIDTH << " Screen Height: " << SCREEN_HEIGHT << std::endl;
		//Normalised
 		float x = (2.0f * xpos) / SCREEN_WIDTH - 1.0f;
		float y = 1.0f - (2.0f * ypos) / SCREEN_HEIGHT;
    	float z = 1.0f;
		glm::vec3 ray_nds = glm::vec3(x, y, z);

		//Clip space
		glm::vec4 ray_clip = glm::vec4(ray_nds.x, ray_nds.y, -1.0, 1.0);
		//Eye Coordinates
		glm::vec4 ray_eye = inverse(projection) * ray_clip;
		ray_eye = glm::vec4(ray_eye.x, ray_eye.y, -1.0, 0.0);

		//World Coordinates    		
            glm::vec3 ray_wor = (inverse(view) * ray_eye);
		ray_wor = normalize(ray_wor);
		std::cout <<"Ray: "<< glm::to_string(ray_wor) << std::endl;
		std::cout << std::endl; 
	*/
	
	
	
}