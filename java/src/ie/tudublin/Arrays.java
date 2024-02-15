package ie.tudublin;

import processing.core.PApplet;



public class Arrays extends PApplet
{
	String[] months = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};

	float[] rainfall = {200, 250, 200, 150, 100, 50, 20, 40, 67, 160, 100, 120};

	int mode = 0;

	public float map1(float a, float b, float c, float d, float e)
	{
		float r1 = c -b;
		float r2 = e - d;

		float howFar = a - b;
		return d + (howFar / r1) * r2;
	}

	/*void randomize()
	{
		for (int i = 0; i < rainfall.length; i++) {
			rainfall[i] = rainfall[i];
		}
	}*/

	public void settings()
	{
		size(500, 500);

		String[] m1 = months;
		months[0] = "JAN";
		print(m1[0]);
		for(int i = 0; i < months.length; i ++)
		{
			println("Month: " + months[i] + "\t" + rainfall[i]);
		}
		for (String s : m1) {
			println(s);
		}

		int minIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] < rainfall[minIndex])
			{
				minIndex = i;
			}
		}
		
		int maxIndex = 0;
		for(int i= 0 ; i < rainfall.length ; i ++)
		{
			if (rainfall[i] > rainfall[maxIndex])
			{
				maxIndex = i;
			}
		}

		println("The month with the minimum rainfall was " + months[minIndex] + " with " + rainfall[minIndex] + "rain");
		println("The month with the max rainfall was " + months[maxIndex] + " with " + rainfall[maxIndex] + "rain");
		
		
		float tot = 0;
		for(float f:rainfall)
		{
			tot += f;
		}

		float avg = tot / (float) rainfall.length;

		// a b-c d-e;
		println(map1(5, 0, 10, 0, 100));
		// 50

		println(map1(25, 20, 30, 200, 300));
		// 250

		println(map1(26, 25, 35, 0, 100));
		// 10 


	}

	public void setup() {
		colorMode(HSB, 360, 100, 100);
		background(0);
		//randomize();
	}
	
	public void draw()
	{

		background(0);
		float w = width / (float)months.length;

		//x-axis
		stroke(255);
		line(50, height - 50, width - 50, height - 50);
		
		//y-axis
		line(50, height - 50, 50, 50);

		//y-axis text
		textAlign(RIGHT, CENTER);
		for(int i = (int) 0; i <= 450; i += 50)
		{
			float y = map1(i, 0, 450, height - 50, 50);
			line(50, y, 55, y);
			text(i, 45, y);
		}

		textAlign(CENTER, CENTER);


		for(int i = 1 ; i < months.length ;  i ++)
		{
			float x = map1(i, 0, months.length - 1, 50, width - 50);
			line(x, height - 50, x, height - 45);

		// 	fill(map(i,0,months.length - 1, 0, 255), 255, 255);
		
			{
			// code for a scatter plot trend line
				float y = map1(rainfall[i], 0, 450, height - 50, 50);
				float y2 = map1(rainfall[i-1], 0, 450, height - 50, 50);
				float x2 = map1(i-1, 0, months.length - 1, 50, width - 50);
				line(x, y, x2, y2);
			}	

		

		//  bar chart rectangles
		//	rect(x, height - 50, w-5, -map1(rainfall[i], 0, 500, 0, height - 50));
			fill(255);
			
			// Text for the months		
			text(months[i], (x + w / 2) - 25, height - 30);
		}
		// Text for the january 
		text(months[0], 50, height - 30);
		

	}
}
