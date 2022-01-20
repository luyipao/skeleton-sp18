public class Planet
{
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public Planet(double xP, double yP, double xV, double yV, double m, String img)
    {
	this.xxPos = xP;
	this.yyPos = yP;
	this.xxVel = xV;
	this.yyVel = yV;
	this.mass = m;
	this.imgFileName = img;
    }
    public Planet(Planet b)
    {
	this.xxPos = b.xxPos;
	this.yyPos = b.yyPos;
	this.xxVel = b.xxVel;
	this.yyVel = b.yyVel;
	this.mass = b.mass;
	this.imgFileName = b.imgFileName;
	
    }
    public double calcDistance(Planet a)
    {
	double xdist = this.xxPos - a.xxPos;
	double ydist = this.yyPos - a.yyPos;
	return Math.sqrt(xdist*xdist + ydist*ydist);	
    }
    public double calcForceExertedBy(Planet a)
    {
	double dist = this.calcDistance(a);
        return 6.67e-11 * this.mass * a.mass / dist / dist;
    }
    public double calcForceExertedByX(Planet a)
    {
	double force = this.calcForceExertedBy(a);
	double dist = this.calcDistance(a);
	double xdist = this.xxPos - a.xxPos;
	double xforce = - xdist * force / dist;
	return xforce;
    }
    public double calcForceExertedByY(Planet a)
    {
	double force = this.calcForceExertedBy(a);
	double dist = this.calcDistance(a);
	double ydist = this.yyPos - a.yyPos;
	double yforce = - ydist * force / dist;
	return yforce;
    }
    public double calcNetForceExertedByX(Planet[] planets)
    {
	double xforce = 0;
	for(Planet p : planets)
	{
	    if(this.equals(p))
		continue;
	    else
		xforce += this.calcForceExertedByX(p);
	}
	return xforce;
    }
    public double calcNetForceExertedByY(Planet[] planets)
    {
	double yforce = 0;
	for(Planet p : planets)
	{
	    if(this.equals(p))
		continue;
	    else
		yforce += this.calcForceExertedByY(p);
	}
	return yforce;
    }
    
    public void update(double dt, double xforce, double yforce)
    {
	this.xxVel += dt * xforce / this.mass;
	this.yyVel += dt * yforce / this.mass;
	this.xxPos += dt * this.xxVel;
	this.yyPos += dt * this.yyVel;
    }
    public void draw()
    {
	StdDraw.picture(this.xxPos, this.yyPos, this.imgFileName);
    }
}
