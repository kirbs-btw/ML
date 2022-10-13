import java.util.*;

class NodeHidden extends Node{
    float fac;

    public NodeHidden(float f){
        fac = f;
    }

    public void bias(){

    }

    public void weight(){
        List<Float> biasData = new ArrayList<>();
        for (float dataPoint : data){
            float value = dataPoint * fac;
            biasData.add(value);
        }
        data = biasData;
    }
}