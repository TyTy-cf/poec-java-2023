package fr.ktourret.poec.courses.entity.shape;

public abstract class AbstractShape {

    private static long ID = 1L;

    protected long id;

    public AbstractShape() {
        this.id = AbstractShape.ID;
        AbstractShape.ID++;
    }

    public long getId() {
        return id;
    }

    public abstract double calculateArea();

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" (");
        sb.append(id);
        sb.append(")");
        return sb.toString();
    }
}
