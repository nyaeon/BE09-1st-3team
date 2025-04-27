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

    public Recipe(String name, String ingredients, String method, String time, int level) {
        this.name = name;
        this.ingredients = ingredients;
        this.method = method;
        this.time = time;
        this.level = level;
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
        return "📋 메뉴 이름: " + name +
                "\n🌿 재료: " + ingredients +
                "\n==============================" +
                "\n📖🍳🥚️️️☁️ 조리 방법 ☁️🥚🍳📖\n" + method +
                "\n==============================" +
                "\n⏱️ 조리 시간: " + time +
                "\n⭐ 난이도: ★" + level +
                "\n------------------------------------------------------";
    }
}
