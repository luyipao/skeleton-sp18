public class NBody
{
    private static String imageToDraw = "images/starfield.jpg";
    
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
	for(int i = 0; i < temp; i ++)
	{
	    Planet[i] = new Planet(in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(), in.readDouble(),  in.readString());
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
		xForces[i] = Planets[i].calcNetForceExertedByX(Planets);
		yForces[i] = Planets[i].calcNetForceExertedByY(Planets);
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
