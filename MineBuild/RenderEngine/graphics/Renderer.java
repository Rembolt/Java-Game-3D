package RenderEngine.graphics;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL30;

import RenderEngine.io.WindowManager;
import RenderEngine.maths.Matrix4f;
import RenderEngine.objects.Camera;
import RenderEngine.objects.GameObject;

public class Renderer {
	private Shader shader;
	private WindowManager window;
	
	public Renderer(WindowManager window, Shader shader) {
		this.shader = shader;
		this.window = window;
	}
	
	public void renderMesh(GameObject object, Camera camera) {
		if(object.getMesh().getMaterial().getPath() != "air") {
			GL30.glBindVertexArray(object.getMesh().getVAO());
			GL30.glEnableVertexAttribArray(0);
			GL30.glEnableVertexAttribArray(1);
			GL30.glEnableVertexAttribArray(2);
			GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, object.getMesh().getIBO());
			GL13.glActiveTexture(GL13.GL_TEXTURE0);
			GL13.glBindTexture(GL11.GL_TEXTURE_2D, object.getMesh().getMaterial().getTextureID());
			shader.bind();
			shader.setUniform("model", Matrix4f.transform(object.getPosition(), object.getRotation(), object.getScale()));
			shader.setUniform("view", Matrix4f.view(camera.getPosition(), camera.getRotation()));
			shader.setUniform("projection", window.getProjectionMatrix());
			GL11.glDrawElements(GL11.GL_TRIANGLES, object.getMesh().getIndices().length, GL11.GL_UNSIGNED_INT, 0);
			shader.unbind();
			GL15.glBindBuffer(GL15.GL_ELEMENT_ARRAY_BUFFER, 0);
			GL30.glDisableVertexAttribArray(0);
			GL30.glDisableVertexAttribArray(1);
			GL30.glDisableVertexAttribArray(2);
			GL30.glBindVertexArray(0);
		}
		
	}
}