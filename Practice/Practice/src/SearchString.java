import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchString {
    String testForSearch = "When you first start to evaluate a cloud DEhjhhk migration, the decisions to be made, stakeholders who need to be involved, it can sometimes feel overwhelming – and with good reason. A move to the cloud can take time, resources, and manpower, and while companies are nearly universally glad they made those investments, that doesn't cancel out the fact that they take strategic planning and up-front work."
            + "What do you need to plan for? Who DE needs to be involved (and when)? What roles and responsibilities need to be divided up? The answers vary a bit depending on your company size, the scope of your migration, and whether you have the budget (or need) for a migration partner."
            + "Below are the typical roles de and responsibilities Daniel Denniss Deuteronomy Destruction ......death, (deceased,we see from successful migrations – and some tips to prepare your team for success. Because without the right team in place, missed deadlines, duplicative work, and post-migration workflow issues become much greater risks.";

    public void findPrefix (){
        Pattern pattern =Pattern.compile("(\\W)(?)de(\\w*)",Pattern.CASE_INSENSITIVE);
        Matcher matcher= pattern.matcher(testForSearch);
        System.out.println("The following words begin with de: ");
        while(matcher.find()){
            System.out.println(matcher.group());
        }
    }

    public static void main(String[] args){
        SearchString search = new SearchString();
        search.findPrefix();
    }
}
