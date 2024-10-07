package RenderEngine.objects;

import RenderEngine.graphics.Mesh;
import RenderEngine.maths.Vector3f;

public class GameObject {
	private Vector3f position, rotation, scale;
	private Mesh mesh;
	
	public GameObject(Vector3f position, Vector3f rotation, Vector3f scale, Mesh mesh) {
		this.position = position;
		this.rotation = rotation;
		this.scale = scale;
		this.mesh = mesh;
	}
	
	public void update() {
		position.setZ(position.getZ() - 0.05f);
	}

	public Vector3f getPosition() {
		return position;
	}
	

	public Vector3f getRotation() {
		return rotation;
	}
	
	public void setPosition(Vector3f position) {
		this.position = position;
	}
	
	public void setScale(Vector3f scale) {
		this.scale = scale;
	}
	
	public void setMesh(Mesh lamesh) {
		this.mesh = lamesh;
	}

	public Vector3f getScale() {
		return scale;
	}

	public Mesh getMesh() {
		return mesh;
	}
}