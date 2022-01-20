public class NBody
{
    public static String imageToDraw = "images/starfield.jpg";
    
    public static double readRadius(String filename)
    {
	In in = new In(filename);
	//I don't why its right.
	int temp = in.readInt();
	double radius = in.readDouble();
	return radius;
    }
    public static Planet[] readPlanets(String filename)
    {
	In in = new In(filename);
	int temp = in.readInt();
	double radius = in.readDouble();
	Planet[] Planets = new Planet[temp];
	while(temp > 0)
	{
	    Planets[5 - temp] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), "images/" + in.readString()/*pay attention there is a "images"*/);
	    temp--;
	}
	return Planets;
    }
    public static void main(String[] args)
    {
	double T = Double.parseDouble(args[0]);
	double dt = Double.parseDouble(args[1]);
	String filename = args[2];
	double radius = readRadius(filename);
	Planet[] Planets = readPlanets(filename);

	StdDraw.setScale(-radius, radius);
	StdDraw.clear();
	StdDraw.picture(0, 0, "images/starfield.jpg");
	for(int i = 0; i < Planets.length; i++)
	    Planets[i].draw();

	StdDraw.enableDoubleBuffering();
	double time = 0;
	while(time < T)
	{
	    double[] xForces = new double[Planets.length];
	    double[] yForces = new double[Planets.length];
	    
	    for(int i = 0; i < Planets.length; i++)
	    {
		for(int j = 0; j < Planets.length; j++)
		{
		    if(j == i)
			break;
		    else
			xForces[i] += Planets[i].calcForceExertedByX(Planets[j]);
			yForces[i] += Planets[i].calcForceExertedByY(Planets[j]);
		}
	    }
	    for(int i = 0; i < Planets.length; i++)
		Planets[i].update(dt, xForces[i], yForces[i]);
	    StdDraw.clear();
	    StdDraw.picture(0, 0, imageToDraw);
	    for(int i = 0; i < Planets.length; i++)
		Planets[i].draw();	    
	    StdDraw.show();
	    StdDraw.pause(10);
	    time += dt;	    
	}
	StdOut.printf("%d\n", Planets.length);
	StdOut.printf("%.2e\n", radius);
	for(int i = 0; i < Planets.length; i++)
	{
	    StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n", Planets[i].xxPos, Planets[i].yyPos, Planets[i].xxVel, Planets[i].yyVel, Planets[i].mass, Planets[i].imgFileName);
	}
    }
}
