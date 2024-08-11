import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Resource {
    private Map<String, Integer> resources = new HashMap<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public Resource(){
    }

    void setResource(String resourceName){
        System.out.println("\n현재 자원의 양: "+resources.get(resourceName));
    }

    void putResource(String resourceName) throws IOException {
        System.out.println();
        System.out.println("자원이름: "+resourceName);
        System.out.print("자원의 양: ");
        String resourceQuantity = br.readLine();
        int resourceQuantityToSet=Integer.parseInt(resourceQuantity);

        if (resourceQuantityToSet<=0){
            System.out.println();
            System.out.println("양수로 입력해주세요");
            putResource(resourceName);
        }

        else{
            resources.put(resourceName, resourceQuantityToSet);
        }
    }

    void addResourceQuantity(String resourceName) throws IOException {
        if (resources.containsKey(resourceName)){
            setResource(resourceName);
            System.out.print("더할 자원의 양: ");
            String resourceQuantity = br.readLine();
            int resourceQuantityToAdd = Integer.parseInt(resourceQuantity);

            if (resourceQuantityToAdd<=0){
                System.out.println();
                System.out.println("양수로 입력해주세요");
                addResourceQuantity(resourceName);
            }

            else{
                resources.replace(resourceName, resources.get(resourceName)+resourceQuantityToAdd);
            }
        }
        else{
            System.out.println();
            System.out.print(resourceName+"라는 이름의 자원이 존재하지 않습니다.");
            System.out.println();
        }
    }

    void useResourceQuantity(String resourceName) throws IOException {
        if (resources.containsKey(resourceName)){
            setResource(resourceName);
            System.out.print("사용할 자원의 양: ");
            String resourceQuantity = br.readLine();
            int resourceQuantityToUse = Integer.parseInt(resourceQuantity);

            if (resources.get(resourceName)-resourceQuantityToUse<=0){
                System.out.println();
                System.out.println("사용할 자원의 양이 현재 존재하는 자원의 양보다 많습니다.");
                System.out.println("다시 입력해주세요.");
                useResourceQuantity(resourceName);
            }
            else if (resourceQuantityToUse<=0) {
                System.out.println();
                System.out.println("양수로 입력해주세요");
                useResourceQuantity(resourceName);

            }
            else{
                resources.replace(resourceName, resources.get(resourceName)-Integer.parseInt(resourceQuantity));
            }
        }
        else{
            System.out.println();
            System.out.print(resourceName+"라는 이름의 자원이 존재하지 않습니다.");
            System.out.println();
        }
    }

    void printResourceInformation(String resourceName){
        if (resources.containsKey(resourceName)){
            System.out.println();
            System.out.println("-------------------------");
            System.out.println();
            System.out.println(" 자원 정보");
            System.out.println("\t- 자원 이름: "+resourceName);
            System.out.println("\t- 자원의 양: "+resources.get(resourceName));
            System.out.println();
            System.out.println("-------------------------");
        }
        else{
            System.out.println();
            System.out.println(resourceName+"라는 이름의 자원 정보를 조회할 수 없습니다.");
            System.out.println();
        }
    }
}
