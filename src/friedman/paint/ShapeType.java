package friedman.paint;

public enum ShapeType {
	FilledRectangle(FillRectangleListener.class),Rectangle(DrawRectangleListener.class),
	FilledOvale(FillOvalListener.class),Oval(DrawOvalListener.class);
	
	private Class c;
	ShapeType(Class c, ){
		this.setC(c);
	}
	public Class getC() {
		return c;
	}
	private void setC(Class c) {
		this.c = c;
	}
}
