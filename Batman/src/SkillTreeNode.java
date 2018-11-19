import java.util.*;

public class SkillTreeNode {
    private Skill skill;
    private SkillTreeNode parent;
    private ArrayList<SkillTreeNode> children;

    public SkillTreeNode(Skill skill) {
        this.skill = skill;
    }

    public Skill getRequire() {
        return this.skill.getRequire();
    }

    public Skill getSkill() { return this.skill; }

    public SkillTreeNode getParent() {
        return this.parent;
    }

    public ArrayList<SkillTreeNode> getChildren() {
        return this.children;
    }

    public void setParent(SkillTreeNode parent) {
        this.parent = parent;
    }

    public void addChild(SkillTreeNode child) {
        this.children.add(child);
    }

    public boolean equals(Object o) {
        if (o instanceof SkillTreeNode) {
            SkillTreeNode other = (SkillTreeNode) o;
            return this.getSkill().equals(other.getSkill());
        }
        return false;
    }
}
