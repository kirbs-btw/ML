import java.util.*;


public class Main {

    public static List<List<Float>> distance(Node inputNode, List<OutputNode> outputLayer){
        List<List<Float>> distSet = new ArrayList<>();

        for (OutputNode outputNode : outputLayer){
            float diffSqareSum = 0;
            for (int i = 0; i < outputNode.data.size(); i++){
                float diff = inputNode.data.get(i) - outputNode.data.get(i);
                diffSqareSum = diffSqareSum + (diff * diff);
            }
            float dist = (float) Math.sqrt(diffSqareSum);
            List<Float> distValue = new ArrayList<>();
            distValue.add(outputNode.value);
            distValue.add(dist);

            distSet.add(distValue);
        }

        return distSet;
    }


    public static List<List<Float>> bubbleSort(List<List<Float>> arr){
        List<Float> smaller = new ArrayList<>();
        List<Float> bigger = new ArrayList<>();
        boolean run = true;


        for (int i = 0; i < arr.size() && run; i++) {
            run = false;

            for (int y = 0; y < arr.size()-1; y++) {
                System.out.println(arr.get(1));
                System.out.println(arr.get(1).get(1));


                if(arr.get(y).get(1) > arr.get(y + 1).get(1)) {
                    bigger = arr.get(y);
                    smaller = arr.get(y + 1);
                    arr.set(y, smaller);
                    arr.set(y + 1, bigger);
                    run = true;
                }
            }
        }

        return arr;
    }

    public static List<List<Float>> slice(List<List<Float>> arr, int slice){
        List<List<Float>> newArr = new ArrayList<>();
        newArr = arr.subList(0, slice);

        return newArr;
    }

    public static int whereInArr(List<List<Integer>> arr, int num){

        for (int i = 0; i < arr.size(); i++){
            if (num == arr.get(i).get(0)){
                return i;
            }
        }
        return -1;
    }

    public static List<List<Integer>> classify(List<List<Float>> arr){
        List<List<Integer>> countArr = new ArrayList<>();

        for(List<Float> littleArr : arr){
            int item = Math.round(littleArr.get(0));
            int foundIndex = whereInArr(countArr, item);
            if (whereInArr(countArr, item) == -1){
                List<Integer> addArr = new ArrayList<>();
                int a = item;
                addArr.add(item);
                addArr.add(1);
                countArr.add(addArr);
            }
            else{
                int a = countArr.get(foundIndex).get(1);
                countArr.get(foundIndex).set(1, a+1);
            }
        }

        return countArr;
    }


    public static void main(String[] args) {
        Random random = new Random();
        int k = 10;
        List<OutputNode> outputLayer = new ArrayList<>();
        Node inputNode = new Node(0, 0.4f, 0.1f);

        for (int i = 0; i < 50; i++){
            OutputNode a = new OutputNode((float)random.nextInt(0, 5), random.nextFloat(-1, 1), random.nextFloat(-1, 1), random.nextFloat(-1, 1));
            outputLayer.add(a);
        }

        System.out.println(bubbleSort(distance(inputNode, outputLayer)));
        List<List<Float>> a = bubbleSort(distance(inputNode, outputLayer));
        System.out.println((slice(a, 10)));
        List<List<Float>> b = slice(a, 10);
        System.out.println(classify(b));
    }
}