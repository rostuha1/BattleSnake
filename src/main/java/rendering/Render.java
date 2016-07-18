package rendering;

public interface Render {

    void render();

    default void add()  {
        MainRenderer.addRender(this);
    }

}
