import java.util.*;

public class BusinessLogic {


    private static Map<String, Set<String>> buildParentMap(List<Entity.Child> children) {
        final Map<String, Set<String>> parentMap = new HashMap<>();
        for (Entity.Child child : children) {
            if (!parentMap.containsKey(child.getParentName())) {
                parentMap.put(child.getParentName(), new HashSet<String>());
            }
            parentMap.get(child.getParentName()).add(child.getName());
        }
        return parentMap;
    }

    private static void print(String root, int level, Map<String, Set<String>> parentMap) {
        if (parentMap.containsKey(root))
            for (String name : parentMap.get(root)) {
                if (level > 0) {
                    System.out.printf("%" + level * 2 + "s%s%n", "", name);
                } else {
                    System.out.println(name);
                }
                print(name, level + 1, parentMap);
            }
    }

    public static void print(List<Entity.Child> children) {
        final Map<String, Set<String>> childrenParentsMap = buildParentMap(children);
        print(null, 0, childrenParentsMap);
    }
}