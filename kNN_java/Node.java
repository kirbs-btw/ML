import java.util.*;

public class Node{
    public List<Float> data = new ArrayList<>();


    public Node(float ... a){
        for (float dataPoint : a){
            data.add(dataPoint);
        }
    }

    public void checkValues(){
        for (float dataPoint: data){
            System.out.println(dataPoint);
        }
    }
}