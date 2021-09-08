public class Entity {
    public static class Child {
        private String name;
        private String parentName;

        public Child(String name, String parentName) {
            this.name = name;
            this.parentName = parentName;
        }

        public String getName() {
            return name;
        }

        public String getParentName() {
            return parentName;
        }

    }
}
