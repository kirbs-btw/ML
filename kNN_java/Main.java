import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<List<Float>> distance(List<Node> inputLayer, List<Node>outputLayer){
        List<List<Float>> distSetList = new ArrayList<>();

        for (Node nodeInput : inputLayer){

            List<Float> distSet = new ArrayList<>();
            for (Node nodeOutput : outputLayer){
                float diffSqareSum = 0f;
                for (int i = 0; i < nodeInput.data.size(); i++){
                    float opinionDiff = nodeInput.data.get(i) - nodeOutput.data.get(i);
                    diffSqareSum = diffSqareSum + opinionDiff * opinionDiff;
                }
                float dist = (float) Math.sqrt(diffSqareSum);
                distSet.add(dist);
            }
            distSetList.add(distSet);
        }
        return distSetList;
    }


    public static void main(String[] args) {
        List<Node> outputLayer = new ArrayList<>();
        List<Node> inputLayer = new ArrayList<>();






    }
}