public class Planet
{
    double xxPos;
    double yyPos;
    double xxVel;
    double yyVel;
    double mass;
    String imgFileName;
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
	double xforce = xdist * force / dist;
	return (xforce >= 0) ? xforce : -xforce;
    }
    public double calcForceExertedByY(Planet a)
    {
	double force = this.calcForceExertedBy(a);
	double dist = this.calcDistance(a);
	double ydist = this.yyPos - a.yyPos;
	double yforce = ydist * force / dist;
	return (yforce >= 0) ? yforce : -yforce;
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
