public class ProblemSolvingQuerySoulution {


    //Solution for first Quest
    public static String getValidName(String name) {
        String validName = "";
        String revName = "";
        char[] characters = name.toCharArray();
        boolean rev = false;

        for (char c:characters) {
            if(rev){
                if(c==')'){
                    rev=!rev;
                    validName+=revName;
                    revName="";
                    continue;
                }
                revName=c+revName;
                continue;
            }

            if(c!='('&&c!=')'){
                validName +=c;
            } else if (c=='(') {
                rev=!rev;
            }
        }

        return validName;
    }



//    Solution for Second Question Query on db

    /*select u.user_id,u.username, t.user_id, t.training_date, count(t.training_id) as count
    from training_details t join users u on (u.user_id = t.user_id)
    group by u.user_id,u.username,t.user_id, t.training_id, t.training_date
    having count(t.training_id)>1
    order by t.training_date desc;*/

}
