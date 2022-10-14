import java.util.*;

public class Node{
    public List<Float> data = new ArrayList<>;
    public float value;


    public Node(float ... a, float state){
        for (float dataPoint : a){
            data.add(dataPoint);
        }
        value = state;
    }

    public void checkValues(){
        for (float dataPoint: data){
            System.out.println(dataPoint);

        }
    }
}