import java.util.regex.*;

public class RegexExample {
    Pattern pattern;
    Matcher matcher;
    String string1 = "app=edi_adapter_converter wingtipsTrace=8faeae6709355291 INFO  OrderCreateClient - action=EDIOrderSent originalFilename=Integration_test_Contract customerName=0005084863 orderUUID=d34149d8-88ab-4791-bb0a-46c96e034200 poNum=Test_TS5155079515 lineCount=3";
    String string2="test 2667843 (test_email@griddynamics.com) test 67483 some string";
    //Task 1
    public boolean hasOrderUuid(){
        pattern= Pattern.compile("orderUUID");
        matcher= pattern.matcher(string1);
        if (matcher.find()){
            return true;
        }
        return false;
    }

    //Task 2
    public void getOrderUuid(){
        pattern= Pattern.compile("orderUUID=(\\S*)");
        matcher= pattern.matcher(string1);
        if (matcher.find()){
            System.out.println("Found "+ matcher.group());
        }else{
            System.out.println("Cannot find order");
        }
    }




    public static void main(String[] args){
        RegexExample rg = new RegexExample();
            System.out.println("Has orderUUID ? "+ rg.hasOrderUuid());
            System.out.println(rg.getOrderUuid());
    }
}
