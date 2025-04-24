package frozen.common.domain;

import org.w3c.dom.Text;

public class Recipe {

    private String name;
    private String ingredients;
    private String method;
    private String time;
    private int level;

    public Recipe() {
    }

    public Recipe(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "name='" + name + '\'' +
                ", ingredients='" + ingredients + '\'' +
                ", method=" + method +
                ", time='" + time + '\'' +
                ", level=" + level +
                '}';
    }
}
