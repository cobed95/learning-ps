import java.util.*;

public class SkillTree {
    private ArrayList<Skill> roots;

    public SkillTree(ArrayList<Skill> skills) {
        ArrayList<SkillTreeNode> nodes = createNodes(skills);
    }

    public ArrayList<SkillTreeNode> createNodes(ArrayList<Skill> skills) {
        ArrayList<SkillTreeNode> nodes = new ArrayList<SkillTreeNode>();
        for (Skill skill : skills) {
            nodes.add(new SkillTreeNode(skill));
        }
        return nodes;
    }

    public void createEdges(ArrayList<SkillTreeNode> nodes) {
        for (SkillTreeNode node : nodes) {

        }
    }

    public void setParents(ArrayList<SkillTreeNode> nodes) {

    }
}
