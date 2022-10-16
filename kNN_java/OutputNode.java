public class OutputNode extends Node{
    public float value;

    public OutputNode(float state, float ... a){
        for (float dataPoint : a){
            data.add(dataPoint);
        }
        value = state;
    }

}