import java.util.ArrayList;
import java.util.List;

public class searchBfs {
    public searchBfs() {

    }
    public List<Node> BFSsearch (Node root){
        List<Node> waytogoal=new ArrayList();
        List<Node> openlist=new ArrayList();
        List<Node> closelist=new ArrayList();
        openlist.add(root);
        boolean reachthegoal=false;
        while(openlist.size()>0&&!reachthegoal){
            Node currentNode=openlist.get(0);
            closelist.add(currentNode);
            openlist.remove(0);
            currentNode.Expandmove();
            currentNode.printpuzzel();
            for(int i=0;i<currentNode.children.size();i++) {
                Node currentchild=currentNode.children.get(i);
                if(currentchild.isgoal(currentchild.getData())) {
                    System.out.println("the goal is found");
                    reachthegoal=true;
                    pathshow(waytogoal,currentchild);
                }
                if(!compleate(openlist, currentchild)&&!compleate(closelist, currentchild)) {
                    openlist.add(currentchild);
                }
            }
        }

        return waytogoal;

    }
    public void pathshow(List<Node>path,Node n) {
        System.out.println("the path is");
        Node current=n;
        path.add(current);
        while(current.parent!=null) {
            current=current.parent;
            path.add(current);
        }
    }
    public static boolean compleate(List<Node>LISTOfNODE,Node c) {
        boolean compleate=false;
        for(int i=0;i<LISTOfNODE.size();i++) {
            if(LISTOfNODE.get(i).IsSameArrayInLastNode(c.data))
                compleate=true;
        }

        return compleate ;
    }
}
