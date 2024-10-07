package RenderEngine.maths;

import org.lwjglx.util.vector.Matrix4f;


public class MathsToLibrary {
		
	public static Matrix4f reverseToLib(RenderEngine.maths.Matrix4f matrixMe) {
		Matrix4f result = new Matrix4f();
		
		result.m00 = matrixMe.elements[0];
		result.m01 = matrixMe.elements[1];
		result.m02 = matrixMe.elements[2];
		result.m03 = matrixMe.elements[3];
		result.m10 = matrixMe.elements[4];
		result.m11 = matrixMe.elements[5];
		result.m12 = matrixMe.elements[6];
		result.m13 = matrixMe.elements[7];
		result.m20 = matrixMe.elements[8];
		result.m21 = matrixMe.elements[9];
		result.m22 = matrixMe.elements[10];
		result.m23 = matrixMe.elements[11];
		result.m30 = matrixMe.elements[12];
		result.m31 = matrixMe.elements[13];
		result.m32 = matrixMe.elements[14];
		result.m33 = matrixMe.elements[15];
		
		return result;
	}
	
	public static RenderEngine.maths.Matrix4f Inverse(RenderEngine.maths.Matrix4f matrix) {
		Matrix4f result = new Matrix4f();
		
		result = reverseToLib(matrix);
		result = Matrix4f.invert(result, null);
		matrix = reverseToMe(result);
		
		return matrix;
	}
	
	public static RenderEngine.maths.Matrix4f reverseToMe(Matrix4f result) {
		RenderEngine.maths.Matrix4f matrixMe= new RenderEngine.maths.Matrix4f();
		
		matrixMe.elements[0] = result.m00;
		matrixMe.elements[1] = result.m01;
		matrixMe.elements[2] = result.m02;
		matrixMe.elements[3] = result.m03;
		matrixMe.elements[4] = result.m10;
		matrixMe.elements[5] = result.m11;
		matrixMe.elements[6]= result.m12;
		matrixMe.elements[7]= result.m13;
		matrixMe.elements[8]= result.m20;
		matrixMe.elements[9]= result.m21;
		matrixMe.elements[10]= result.m22;
		matrixMe.elements[11]= result.m23;
		matrixMe.elements[12]= result.m30;
		matrixMe.elements[13]= result.m31;
		matrixMe.elements[14]= result.m32;
		matrixMe.elements[15]= result.m33;
		
		return matrixMe;
	}
	
}
