package day6.part1;

import java.util.ArrayList;
import java.util.List;

public class TreeNode<T> {
    private T data;
    private List<TreeNode<T>> children;

    public TreeNode(T data) {
        this.data = data;
        this.children = new ArrayList<>();
    }

    public TreeNode(T data, List<TreeNode<T>> children) {
        this.data = data;
        this.children = children;
    }

    public void addChild(TreeNode<T> child){
        children.add(child);
    }

    public List<TreeNode<T>> getChildren() {
        return children;
    }

    public T getData() {
        return data;
    }

    public int calculateDepthOf(T target){
        for(TreeNode<T> child : getChildren()){
            if(child.getData().equals(target))
                return 1;
            else if (child.contains(target))
                return 1 + child.calculateDepthOf(target);
        }
        return 0;
    }

    public boolean contains(T target){
        boolean found = false;
        for(TreeNode<T> child : getChildren()){
            if(child.getData().equals(target)) {
                found = true;
                break;
            }
            else {
                found = child.contains(target);
                if(found)
                    break;
            }
        }
        return found;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "data=" + data +
                ", children=" + children.toString() +
                "}";
    }
}
