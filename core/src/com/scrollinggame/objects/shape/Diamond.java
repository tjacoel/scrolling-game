package com.scrollinggame.objects.shape;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.EarClippingTriangulator;
import com.badlogic.gdx.utils.ShortArray;
import com.scrollinggame.objects.Shape;

public class Diamond extends Shape {

	@Override
	public void draw(float centerX, float centerY, float size) {
		size = size*1.2f;
		
		float origX = centerX - size/2;
		float origY = centerY - size/2;
		
		float[] points = new float[] {
			origX + size/2,     origY,
			origX + size*9/10,  origY + size/2,
			origX + size/2,     origY + size,
			origX + size/10,    origY + size/2,
		};
		
		ShortArray triangles = new EarClippingTriangulator().computeTriangles(points);
		
		ShapeRenderer renderer = new ShapeRenderer();
		renderer.begin(ShapeType.Filled);
		renderer.setColor(color);
		
		int i=0, j, k;
		
		while (i < triangles.size) {
			j = i+1;
			k = i+2;
			
			renderer.triangle(
				points[triangles.get(i)*2], points[triangles.get(i)*2+1],
				points[triangles.get(j)*2], points[triangles.get(j)*2+1],
				points[triangles.get(k)*2], points[triangles.get(k)*2+1]
			);
			
			i += 3;
		}
		renderer.end();
	}
}
