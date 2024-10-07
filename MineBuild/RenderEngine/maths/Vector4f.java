package RenderEngine.maths;

public class Vector4f {
	private float x, y, z, p;

	public Vector4f(float x, float y, float z, float p) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.p = p;
	}
	
	public void set(float x, float y, float z, float p) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.p = p;
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Float.floatToIntBits(x);
		result = prime * result + Float.floatToIntBits(y);
		result = prime * result + Float.floatToIntBits(z);
		result = prime * result + Float.floatToIntBits(p);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vector4f other = (Vector4f) obj;
		if (Float.floatToIntBits(x) != Float.floatToIntBits(other.x))
			return false;
		if (Float.floatToIntBits(y) != Float.floatToIntBits(other.y))
			return false;
		if (Float.floatToIntBits(z) != Float.floatToIntBits(other.z))
			return false;
		if (Float.floatToIntBits(p) != Float.floatToIntBits(other.p))
			return false;
		return true;
	}

	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

	public float getZ() {
		return z;
	}

	public void setZ(float z) {
		this.z = z;
	}
	
	public float getP() {
		return p;
	}

	public void setP(float p) {
		this.p = p;
	}
}