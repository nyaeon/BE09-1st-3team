package frozen.admin.dto;

public class AdminDTO {


    private String menuName;
    private String ingredients;
    private String method;
    private String time;
    private int level;

    public AdminDTO() {
        this.menuName = menuName;
        this.ingredients = ingredients;
        this.method = method;
        this.time = time;
        this.level = level;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
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
        return "📋 메뉴 이름: " + menuName +
                "\n🌿 재료: " + ingredients +
                "\n📖 ======= 조리 방법 ========\n" + method +
                "\n⏱️ 조리 시간: " + time +
                "\n⭐ 난이도: ★" + level +
                "\n------------------------------------------------------";

    }
}
